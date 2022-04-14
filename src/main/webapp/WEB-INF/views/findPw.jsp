<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<%@include file="header.jsp"%>
	
	<form action="findPwResult">
		<div align="center" style="margin-top: 5%">
		<h2>임시 비밀번호 발급 - (개인정보를 작성해야 동작하는 기능입니다. 현재 막아 두었습니다.) </h2>
		<hr width="23%">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" required="required"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn btn-primary" type="submit" value="확인" style="margin-top: 10px; margin-bottom: 600px; margin-left: 157px;"></td>
				</tr>
			</table>
		</div>
	</form>
	
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