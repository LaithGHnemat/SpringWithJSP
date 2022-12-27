<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot JSP CRUD</title>

<script src='<c:url value="/vendor/jquery/jquery-3.2.1.min.js"/>'></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
 <p id="date"></p>

 <div class="container">
  <h2>Employee List</h2>
  <table class="table">
   <thead>
    <th scope="row">ID</th>
    <th scope="row">Name</th>
    <th scope="row">Email</th>
    <th scope="row">Salary</th>

    <th scope="row">Department name</th>


   </thead>
   <tbody>
    <c:forEach items="${employees}" var="employee" >
     <tr>
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.email}</td>
      <td>${employee.salary}</td>

       <td>${(employee.department == null || employee.department.name == null) ? '' : employee.department.name}</td>
      <!-- add here whatever you have  -->
       <td>
      <%--  <spring:url value="/employee/delete/${employee.id}" var="deleteURL" /> --%>
       <a class="btn btn-primary" role="button" onclick="myfunc1('${employee.id}')" >Delete</a>
      </td>
      
      <td>
       <spring:url value="/employee/update/${employee.id }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL}" role="button" >Update</a>
      </td>
      

     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/employee/insertPage/" var="addURL" />
  <a  class="btn btn-primary" href="${addURL}" role="button"  >Add New Emp </a>
 </div>

  <script>

  function myfunc1(id) {
	    if (confirm("Are you sure that you wanna delete this employee?")) {
	        $.ajax({        
	            url: 'http://localhost:8080/employee/'+id,
	            type: 'get',
	            success: function(response) {
	            	 alert('The employee has been Deleted, response: ' + response);
	            	 window.location.reload();// I added this right now 
	            	 if(response) {
	            		 
	            	 }
	            }           
	        });
	    }
	}
	    
	</script> 
	
	 <script src="<c:url value="/js/timee.js"></c:url>"></script>
</body>
</html>