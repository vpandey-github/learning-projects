package com.nuvizz.JobRepository.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.JobRepository.controller.JobController;
import com.nuvizz.JobRepository.dao.JobDAOImpl;
import com.nuvizz.JobRepository.dto.CompanyDTO;
import com.nuvizz.JobRepository.dto.JobDTO;

@Component
public class JobServiceImpl implements JobServiceI {

	Logger logger = LoggerFactory.getLogger(JobController.class);
	@Autowired
	private JobDAOImpl daoImpl;

	public boolean saveJobService(JobDTO jobDTO) {
		boolean res = false;
		if (jobDTO != null) {
			try {
				res = daoImpl.saveJobDAO(jobDTO);
			} catch (Exception e) {
				logger.error("Exception in job service " + e.getMessage());
				
			}
		}

		logger.info("Ending job Service");

		return res;
	}

	public List<JobDTO> viewJobService(int id) {

		List<JobDTO> dtos = null;
		try {

			dtos = daoImpl.viewJobDAO(id);

			logger.info("service" + dtos.hashCode());

			return dtos;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<JobDTO> viewAllJobService() {
		List<JobDTO> dtos = null;
		try {

			dtos = daoImpl.viewAllJobDAO();

			logger.info("service" + dtos.hashCode());

			return dtos;

		} catch (Exception e) {

		}
		return null;
	}

	public boolean deleteJobs(int id) {

		logger.info("inside deleteDetailsService ");
		boolean flag = false;
		if (id > 0) {
			try {
				flag = daoImpl.deleteJod(id);

			} catch (Exception e) {
				logger.error("exception inside deleteDetailService()"
						+ e.getMessage());
			}
		}
		logger.info("exit from deleteDetailService()");
		return flag;
	}

	public JobDTO clickupdateJobService(int id) {

		logger.info("starting update");
		// JobDTO jobDTO2=null;
		JobDTO jobDTO=null;
		try {

			if (id>0)

			{
			jobDTO=	daoImpl.clickupdateJobDAO(id);
				
				return jobDTO;

			}

		} catch (Exception e) {
			logger.error("Error" + e.getMessage());
			// TODO: handle exception
		}

		logger.info("ending update");
		return null;

		// TODO Auto-generated method stub

	}
	
	
	 public boolean updateService(JobDTO dto) {
		  logger.info("Starting update Service");
		  boolean res = false;
		  if (dto != null) {
		   try {
			   
		    daoImpl.updateDetailsDAO(dto);

		    res=true;
		    return true;
		    
		   } catch (Exception e) {
		    logger.error("Exception in service state " + e);
		   }
		  }

		  logger.info("Ending update Service");
		return false;

		 }
	 
	 public boolean markJobs(int id) {

			logger.info("inside deleteDetailsService ");
			boolean flag = false;
			if (id > 0) {
				try {
					flag = daoImpl.markJod(id);

				} catch (Exception e) {
					logger.error("exception inside deleteDetailService()"
							+ e.getMessage());
				}
			}
			logger.info("exit from deleteDetailService()");
			return flag;
		}
	 
	 
	 
	 

	public List<JobDTO> viewAllJobRest() {
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	public List<CompanyDTO> fetchCompanyList() {
		
		System.out.println("Starting view Service");
		List<CompanyDTO> dtos = null;
		try {
			dtos = daoImpl.fetchComanyList();
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		System.out.println("Ending view Service");

		return dtos;
	}

}
