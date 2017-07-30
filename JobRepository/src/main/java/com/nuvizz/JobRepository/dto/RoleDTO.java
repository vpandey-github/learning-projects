package com.nuvizz.JobRepository.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "ROLE_TABLE")
public class RoleDTO implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "u_RoleId")
	private int roleid;
	@Column(name = "u_RoleName")
	private String rolename;
	@Column(name = "u_RoleDesc")
	private String roledesc;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roleDTOs")
	private Collection<UserDTO> userDTOs;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoledesc() {
		return roledesc;
	}
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	public Collection<UserDTO> getUserDTOs() {
		return userDTOs;
	}
	public void setUserDTOs(Collection<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}
	

	

	
}
