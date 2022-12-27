
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V2</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	
	<link href="<c:url value='/resources/vendor/animsition/css/animsition.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	
	<link href="<c:url value='/resources/images/icons/faviconn.ico'/>" rel="icon" type="image/png" />
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	
	
	
	<link href="<c:url value='/resources/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	
	
	
	<link href="<c:url value='/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
	
	
	
	<link href="<c:url value='/resources/fonts/iconic/css/material-design-iconic-font.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	
	
	
	
	<link href="<c:url value='/resources/vendor/animate/animate.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	
	
	
	<link href="<c:url value='/resources/vendor/css-hamburgers/hamburgers.min.css'/>" rel="stylesheet" type="text/css" />
	
<!--=======================above ========================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	
	
	<link href="<c:url value='/resources/vendor/animsition/css/animsition.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link href="<c:url value='/resources/vendor/select2/select2.min.css'/>" rel="stylesheet" type="text/css" />
	
<!--===============================================================================================-->	
 	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">

	
	<link href="<c:url value='/resources/vendor/daterangepicker/daterangepicker.css'/>" rel="stylesheet" type="text/css" />
	
<!--===============================================================================================-->
	 <link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	<link href="<c:url value='/resources/css/util.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css" />
	
	
	
<!--===============================================================================================-->
</head>
<body>
	<p id="date"></p>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="POST" action="/login">
					<span class="login100-form-title p-b-26">
						Login 
					</span>
					<span class="login100-form-title p-b-48">
						<img alt="" src="images/icons/faviconn.jpg">
					</span>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="username">
						<span class="focus-input100" data-placeholder="Username"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="password">
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Login
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script> 
	<script src="<c:url value='/resources/vendor/jquery/jquery-3.2.1.min.js'/>"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	
	<script src="<c:url value='/resources/vendor/animsition/js/animsition.min.js'/>"></script>
	
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script> 
	
	
	<script src="<c:url value='/resources/vendor/bootstrap/js/popper.js'/>"></script>
	<script src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
	
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script src="<c:url value='/resources/vendor/select2/select2.min.js'/>"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	
	
	<script src="<c:url value='/resources/vendor/daterangepicker/moment.min.js'/>"></script>
	<script src="<c:url value='/resources/vendor/daterangepicker/daterangepicker.js'/>"></script>
	
	
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="<c:url value='/resources/vendor/countdowntime/countdowntime.js'/>"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
	<script src="<c:url value='/resources/js/main.js'/>"></script>
    <script src="<c:url value="/js/timee.js"></c:url>"></script>




</body>
</html>