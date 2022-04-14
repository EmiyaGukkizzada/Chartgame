<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp"%>

		<div align="center" style="margin-top: 5%;">
			<c:if test="${fid != null}">
				<h1>일치하는 아이디 : ${fid }</h1> 
			</c:if>
			
			<c:if test="${fid == null}">
				<h5>일치하는 아이디가 없습니다.</h5>
			</c:if>
		</div>
		<div align="center">
			<button class="btn btn-primary" onclick="location.href='index2'" style="margin-top: 10px; margin-bottom: 700px;">로그인 페이지로</button>
			<button class="btn btn-primary" onclick="location.href='findPw'" style="margin-top: 10px; margin-bottom: 700px;">비밀번호 찾기</button>
		</div>
	<%@include file="footer.jsp"%>
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
	<script
		src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
</body>
</html>