package com.nuvizz.JobRepository.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "JOB_TABLE")
public class JobDTO {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "u_jobID")
	private int jobID;
	
	@Column(name = "u_jobName")
	private String jobName;
	
	@Column(name = "u_jobrol")
	private String jobrole;
	
	@Column(name = "u_joblocation")
	private String joblocation;

	@Column(name = "u_latitude")
	private double latitude;

	@Column(name = "u_longitude")
	private double longitude;

	@Column(name = "u_salary")
	private double salary;

	@Column(name = "u_positions")
	private int positions;

	@Column(name = "u_status")
	private String status;
	
	@Column(name = "u_companyname")
	private String companyname;
	
	@Column(name = "u_CompanyId")
	private int companyid;
	
	@Column(name = "u_UserId")
	private int userid;

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobrole() {
		return jobrole;
	}

	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}

	public String getJoblocation() {
		return joblocation;
	}

	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getPositions() {
		return positions;
	}

	public void setPositions(int positions) {
		this.positions = positions;
	}

	public String getStatus() {
		return status;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "JobDTO [jobID=" + jobID + ", jobName=" + jobName + ", jobrole="
				+ jobrole + ", joblocation=" + joblocation + ", latitude="
				+ latitude + ", longitude=" + longitude + ", salary=" + salary
				+ ", positions=" + positions + ", status=" + status
				+ ", companyname=" + companyname + ", companyid=" + companyid
				+ ", userid=" + userid + "]";
	}

	
	

	
}
