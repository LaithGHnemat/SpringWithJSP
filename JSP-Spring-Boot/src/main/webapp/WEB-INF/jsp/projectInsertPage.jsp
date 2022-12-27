<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot JSP CRUD</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 <p id="date"></p>
</head>
<body>
<p id="date"></p>
<div class="container">
  <spring:url value="/project/insert" var="saveURL" />
  

  <form:form modelAttribute="projectForm" method="post" action="${saveURL}" >
   <form:hidden path="projectId"/>

   <div  class="mb-3">
    <label>Project Name</label>
    <form:input path="name"  id="name" />
   </div>

   <div class="mb-3">
    <label>Project  Owner</label>
    <form:input path="owner"  id="owner" />
   </div>

   <div class="mb-3">
       <label>Project  Location</label>
       <form:input path="Location"  id="Location" />
      </div>

      <div class="mb-3">
             <label>Project  Title</label>
             <form:input path="title"  id="title" />
            </div>
 
   <button type="submit" class="btn btn-primary">save</button>
  </form:form>
  </div>
  <script src="/js/main.js"></script>
</body>
</html>