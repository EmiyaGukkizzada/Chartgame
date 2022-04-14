<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
	<c:set var="varSessionId" value="${sessionId }" scope="session" />
	<c:set var="varSessionState" value="${sessionState }" scope="session"/> 
	<c:set var="varSessionName" value="${sessionName }" scope="session"/>
	<c:set var="varSessionImg" value="${sessionImg }" scope="session"/>
	<c:set var="varSessionCash" value="${sessionCash }" scope="session"/>
</head>
<body>
   <div class="container">
    <div class="row d-flex justify-content-center mt-5">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card py-3 px-2">
                <!-- <p class="text-center mb-3 mt-2">소셜미디어 로그인</p>
                <div class="row mx-auto ">
                    <div class="col-4"> <i class="fab fa-twitter"></i> </div>
                    <div class="col-4"> <i class="fab fa-facebook"></i> </div>
                    <div class="col-4"> <i class="fab fa-google"></i> </div>
                </div> -->
                <div class="division">
                    <div class="row">
                        <div class="col-3">
                            <div class="line l"></div>
                        </div>
                        <div class="col-6"><span style="font-size: 20px;">로그인</span></div>
                        <div class="col-3">
                            <div class="line r"></div>
                        </div>
                    </div>
                </div>
                <form class="loginForm" id="loginForm">
                    <div class="form-group"> 
                    	<input type="text" id="id" name="id" class="form-control" placeholder="아이디"> </div>
                    <div class="form-group"> 
                    	<input type="password" id="pw" name="pw" class="form-control" placeholder="비밀번호"> </div>
                    <div class="stateForm">
				         <input type="hidden" id="state" name="state" >
				         
				      </div>
				      <div class="nameForm">
				         <input type="hidden" id="name" class="name" name="name">
				      </div>
				      <div class="empnoForm">
				         <input type="hidden" id="empno" class ="empno" name="empno">
				      </div>
				      <div class="deptForm">
				         <input type="hidden" id="dept" class="dept" name="dept">
				      </div>
				      <div class="cashForm">
				      	<input type="hidden" id="cash" class="cash" name="cash">
				      </div>
				      
				      
                    <div class="row">
                        <div class="col-md-6 col-12">
                            <!-- <div class="form-group form-check"> <input type="checkbox" class="form-check-input" id="exampleCheck1"> <label class="form-check-label" for="exampleCheck1">로그인 유지</label> </div> -->
                        </div>
                        <input type="button" class="btn btn-outline-info btn-sm" onclick="findId()" value="아이디 찾기">
                        <input type="button" class="btn btn-outline-info btn-sm" onclick="findPw()" value="비밀번호 찾기">
                        <script>
                        	function findId() {
								location.href = "findId";
							}
                        </script>
                        <script>
                        	function findPw() {
                        		location.href = "findPw";
							}
                        </script>
                    </div>
                    <div class="form-group mt-3"> <button type="submit" id="login_submit" class="btn btn-block btn-primary btn-lg"><small><i class="far fa-user pr-2"></i>로그인</small></button> </div>
                </form>
            </div>
        </div>
    </div>
</div>
		<script src="js/login.js"></script>
</body>

</html>