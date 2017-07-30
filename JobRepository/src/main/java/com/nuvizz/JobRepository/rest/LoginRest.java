package com.nuvizz.JobRepository.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nuvizz.JobRepository.dto.APIResponse;
import com.nuvizz.JobRepository.dto.ActionDTO;
import com.nuvizz.JobRepository.dto.JobDTO;
import com.nuvizz.JobRepository.dto.UserDTO;
import com.nuvizz.JobRepository.service.JobServiceI;
import com.nuvizz.JobRepository.service.LoginServiceImpl;

@Component
@Path("/user")
@RequestMapping("/")
public class LoginRest {
	@Autowired
	LoginServiceImpl service;

	@Autowired
	JobServiceI jobServiceI;

	Logger logger = LoggerFactory.getLogger(LoginRest.class);
	// @Autowired
	UserDTO userDTO;

	public LoginRest() {
		logger.info(this.getClass().getSimpleName() + "created...");

	}

	// return null;

	// TODO: get json string from request a
	// String jsonString =

	// desrialize to APIRequest object

	// check actionname
	// if login
	// get emailId and password from ActionData
	// validate user using user authentication service
	// else if - if action name is fetch jobs
	// validate token
	// if valid
	// fetch jobs using job service

	// set values in APIResponse object

	@GET
	@Path("/fetch")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchall() {
		
		logger.info("starting fetch all controller");
		
		try {
			
			
			
			List<JobDTO> list = jobServiceI.viewAllJobService();

			if (list != null)
				return Response.status(Status.OK).entity(list).build();
			else
				return Response.status(Status.OK).entity("Fail").build();
		} catch (Exception e) {
			logger.error("exception "+e.getMessage());
			// TODO: handle exception
		}
		logger.info("endingfetch all controller");

		return null;

	}

	private static final String ACTION_NAME_LOGIN = "login";

	private static final Object ACTION_NAME_FETCH_JOBS = "fetchJobs";

	@POST
	@Path("/action")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePersonDetails(ActionDTO actionDTO) {
		logger.info("Starting  validate controller");
		APIResponse apiResponse = new APIResponse();

		if (actionDTO != null) {
			if (actionDTO.getAction() != null) {
				apiResponse.setAction(actionDTO.getAction());

				if (actionDTO.getAction().equals(ACTION_NAME_LOGIN)) {
					// process login request
					service.processLoginAndSetLoginResponse(
							actionDTO.getLoginAction(), apiResponse);

				
				} /*else 
					
					if (actionDTO.getAction().equals(
						ACTION_NAME_FETCH_JOBS)) {
					
					List<JobDTO> dtos = jobServiceI.viewAllJobService();
					
					
					return Response.status(200).entity(dtos)
							.build();
					// process fetch question request
				}*/ else {
					// TODO: action name is not supported.. set error status
					return Response.status(200)
							.entity(apiResponse.getAction()).build();
				}
			} else {
				// TODO: action is required, set error response
				return Response.status(200).entity(apiResponse)
						.build();
			}
		} else {
			return Response.status(200).entity("empty body in api request")
					.build();
			// TODO: empty body in API request, set error response
		}
		logger.info("ending validate controller");
		return Response.status(200).entity(apiResponse).build();

	}

}
