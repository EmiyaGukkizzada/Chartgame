<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>Chart Game</title>
<!-- bootstrap css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

<c:set var="varSessionId" value="${sessionId }" scope="session" />
<c:set var="varSessionState" value="${sessionState }" scope="session" />
<c:set var="varSessionName" value="${sessionName }" scope="session" />
<c:set var="varSessionImg" value="${sessionImg }" scope="session" />
<c:set var="varSessionCash" value="${sessionCash }" scope="session" />
</head>
<!-- body -->
<body class="main-layout">
	<!-- loader  -->
	<div class="loader_bg">
		<div class="loader">
			<img src="images/loading.gif" alt="#" />
		</div>
	</div>
	<!-- end loader -->
	<!-- header -->
	<%@include file="header.jsp"%>
	<!-- end header inner -->
	<!-- end header -->

	<!-- banner -->
	<div class="roww">
		<section class="banner_main" id="banner_main" style="background-color: #212042; border-top: 5px solid rgb(176, 106, 252); border-bottom: 5px solid rgb(176, 106, 252); padding-bottom: 10px;">
			<div class="container">
				<c:choose>
					<c:when test="${empty varSessionId }">
						<img src="images/logo.png" style="margin-left: 370px; height: 280px; width: 380px;">
						<%@include file="login.jsp"%>
						<div style="background-color: #212042; height: 81px;"></div>
					
					</c:when>
					<c:when test="${!empty varSessionId}">
						
						<%@include file="chart.jsp"%>
						
					</c:when>
				</c:choose>
				<div class="row d_flex">
					<div class="right-column">
						<div id="test-right2">
							
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- end banner -->

	<!--  footer -->
	<%@include file="footer.jsp"%>
	<!-- end footer -->
	<!-- Javascript files-->
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.0.0.min.js"></script>
	<script src="js/plugin.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- sidebar -->
	<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/custom.js"></script>
	

</body>
</html>

