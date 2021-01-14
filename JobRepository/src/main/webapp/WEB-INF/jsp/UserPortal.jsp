<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a style="float:right">welcome! Candidate Portal ,<h3>${obj1.username}</h3><br></a>

<pre>
	<table border="1" align="center">
Number of jobs  are:${viewall.size()}
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
		</tr>
		<c:forEach items="${viewall}" var="element">
			<tr>
				<td>${element.jobName}</td>
				<td>${element.jobrole}</td>
				<td>${element.joblocation}</td>
				<td>${element.latitude}</td>
				<td>${element.longitude}</td>
				<td>${element.salary}</td>
				<td>${element.positions}</td>
				<td>${element.status}</td>
				<td>${element.companyname}</td>
				</tr>
		</c:forEach>
	</table>
	
	</pre>
</body>
</html>