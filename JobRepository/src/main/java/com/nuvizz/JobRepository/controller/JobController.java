package com.nuvizz.JobRepository.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nuvizz.JobRepository.dto.CompanyDTO;
import com.nuvizz.JobRepository.dto.JobDTO;
import com.nuvizz.JobRepository.dto.UserDTO;
import com.nuvizz.JobRepository.service.JobServiceImpl;

@Component
@RequestMapping("/")
public class JobController {
	
	@Autowired
	private JobServiceImpl impl;
	

	
	Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@RequestMapping("addjob.do")
	public String addjobs(@ModelAttribute JobDTO jobDTO,HttpServletRequest request) {
		
		
		try {
			boolean res =false;
			res = impl.saveJobService(jobDTO);
			logger.info("res=" + res);
			   
			   if(res)
			   {
			   HttpSession session1 = request.getSession(false);
				UserDTO dto2 = (UserDTO) session1.getAttribute("obj1");
				
				int id = dto2.getUserid();

				List<JobDTO> jobDTOu = impl.viewJobService(id);

				session1.setAttribute("view", jobDTOu);
				return "Adminview";
			   }

			return "JobPortal";
			
			
			
		} catch (Exception e) {

			logger.info("error"+e.getMessage());
		}
		
		
		return null;
	}
	
	@RequestMapping("clickupdate.do")
	public String  clickupdatejob(@ModelAttribute JobDTO jobDTO,HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		
		try {
			
			
			int id = Integer.parseInt(request.getParameter("id4"));
			
			System.out.println("id is"+id);
			if(id>0)
			{
			 
			jobDTO=impl.clickupdateJobService(id);
			
			System.out.println(jobDTO.getJobName());
			
			session.setAttribute("viewEDIT", jobDTO);
			

			List<CompanyDTO> dtos = impl.fetchCompanyList();
			
			session.setAttribute("comp", dtos);
			
			return "UpdateJobs";
			//}
			}
		} catch (Exception e) {
			
			System.out.println("error"+e.getMessage());
			
			// TODO: handle exception
		}
		
		
		return "Error";
		
		
		
	}
	
	@RequestMapping("/updatejob.do")
	 public String updateJob(@ModelAttribute JobDTO dto,
	   HttpServletRequest request) {
	 logger.info("Starting update Controller");

	  try {
		  boolean res = false;
		  HttpSession session = request.getSession(false);
		  JobDTO jobDTO = (JobDTO) session.getAttribute("viewEDIT");
		  // List<JobDTO> fromdb = (List<JobDTO>) session.getAttribute("view");
		  dto.setJobID(jobDTO.getJobID());
		  res =  impl.updateService(dto);
	   
	   if(res)
	   {
	   HttpSession session1 = request.getSession(false);
		UserDTO dto2 = (UserDTO) session1.getAttribute("obj1");
		
		int id = dto2.getUserid();

		List<JobDTO> jobDTOu = impl.viewJobService(id);

		session1.setAttribute("view", jobDTOu);
		return "Adminview";
	   }
	   
	  

	  } catch (Exception e) {
	   logger.error("Exception in update Controller " + e);
	   e.printStackTrace();
	  }

	 logger.info("Ending update Controller");
	  return null;

	 }
	
	
	
	@RequestMapping("/delete.do")
	 public String deleteJobs(HttpServletRequest request,Model model) {

	  int id = Integer.parseInt(request.getParameter("id2"));
	  boolean res = false;
	  if (id > 0) {
		  logger.info("inside delete method");
	   res = impl.deleteJobs(id);
	   
	   if (res) {
		   
		   HttpSession session1 = request.getSession(false);
			UserDTO dto2 = (UserDTO) session1.getAttribute("obj1");
			
			int uid = dto2.getUserid();

			List<JobDTO> jobDTO = impl.viewJobService(uid);

			session1.setAttribute("view", jobDTO);
           
	    return "Adminview";
	   }

	  }
	  logger.info("exit delete method");
	  return null;
	 }
	
	@RequestMapping("/changestatus.do")
	 public String markJobs(HttpServletRequest request,Model model) {

	  int id = Integer.parseInt(request.getParameter("id5"));
	  boolean res = false;
	  if (id > 0) {
		  logger.info("inside markJobs method");
	   res = impl.markJobs(id);
	   
	   if (res) {
		   
		   HttpSession session1 = request.getSession(false);
			UserDTO dto2 = (UserDTO) session1.getAttribute("obj1");
			
			int uid = dto2.getUserid();

			List<JobDTO> jobDTO = impl.viewJobService(uid);

			session1.setAttribute("view", jobDTO);
          
	    return "Adminview";
	   }

	  }
	  logger.info("exit delete method");
	  return null;
	 }
	
}
