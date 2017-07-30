package com.nuvizz.JobRepository.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.JobRepository.controller.JobController;
import com.nuvizz.JobRepository.dao.LoginDAOImpl;
import com.nuvizz.JobRepository.dto.APIResponse;
import com.nuvizz.JobRepository.dto.LoginAction;
import com.nuvizz.JobRepository.dto.UserDTO;

@Component
public class LoginServiceImpl implements LoginServiceI {

	@Autowired
	private LoginDAOImpl daoImpl;

	Logger logger = LoggerFactory.getLogger(JobController.class);

	/*public String[] metService(UserDTO dto) {

		String[] flag = daoImpl.mapUser(dto);
		return flag;
	}
*/
	public UserDTO authenticateUserService(UserDTO dto) {

		logger.info("Starting Autinivate User Service");
		UserDTO userDTO = null;
		try {

			if ((dto.getEmailid() != null) && (dto.getPassword() != null)) {

				userDTO = daoImpl.authenticate(dto);
				return userDTO;

			}

		} catch (Exception e) {

			logger.error("error" + e.getMessage());

		}

		logger.info("ending User Service");

		return null;

	}


	public void processLoginAndSetLoginResponse(LoginAction loginActionData,
			APIResponse apiResponse) {
		
		logger.info("starting User Service restservice");
		try {

			if ((loginActionData.getEmailid() != null)
					&& (loginActionData.getPassword() != null)) {
				daoImpl.authenticateRestUser(loginActionData.getEmailid(),
						loginActionData.getPassword(), apiResponse);
			} else {
				apiResponse.setStatus("EmailId/Password is wrong");
				return;
			}

		} catch (Exception e) {
			// logger.error("error" + e.getMessage());
			
			apiResponse.setStatus("Unexpected error." + e.getMessage());
		}
		logger.info("ending User Service restservice");
	}

}