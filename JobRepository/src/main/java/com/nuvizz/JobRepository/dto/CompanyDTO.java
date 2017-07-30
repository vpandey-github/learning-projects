package com.nuvizz.JobRepository.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "COMPANY_TABLE")
public class CompanyDTO implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "u_CompanyId")
	private int companyid;
	@Column(name = "u_CompanyName")
	private String companyname;
	@Column(name = "u_CompanyDescription")
	private String companydescription;
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanydescription() {
		return companydescription;
	}
	public void setCompanydescription(String companydescription) {
		this.companydescription = companydescription;
	}
	@Override
	public String toString() {
		return "CompanyDTO [companyid=" + companyid + ", companyname="
				+ companyname + ", companydescription=" + companydescription
				+ "]";
	}

	
}
