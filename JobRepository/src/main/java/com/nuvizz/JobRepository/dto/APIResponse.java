package com.nuvizz.JobRepository.dto;

public class APIResponse {

	String action;

	String status;

	LoginResponse loginResponse;
	
	FetchJobsResponse fetchJobsResponse;
	
	

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoginResponse getLoginResponse() {
		return loginResponse;
	}

	public void setLoginResponse(LoginResponse loginResponse) {
		this.loginResponse = loginResponse;
	}

}
