<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="org.hibernate.Session"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>





<script src="//code.jquery.com/jquery-1.9.1.js"></script>
	<script
		src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<script>
		$(function() {

			// Setup form validation on the #register-form element
			$("#updatejob").validate({

				// Specify the validation rules
				rules : {
					jobName : "required",
					jobName : true,

					jobrole : {

						required : true,

					},

					joblocation : {

						required : true,
					},

					latitude : {

						required : true,

					},

					longitude : {

						required : true,
					},

					salary : {
						required : true,
					},

					positions : {
						required : true,

					},

					status : {

						required : true,
					},
					companyname : {
						required : true,

					},
					companyid : {

						required : true,

					},

					userid : {

						required : true,

					},
				

				},

				// Specify the validation error messages
				messages : {

					jobName : {
						required : "Please enter your name",

					},

					jobrole : {
						required : "Please provide a jobrole",

					},
					joblocation : {

						required : "Please provide a joblocation",

					},

					latitude : {

						required : "Please provide a latitude",

					},
					longitude : {

						required : "Please provide a longitude",

					},

					salary : {

						required : "Please provide a salary",

					},

					positions : {

						required : "Please provide a positions",

					},
					status : {

						required : "Please provide a positions",

					},
					companyname : {

						required : "Please provide a ompanyname",

					},

					companyid : {

						required : "Please provide a companyid",

					},
					userid : {

						required : "Please provide a companyid",

					},
				},

				submitHandler : function(form) {
					form.submit();
				}
			});

		});
	</script>

<body>
<a  style="float:right">welcome Admin!,<h3 align="right">${viewEDIT.companyname}</h3><br></a>

<h1>Update job</h1>

	<form action="updatejob.do" method="post" id="updatejob">

	<pre>
	Job ID:<input type="text" name="jobid" value="${viewEDIT.jobID}" id="jobID" >	
Job Name: <input type="text" name="jobName" value="${viewEDIT.jobName}" id="JobName" />

Job Role:<input type="radio" name="jobrole" value="FullTime"> Full Time
         <input type="radio" name="jobrole" value="PartTime"> Part Time
          
Job Location:<input type="text" name="joblocation"style="color: red;" value="${viewEDIT.joblocation}" id="joblocation">

Latitude :<input type="text" name="latitude" value="${viewEDIT.latitude}" id="latitude">

Longitude:<input type="text" name="longitude" value="${viewEDIT.longitude}" id="longitude">

Salary:<input type="text" name="salary" value="${viewEDIT.salary}" id="salary">

Positions:<input type="text" name="positions" value="${viewEDIT.positions}" id="positions">

Status: <select name="status">
  <option value="open">Open</option>
  <option value="filled">Filled</option>
  <option value="closed">Closed</option>
   </select>
      Company: <select name="companyname" id="companyname" >
   <c:forEach items="${comp}" var="element">
			<option>${element.companyname}</option>
			</c:forEach>
			</select>
    
   Company Id: <select name="companyid" id="companyid" >
   <c:forEach items="${comp}" var="element">
			<option>${element.companyid}</option>
			</c:forEach>
			</select>
   
   Created By UserId:<input type="hidden"  name="userid" value="${viewEDIT.userid}" id="userid">
<input type="submit" value="Addjobs" /><br><br><br>

</pre>

	</form>

</body>
</html>