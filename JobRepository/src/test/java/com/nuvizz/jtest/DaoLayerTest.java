package com.nuvizz.jtest;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuvizz.JobRepository.dao.JobDAOImpl;
import com.nuvizz.JobRepository.dao.LoginDAOImpl;
import com.nuvizz.JobRepository.dto.CompanyDTO;
import com.nuvizz.JobRepository.dto.JobDTO;
import com.nuvizz.JobRepository.service.JobServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/db-config.xml")
public class DaoLayerTest {

	@Autowired
	private JobDAOImpl jobDaoImpl;

	/*
	 * @Autowired private LoginDAOImpl daoImpl;
	 */
	private EmbeddedDatabase db;

	@Before
	public void setUp() {
		// db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/sql/comp.sql").build();
	}

	@After
	public void tearDown() {
		db.shutdown();
	}

	private Logger logger = LoggerFactory.getLogger(DaoLayerTest.class);

	@Test
	public void testDaoOperations() {
		System.out.println("Testing");
		logger.info("jobDao is :" + jobDaoImpl);

		testJobDaoOperations(jobDaoImpl);

	}

	private void testJobDaoOperations(JobDAOImpl jobDaoImpl) {

		List<JobDTO> jobListstart = jobViewTest(jobDaoImpl);

		for (JobDTO jobDTO : jobListstart) {
			System.out.println(jobDTO.getJobID());
		}

		// company test
		List<CompanyDTO> compList = jobDaoImpl.fetchComanyList();

		logger.info("comp list " + compList);

		CompanyDTO company = new CompanyDTO();
		company.setCompanyname("Test");
		company.setCompanydescription("Test desc");

		company = jobDaoImpl.saveCompany(company);

		if (company.getCompanyid() != 0) {
			System.out.println("Company saved:" + company);
		}

		compList = jobDaoImpl.fetchComanyList();

		System.out.println("After saving comp list " + compList);

		Assert.assertNotNull(compList);

		for (CompanyDTO companyDTO : compList) {
			System.out.println("comp  " + companyDTO.getCompanyid());

			Assert.assertNotNull(companyDTO);

		}

		// TODO:job test save

		jobCreationTest(jobDaoImpl);

		// read
		List<JobDTO> jobList = jobDaoImpl.viewAllJobDAO();
		Assert.assertNotNull(jobList);

		for (JobDTO jobDTO : jobList) {
			System.out.println("jobdto is " + jobDTO);

			System.out.println("job id is" + jobDTO.getJobID() + "job name "
					+ jobDTO.getJobName());
		}

		// update job

		// jobupdateTest(jobDaoImpl);

		List<JobDTO> jobList1 = jobDaoImpl.viewAllJobDAO();
		Assert.assertNotNull(jobList1);

		for (JobDTO jobDTO : jobList1) {

			System.out.println("job id" + jobDTO.getJobID() + "job name"
					+ jobDTO.getJobName());

		}
		// delete job

		// jobDelete(jobDaoImpl);

		List<JobDTO> jobList2 = jobDaoImpl.viewAllJobDAO();
		Assert.assertNotNull(jobList2);

		for (JobDTO jobDTO : jobList2) {

			System.out.println("job id" + jobDTO.getJobID() + "job name"
					+ jobDTO.getJobName());

		}

	}

	private void jobCreationTest(JobDAOImpl jobDaoImpl) {
		JobDTO jobDTO = new JobDTO();

		jobDTO.setCompanyid(1);
		jobDTO.setJobID(2);
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

		jobDaoImpl.saveJobDAO(jobDTO);
		System.out.println("after saving job");
	}

	private void jobupdateTest(JobDAOImpl jobDaoImpl) {
		JobDTO jobDTO = new JobDTO();

		jobDTO.setCompanyid(1);
		jobDTO.setJobID(1);
		jobDTO.setUserid(1);
		jobDTO.setCompanyname("Test");
		jobDTO.setJobName("android dev");
		jobDTO.setJoblocation("bangalore");
		jobDTO.setLatitude(12.0);
		jobDTO.setLatitude(123);
		jobDTO.setJobrole("fulltime");
		jobDTO.setPositions(15);
		jobDTO.setSalary(20000);
		jobDTO.setStatus("open");

		jobDaoImpl.updateDetailsDAO(jobDTO);

	}

	private void jobDelete(JobDAOImpl jobDaoImpl) {

		jobDaoImpl.deleteJod(1);
		System.out.println("after delete");

	}

	private List<JobDTO> jobViewTest(JobDAOImpl jobDaoImpl) {

		System.out.println("after view job");
		return jobDaoImpl.viewAllJobDAO();

	}

}
