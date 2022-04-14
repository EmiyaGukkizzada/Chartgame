<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
	<c:set var="varSessionId" value="${sessionId }" scope="session" />
	<c:set var="varSessionState" value="${sessionState }" scope="session"/> 
	<c:set var="varSessionName" value="${sessionName }" scope="session"/>
	<c:set var="varSessionImg" value="${sessionImg }" scope="session"/>
	<c:set var="varSessionCash" value="${sessionCash }" scope="session"/>
	
	
</head>
<body>
	 <!-- header inner -->
         <div class="header">
            <div class="container">
               <div class="row">
                  <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                     <div class="full">
                        <div class="center-desk">
                           <div class="logo">
                              <a href="index2"><img style="height: 45%; width: 50%;" src="images/logo.png" alt="#" /></a>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                     <nav class="navigation navbar navbar-expand-md navbar-dark" style="margin-top: 25px;">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarsExample04">
                           <ul class="navbar-nav mr-auto">
                              <li class="nav-item active">
                                 <a class="nav-link" href="index2"><img id="home" src="images/home.jpg"></a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="rank"><img id="rank" src="images/trophy.png"></a>
                              </li>
                              
                              <c:choose>
                              
                              <c:when test="${empty varSessionId }">
                              <li class="nav-item" id="join">
                                 <a class="nav-link" href="memberJoinForm">가입하기</a> 
                              </li>
                              </c:when>
                              
                             <c:when test="${varSessionState == 4}">
	                              <li class="nav-item" id="admin">
	                              	<a class="nav-link" href="empOperation">관리자</a>
	                              </li>
	                              <li class="nav-item"><a class="btn btn-outline-info btn-sm"  href="logout">로그아웃</a></li>
	                          </c:when>
	                          
	                          <c:when test="${varSessionState==2}">
                	 		<li class="nav-item">
                	 		<a class="nav-link" href="empOperation">직원 ID : ${varSessionId }</a>
							</li>
							<li class="nav-item"><a class="btn btn-outline-info btn-sm"  href="logout">로그아웃</a></li>
							</c:when>
	                      
			                  	<c:when test="${!empty varSessionId}">
		                	  		<li class="nav-item"><a class="nav-link" href="myPage">마이페이지</a></li>
		                   	  		<li class="nav-item"><a class="btn btn-outline-info btn-sm" href="logout">로그아웃</a></li>
								</c:when>
							  
	                          </c:choose>
                           </ul>
                        </div>
                     </nav>
                  </div>
               </div>
            </div>
         </div>
		        
		<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
		<!-- <script> 
			$(document).ready(function(){
					const state = ${varSessionState};
					console.log(state);
					var join = document.getElementById('join');
					if (parseInt(state) == 4) {
						console.log("join디스플레이 'none'");
						join.style.display = "none";
					}
				});
			</script> -->
		         
</body>
</html>