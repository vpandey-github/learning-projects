package com.nuvizz.JobRepository.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.JobRepository.controller.JobController;
import com.nuvizz.JobRepository.dto.CompanyDTO;
import com.nuvizz.JobRepository.dto.JobDTO;

@Component
public class JobDAOImpl implements JobDAOI {

	@Autowired
	private SessionFactory factory;
	Logger logger = LoggerFactory.getLogger(JobController.class);

	public boolean saveJobDAO(JobDTO jobDTO) {

		logger.info("Starting job DAO");
		boolean res = false;
		if (jobDTO != null) {

			Session session = null;
			Transaction transaction = null;
			try {
				session = factory.openSession();
				transaction = session.beginTransaction();
				session.save(jobDTO);
				transaction.commit();
				res = true;
			} catch (HibernateException he) {
				transaction.rollback();
				System.err.println("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}

		}

		logger.info("Ending job DAO");
		return res;

	}

	public List<JobDTO> viewJobDAO(int id) {

		logger.info("Starting view job by id ");
		Session s = null;
		List<JobDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "from JobDTO j where j.userid=:id";
			// String s1 ="from JobDTO";

			Query q = s.createQuery(s1);
			q.setParameter("id", id);

			dtos = q.list();

			if (dtos != null) {

				return dtos;

			}

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}

		logger.info("Starting view job by id ");

		return null;
	}

	public List<JobDTO> viewAllJobDAO() {
		logger.info("Starting view all dao");

		Session s = null;
		List<JobDTO> dtos = null;
		try {
			s = factory.openSession();

			// String s1 = "from JobDTO j where j.UserId=:id";
			String s1 = "from JobDTO";

			Query q = s.createQuery(s1);

			dtos = q.list();

			if (dtos != null) {

				return dtos;

			}

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());

		} finally {
			s.close();
		}
		logger.info("ending view all dao");
		return null;
	}

	public JobDTO clickupdateJobDAO(int id) {

		logger.info("Starting job update DAO");
		JobDTO jobDTO = null;

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			if (id > 0) {

				System.out.println("id is" + id);
				String str = "select p from JobDTO p where p.jobID=:id";

				Query query = session.createQuery(str);

				query.setParameter("id", id);
				jobDTO = (JobDTO) query.uniqueResult();

				// session.saveOrUpdate(jobDTO);

				transaction.commit();

				return jobDTO;
			}
		} catch (HibernateException he) {
			transaction.rollback();
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending dao");

		logger.info("Ending job update DAO");
		return null;

	}

	// updating in the database
	public boolean updateDetailsDAO(JobDTO dto) {
		logger.info("Starting update DAO");
		boolean res = false;
		if (dto != null) {

			Session s = null;
			Transaction t = null;
			try {
				s = factory.openSession();
				t = s.beginTransaction();
				s.saveOrUpdate(dto);
				res = true;
				t.commit();
				return true;

			} catch (HibernateException he) {
				t.rollback();
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				s.close();
			}

		}

		logger.info("Ending update DAO");
		return false;

	}

	public boolean deleteJod(int id) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean res = false;
		try {
			logger.info("entry deleteQuestionDetails");
			if (id > 0) {

				String str = "delete from JobDTO p where p.jobID=" + id;
				Query query = session.createQuery(str);
				query.executeUpdate();

				res = true;
				t.commit();

				return true;
			}

		} catch (Exception he) {
			logger.error("exception inside deleteQuestionDetail()"
					+ he.getMessage());
		}

		logger.info("exit deleteQuestionDetails ");

		return false;
	}

	public boolean markJod(int id) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean res = false;
		try {
			logger.info("entry deleteQuestionDetails");
			if (id > 0) {
				// update Stock set stockName = :stockName"
				String str = "update JobDTO p set p.status=:st where p.jobID="
						+ id;

				Query query = session.createQuery(str);
				query.setParameter("st", "filled");
				query.executeUpdate();

				res = true;
				t.commit();

				return true;
			}

		} catch (Exception he) {
			logger.error("exception inside deleteQuestionDetail()"
					+ he.getMessage());
		}

		logger.info("exit deleteQuestionDetails ");

		return false;
	}

	public List<CompanyDTO> fetchComanyList() {
		Session s = null;
		List<CompanyDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "from CompanyDTO";
			Query q = s.createQuery(s1);
			dtos = q.list();

		} catch (HibernateException he) {
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}

		return dtos;
	}

	public CompanyDTO saveCompany(CompanyDTO company) {
		logger.info("Starting company save");
		if (company != null) {
			Session session = null;
			Transaction transaction = null;
			try {
				session = factory.openSession();
				transaction = session.beginTransaction();
				session.save(company);
				transaction.commit();
				logger.info("Company saved:"+company);
			} catch (HibernateException he) {
				transaction.rollback();
				System.err.println("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}

		}

		logger.info("Ending save company");
		return company;

	}

}
