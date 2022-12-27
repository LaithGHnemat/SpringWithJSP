<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
<script src='<c:url value="/vendor/jquery/jquery-3.2.1.min.js"/>'></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<p id="date"></p>

<div class="container">
  <h2>Projects List</h2>
  <table class="table">
   <thead>
    <th scope="row">ID</th>
    <th scope="row">Name</th>
    <th scope="row">Owner</th>
    <th scope="row">Location</th>
    <th scope="row">Title</th>

   </thead>
   <tbody>
    <c:forEach items="${projects}" var="pro" >
     <tr>
      <td>${pro.projectId}</td>
       <td>${pro.name}</td>
      <td>${pro.owner}</td>
      <td>${pro.location}</td>
      <td>${pro.title}</td>
      <td>
   <a class="btn btn-primary"  role="button" onclick="myfunc1('${pro.projectId}')">Delete</a>
   </td>
   <td>
          <spring:url value="/project/update/${pro.projectId}" var="updateURL" />
          <a class="btn btn-primary" href="${updateURL}" role="button" >Update</a>
         </td>


     </tr>
    </c:forEach>
   </tbody>
  </table>

 </div>
  <script src="<c:url value="/js/timee.js"></c:url>"></script>

<script>
	      function myfunc1(id) {
	    	    if (confirm("Are you sure to Delete this element?")) {
	    	        $.ajax({
	    	            url: 'http://localhost:8080/project/delete/'+id,
	    	            type: 'get',
	    	            success: function(response) {
	    	            	 alert('The Department has been Deleted');
	    	            	 window.location.reload();

	    	            }
	    	        });
	    	    }
	    	}
	</script>

</body>
</html>