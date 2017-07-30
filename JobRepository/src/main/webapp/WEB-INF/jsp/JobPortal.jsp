<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="org.hibernate.Session"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a style="float: right">welcome Admin!,
		<h3 align="right">${user}</h3>
		<br>
	</a>
	<h1>Add jobs</h1>

	<script src="//code.jquery.com/jquery-1.9.1.js"></script>
	<script
		src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<script>
		$(function() {

			// Setup form validation on the #register-form element
			$("#addjob").validate({

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


	<form action="addjob.do" method="post" id="addjob">

		<pre>	
Job Name: <input type="text" name="jobName" id="jobName" />

Job Role:<input type="radio" name="jobrole" id="jobrole"
				value="FullTime"> Full Time
         <input type="radio" name="jobrole" id="jobrole"
				value="PartTime"> Part Time
          
Job Location:<input type="text" name="joblocation" id="joblocation">

Latitude :<input type="text" name="latitude" id="latitude">

Longitude:<input type="text" name="longitude" id="longitude">

Salary:<input type="text" name="salary" id="salary">

Positions:<input type="text" name="positions" id="positions">

Status: <select name="status" id="status">
  <option value="open">Open</option>
  <option value="filled">Filled</option>
  <option value="closed">Closed</option>
   </select>
   
  Company: <select name="companyname" id="menu" >
   <c:forEach items="${comp}" var="element">
			<option>${element.companyname}</option>
			</c:forEach>
			</select>
    
   Company: <select name="companyname" id="menu" >
   <c:forEach items="${comp}" var="element">
			<option>${element.companyid}</option>
			</c:forEach>
			</select>
   
   Created By UserId:<input type="hidden" name="userid" value="${userid}" id="userid">
<input type="submit" value="Addjobs" /><br><br><br>

</pre>
	</form>



</body>
</html>