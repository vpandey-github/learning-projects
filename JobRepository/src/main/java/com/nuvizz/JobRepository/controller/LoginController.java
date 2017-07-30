package com.nuvizz.JobRepository.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nuvizz.JobRepository.dto.CompanyDTO;
import com.nuvizz.JobRepository.dto.JobDTO;
import com.nuvizz.JobRepository.dto.RoleDTO;
import com.nuvizz.JobRepository.dto.UserDTO;
import com.nuvizz.JobRepository.service.JobServiceImpl;
import com.nuvizz.JobRepository.service.LoginServiceImpl;


@Component
@RequestMapping("/")
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginServiceImpl serviceImpl;
	
	
	@Autowired JobServiceImpl jobserviceimpl;

	@RequestMapping("welcome.do")
	public ModelAndView welcome(HttpServletRequest request) {
		
	System.out.println("in welcome .do");
		
	return new ModelAndView("Login");
	}
	
	@RequestMapping("UserPortal.do")
	public String carDetail(HttpServletRequest request) {
		

		return "UserPortal";
	}
	
	@RequestMapping("JobPortal.do")
	public String jobPortal(HttpServletRequest request) {
		
		HttpSession session1 = request.getSession(true);
		UserDTO dto2 = (UserDTO) session1.getAttribute("obj1");
		
		session1.setAttribute("userid", dto2.getUserid());
		List<CompanyDTO> dtos = jobserviceimpl.fetchCompanyList();
		
		session1.setAttribute("comp", dtos);
		for (CompanyDTO manufacturerDTO : dtos) {
			System.out.println(manufacturerDTO);
		}
		
		
		
		return "JobPortal";
	}
	
	
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		
		
		HttpSession session = request.getSession(false);
		UserDTO dto = (UserDTO) session.getAttribute("obj1");
		
		session.invalidate();
		
		
		return "Login";
	}
	

	@RequestMapping("Adminview.do")
	public String viewjob(HttpServletRequest request) {
		
		List<JobDTO> dtos = jobserviceimpl.viewAllJobService();
		request.setAttribute("viewall", dtos);
		return "Adminview";
	}
	
	@RequestMapping("login.do")
	public String login(@ModelAttribute UserDTO dto,HttpServletRequest request) {
		
		logger.info("starting login");

		HttpSession session = null;

		UserDTO userDTO = serviceImpl.authenticateUserService(dto);

		if (userDTO != null) {

			session = request.getSession(true);
			//TODO: SET FOR CHECK ROLE AND GIVE JOBL LIST
			session.setAttribute("obj1", userDTO);
			session.setAttribute("useremail",userDTO.getEmailid());
			session.setAttribute("role", userDTO.getRoleDTOs());
			
			//session.setAttribute("token", userDTO.getToken());
			
			List<RoleDTO> list = (List<RoleDTO>) userDTO.getRoleDTOs();
			for (RoleDTO roleDTO : list) {
				System.out.println("r" + roleDTO);
				if (roleDTO.getRoleid() ==2)
				{
					List<JobDTO> dtos = jobserviceimpl.viewAllJobService();
					request.setAttribute("viewall", dtos);
					return "UserPortal";
				}
				else
					
				{
					
					HttpSession session1 = request.getSession(true);
					UserDTO dto2 = (UserDTO) session1.getAttribute("obj1");
					
					int id = dto2.getUserid();

					List<JobDTO> jobDTO = jobserviceimpl.viewJobService(id);

					session1.setAttribute("view", jobDTO);
				}
					return "Adminview";
			}
			

	}
		return "Login";
	
	
	}

}
