<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<p id="date"></p>
<h2>Welcome, here we are inside employee management project </h2>

 <div>
  <spring:url value="/employee/list" var="listURL" />
  <a  href="${listURL}" role="button" class="btn btn-primary" >All Employee</a>
 </div>
<br/>

<div>
  <spring:url value="/department/list" var="listDPT" />
  <a  href="${listDPT}" role="button" class="btn btn-primary" >All Departments</a>
</div>
<br/>

<div>
  <spring:url value="/project/list" var="listPro" />
  <a  href="${listPro}" role="button" class="btn btn-primary" >All projects</a>
 </div>

<br/>

 <div>
   <spring:url value="/employee/emp-viw" var="listPro" />
   <a  href="${listPro}" role="button" class="btn btn-primary" >Employee Details</a>
  </div>

<br/>
 <script src="<c:url value="/js/timee.js"></c:url>"></script>
</body>
</html>




