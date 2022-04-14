<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rank</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp"%>
	<div class="roww">
		<div>
			<div class="container">
				<br>
				<%-- <%@include file="leaderboard.jsp" %> --%>
				<section class="main-content">
					<div class="container">
						<h1>순위</h1>
						<table class="table">
							<thead>
								<tr>
									<th>유저</th>
									<th>자산</th>
									<th>Rank</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="listRank" items="${listRank}" varStatus="status">	
									<tr>
										<td>
											<h5 class="mb-0">${listRank.id}</h5>
										</td>
										<td>
											<h4 class="mr-1">${listRank.cash}원</h4>
										</td>
										<td>
											<h3>${status.count}위</h3>
										</td>
									</tr>
								</c:forEach>		
							</tbody>
						</table>
					</div>
				</section>
			</div>
		</div>
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