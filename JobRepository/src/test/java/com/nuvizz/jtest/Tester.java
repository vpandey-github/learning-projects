//package com.nuvizz.jtest;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.nuvizz.JobRepository.dto.CompanyDTO;
//import com.nuvizz.JobRepository.service.JobServiceImpl;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring/contextjtest.xml")
//public class Tester {
//
//	/*
//	 * private ApplicationContext ac;
//	 * 
//	 * @Before public void setUp() { ac = new
//	 * FileSystemXmlApplicationContext("file:src/main/resources/spring/context.xml"
//	 * ); }
//	 * 
//	 * @Autowired private LoginServiceImpl service;
//	 */
//
//	/*
//	 * @Autowired private LoginServiceImpl service;
//	 */
//
//	@InjectMocks
//	JobServiceImpl joservice;
//
//	@Mock
//	private JobServiceImpl impl;
//
//	@Mock
//	private SessionFactory factory;
//
//	@Before
//	public void initMocks() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void logintst() {
//
//		List<CompanyDTO> dto = null;
//
//		// UserDTO dto2 = service.authenticateUserService(dto);
//
//		// assertNotNull(service.authenticateUserService(dto));
//		// UserDTO dto2 = null;
//		dto = joservice.fetchCompanyList();
//
//		assertEquals("get", dto, dto);
//
//		// equals(joservice.fetchCompanyList());
//
//		// assertEquals(dto, impl.authenticate(dto));
//
//	}
//
//}
