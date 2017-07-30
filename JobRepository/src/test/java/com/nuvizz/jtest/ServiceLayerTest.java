package com.nuvizz.jtest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuvizz.JobRepository.dto.JobDTO;
import com.nuvizz.JobRepository.service.JobServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/db-config.xml")
public class ServiceLayerTest {

	private Logger logger = LoggerFactory.getLogger(ServiceLayerTest.class);

	@Autowired
	private JobServiceImpl jobServiceImpl;

	@Test
	public void testServiceOperations() {
		System.out.println("Testing service");
		logger.info("jobDao is :" + jobServiceImpl);

		testJobServiceOperations(jobServiceImpl);
	}

	private void testJobServiceOperations(JobServiceImpl jobServiceImpl)

	{

		List<JobDTO> jobListstart = jobViewTest(jobServiceImpl);
		Assert.assertNotNull(jobListstart);
		for (JobDTO jobDTO : jobListstart) {

			System.out.println("list is" + jobDTO);

		}

		// save job
		jobCreationTest(jobServiceImpl);

		List<JobDTO> jobList = jobServiceImpl.viewAllJobService();
		Assert.assertNotNull(jobList);

		for (JobDTO jobDTO : jobList) {

			System.out.println("job id" + jobDTO.getJobID() + "job name"
					+ jobDTO.getJobName());

		}

		// update
		jobupdateTest(jobServiceImpl);

		List<JobDTO> jobList1 = jobServiceImpl.viewAllJobService();
		Assert.assertNotNull(jobList);

		for (JobDTO jobDTO : jobList1) {

			System.out.println("job id" + jobDTO.getJobID() + "job name"
					+ jobDTO.getJobName());

		}
		// delete
		jobDeleteTest(jobServiceImpl);

		List<JobDTO> jobList2 = jobServiceImpl.viewAllJobService();
		Assert.assertNotNull(jobList2);

		for (JobDTO jobDTO : jobList2) {

			System.out.println("job id" + jobDTO.getJobID() + "job name"
					+ jobDTO.getJobName());

		}

	}

	private void jobCreationTest(JobServiceImpl jobServiceImpl) {
		JobDTO jobDTO = new JobDTO();

		jobDTO.setCompanyid(1);
		jobDTO.setJobID(3);
		jobDTO.setUserid(1);
		jobDTO.setCompanyname("Test");
		jobDTO.setJobName("iot dev");
		jobDTO.setJoblocation("bangalore");
		jobDTO.setLatitude(12.0);
		jobDTO.setLatitude(123);
		jobDTO.setJobrole("fulltime");
		jobDTO.setPositions(15);
		jobDTO.setSalary(20000);
		jobDTO.setStatus("open");

		jobServiceImpl.saveJobService(jobDTO);
		System.out.println("after saving job");
	}

	private void jobupdateTest(JobServiceImpl jobServiceImpl) {
		JobDTO jobDTO = new JobDTO();

		jobDTO.setCompanyid(1);
		jobDTO.setJobID(1);
		jobDTO.setUserid(1);
		jobDTO.setCompanyname("Test");
		jobDTO.setJobName("java dev");
		jobDTO.setJoblocation("bangalore");
		jobDTO.setLatitude(12.0);
		jobDTO.setLatitude(123);
		jobDTO.setJobrole("fulltime");
		jobDTO.setPositions(15);
		jobDTO.setSalary(20000);
		jobDTO.setStatus("open");

		jobServiceImpl.updateService(jobDTO);
		System.out.println("after update job");
	}

	private void jobDeleteTest(JobServiceImpl jobServiceImpl) {

		jobServiceImpl.deleteJobs(1);
		System.out.println("after delete");

	}

	private List<JobDTO> jobViewTest(JobServiceImpl jobServiceImpl) {

		List<JobDTO> jobDTOs = null;
		System.out.println("after view job");
		jobDTOs=jobServiceImpl.viewAllJobService();
		
		return jobDTOs; 

	}

}
