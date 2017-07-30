package com.nuvizz.JobRepository.dao;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.JobRepository.dto.APIResponse;
import com.nuvizz.JobRepository.dto.LoginResponse;
import com.nuvizz.JobRepository.dto.RoleDTO;
import com.nuvizz.JobRepository.dto.UserDTO;
import com.nuvizz.JobRepository.util.UserToken;

@Component
public class LoginDAOImpl implements LoginDAOI {

	@Autowired
	private SessionFactory factory;

	private Collection<RoleDTO> roleDTOs;

	Logger logger = LoggerFactory.getLogger(JobDAOImpl.class);

	// int counter;
/*
	public String[] mapUser(UserDTO dto) {

		logger.info("Inside mapping dao");

		if (dto != null) {

			try {

				roleDTOs = dto.getRoleDTOs();
				String[] roles = new String[roleDTOs.size()];
				int i = 0;
				for (RoleDTO roleDTO : roleDTOs) {
					System.out.println(roleDTO.getRoleId());
					System.out.println(roleDTO.getRoleName());
					// counter = roleDTOs.size();
					roles[i] = roleDTO.getRoleName();
					i++;
				}
				return roles;
			} catch (HibernateException he) {
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			}
		}
		logger.info("exiting mapping dao");
		return null;

	}*/

	public UserDTO authenticate(UserDTO dto) {

		logger.info("starting authenicate user");
		UserDTO fromDB = null;
		String emailid = dto.getEmailid();
		String pass = dto.getPassword();

		if (dto != null) {
			Session session = null;
			Transaction tx = null;
			try {
				session = factory.openSession();

				String s1 = "select l from UserDTO l where l.emailid=:emailid and l.password=:pass";

				Query q = session.createQuery(s1);
				q.setParameter("emailid", emailid);
				q.setParameter("pass", pass);
				fromDB = (UserDTO) q.uniqueResult();

				String emaiid = fromDB.getEmailid();
				//String upassword = fromDB.getPassword();

				tx = session.beginTransaction();

				if (fromDB != null) {

					tx = session.beginTransaction();
					String token = UserToken.createID(); // set generated token
					fromDB.setToken(token);
					System.out.println(fromDB);
					String syntax2 = "Update UserDTO u set u.token=:token where u.emailid=:emailid";
					Query query = session.createQuery(syntax2);
					query.setParameter("emailid", emaiid);
					query.setParameter("token", token);
					query.executeUpdate();
					tx.commit();

					return fromDB;

				}
			} catch (Exception e) {
				logger.error("Exception " + e.getMessage());

			} finally {
				session.close();
			}

		}
		logger.info("ending authenicate user");
		return fromDB;

	}

	
	public void authenticateRestUser(String emailid, String upassword,
			APIResponse apiResponse) {
		logger.info("Starting authenticateUserLogin()..");

		LoginResponse loginResponse = new LoginResponse();

		Session session = null;
		Transaction tx = null;
		UserDTO fromDB = null;

		logger.info("email = " + emailid + "password " + upassword);
		try {
			session = factory.openSession();
			String syntax1 = "select l from UserDTO l where l.emailid=:emailid";
			org.hibernate.Query query = session.createQuery(syntax1);
			query.setParameter("emailid", emailid);

			fromDB = (UserDTO) query.uniqueResult();

			if (fromDB != null) {
				logger.info("User with email:" + emailid + " found");
				// TODO: check whether user password matches with json value
				if (fromDB.getPassword().equals(upassword)) {
					logger.info("User password matched.");
					logger.debug(fromDB.toString());
					tx = session.beginTransaction();
					String token = UserToken.createID();
					fromDB.setToken(token);
					logger.debug(fromDB.toString());
					String syntax2 = "Update UserDTO u set u.token=:token where u.emailid=:emailid and u.password=:pass";
					query = session.createQuery(syntax2);
					query.setParameter("emailid", emailid);
					query.setParameter("pass", upassword);
					query.setParameter("token", token);
					query.executeUpdate();
					tx.commit();

					loginResponse.setToken(token);
					apiResponse.setStatus("Login Sucess full");
					apiResponse.setLoginResponse(loginResponse);

					return;

				} else {
					logger.error("Password is wrong for email:" + emailid);
					apiResponse.setStatus("Password is wrong for email:"
							+ emailid);
				}
			} else {
				logger.error("User with email:" + emailid + " not found");
				apiResponse.setStatus("User with email:" + emailid
						+ " not found");
			}

		} catch (Exception e) {
			logger.error("Unexpected error.", e);
			apiResponse.setStatus("Unexpected error." + e.getMessage());
		} finally {
			session.close();
		}
		logger.info("Ending authenticateUserLogin()...");
	}

}