package com.nuvizz.JobRepository.dao;

import java.util.List;

import com.nuvizz.JobRepository.dto.CompanyDTO;
import com.nuvizz.JobRepository.dto.JobDTO;

public interface JobDAOI {
	
	boolean saveJobDAO(JobDTO jobDTO);
	public List<JobDTO> viewJobDAO(int id);
	
	public List<JobDTO> viewAllJobDAO();
	
	public JobDTO clickupdateJobDAO(int id);
	
	public boolean deleteJod(int id);
	public List<CompanyDTO> fetchComanyList();
	
	//public List<JobDTO> viewAllJobRest();
	
	

}
