package com.nuvizz.JobRepository.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "USER_TABLE")
public class UserDTO implements Serializable {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "u_UserId")
	private int userid;
	@Column(name = "u_UserName")
	private String username;
	@Column(name = "u_EmailId")
	private String emailid;
	@Column(name = "u_Password")
	private String password;
	
	@Column(name = "u_Token")
	private String token;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE_TABLE", joinColumns = {
			@JoinColumn(name = "u_UserId", updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "u_RoleId", updatable = false) })
	private Collection<RoleDTO> roleDTOs;

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

	public Collection<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}

	public void setRoleDTOs(Collection<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}

	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username
				+ ", emailid=" + emailid + ", password=" + password
				+ ", token=" + token + ", roleDTOs=" + roleDTOs + "]";
	}

	
	
	
	

}
