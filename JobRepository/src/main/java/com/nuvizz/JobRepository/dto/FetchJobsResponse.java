package com.nuvizz.JobRepository.dto;

import java.util.List;

public class FetchJobsResponse {

	List<JobInfo> jobList;

	private int jobID;

	private String jobName;

	private String jobrole;

	private String joblocation;

	private double latitude;

	@Override
	public String toString() {
		return "FetchJobsResponse [jobList=" + jobList + ", jobID=" + jobID
				+ ", jobName=" + jobName + ", jobrole=" + jobrole
				+ ", joblocation=" + joblocation + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", salary=" + salary
				+ ", positions=" + positions + ", status=" + status
				+ ", companyname=" + companyname + ", companyid=" + companyid
				+ "]";
	}

	public List<JobInfo> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobInfo> jobList) {
		this.jobList = jobList;
	}

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

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	private double longitude;

	private double salary;

	private int positions;

	private String status;

	private String companyname;

	private int companyid;

}
