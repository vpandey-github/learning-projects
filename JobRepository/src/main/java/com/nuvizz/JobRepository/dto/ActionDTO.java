package com.nuvizz.JobRepository.dto;

import java.io.Serializable;

public class ActionDTO implements Serializable {
		
	
	private String action;
	
	LoginAction loginAction;
	FetchJobsResponse response;

	@Override
	public String toString() {
		return "ActionDTO [action=" + action + ", loginAction=" + loginAction
				+ "]";
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public LoginAction getLoginAction() {
		return loginAction;
	}

	public void setLoginAction(LoginAction loginAction) {
		this.loginAction = loginAction;
	}
}
