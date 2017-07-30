package com.nuvizz.JobRepository.service;

import java.util.List;

import com.nuvizz.JobRepository.dto.JobDTO;

public interface JobServiceI {

	boolean saveJobService(JobDTO jobDTO);
	
	List<JobDTO> viewJobService(int id);
	
	List<JobDTO> viewAllJobService();
	public JobDTO clickupdateJobService(int id);
	
	public boolean deleteJobs(int id);
	
	public List<JobDTO> viewAllJobRest();
}
