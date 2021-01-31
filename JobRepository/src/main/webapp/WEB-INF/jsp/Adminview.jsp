
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a  style="float:right">Welcome! admin Portal,<h3 align="right">${obj1.username}</h3><br></a>

 <br>
<a href="${pageContext.request.contextPath}/JobPortal.do">Add jobs </a><br>
	<table border="1" align="center">
		<tr>
			<th>job Name:</th>
			<th>Job Role</th>
			<th>Job Location</th>
			<th>Latitude</th>
			<th>Longitude</th>
			<th>Salary</th>
			<th>Positions</th>
			<th>Status</th>
			<th>Company Name</th>
			<th>Delete  Job</th>
			<th>Update Jobs</th>
			<th>Change Status</th>
		</tr>
		<c:forEach items="${view}" var="element">
			<tr>
				<td>${element.jobName}</td>
				<td>${element.jobrole}</td>
				<td>${element.joblocation}</td>
				<td>${element.latitude}</td>
				<td>${element.longitude}</td>
				<td>${element.salary}</td>
				<td>${element.positions}</td>
				<td style="color:red;">${element.status}</td>
				<td>${element.companyname}</td>
				<td><a href="delete.do?id2=<c:out value="${element.jobID}"/>">Delete</a></td>
				<td><a href="clickupdate.do?id4=<c:out value="${element.jobID}"/>">Click For Update</a></td>
				<td><a href="changestatus.do?id5=<c:out value="${element.jobID}"/>">Mark job filled</a></td>
				
				
				</tr>
		</c:forEach>
	</table>

</body>
</html>