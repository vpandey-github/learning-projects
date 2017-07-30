package com.nuvizz.JobRepository.dto;


public class LoginAction {
	
	
	private int userid;
	
	private String username;
	
	private String emailid;
	
	private String password;
	private String token;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "LoginAction [userid=" + userid + ", username=" + username
				+ ", emailid=" + emailid + ", password=" + password
				+ ", token=" + token + "]";
	}
	

	

}
