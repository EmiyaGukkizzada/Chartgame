<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>MemberJoinForm</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
   	  <script>
   	  	function test() {
   	  		let idcheck = $('#idcheck').val();
			
			if (!(frm.pw.value == frm.pwChk.value)) {
				alert("비밀번호가 일치하지 않습니다.")
				
				return false;
			}
			
			if (idcheck == '0'){
				alert("중복체크를 하지 않았거나 사용할 수 없는 아이디입니다.");
				
				return false;
			}
			/*회원가입시 직원등록*/
			
			var state = $('#state').val();
			alert("state->"+state);
			
			if (state == 2) {
				var a = prompt("직원용 비밀번호를 입력하세요");
				if (a == '1234') {
					var deptParam = prompt("부서를 입력하세요");
					alert(deptParam);
					var dept = document.getElementById("dept");
					alert(dept.value);
					dept.value = deptParam;
					alert(dept.value);
					console.log(dept.value);
					return true;
					
				}else{
					alert("비밀번호가 틀렸습니다");
					return false;
				}
			}else {
				return true;
			}
		}
   	  	/* 아이디 중복체크 */
   	  	
   	  	function sendId() {
			if (frm.id.value == "") {
				alert("아이디를 입력해주세요");
				return false;
			}
			let userId = $('#id').val();
			
			const param = {"id" : userId}; // id가 member 객체로 들어감
			console.log(param);
			
			$.ajax({
				url : "memberIdChk",
				type: "POST",
				data : param
			}).done(
					function(result) {
						console.log(result);
						if (result === 0) {
							alert("사용할 수 있는 아이디입니다.");
							$('#idcheck').val('1');
						}else {
							alert("사용할 수 없는 아이디입니다.");
							$('#idcheck').val('0');
						}
					}).fail(
							function(data) {
								console.log(data);
								alert("오류입니다.");
							});
		}
   	  </script>
</head>
<body>
<%@include file="header.jsp"%>
    <div class="container">

    <form class="well form-horizontal" action="memberJoin" name="frm" method="post" onsubmit="return test()">
		<fieldset>
		
			<!-- Form Name -->
			<legend><center><h2 style="margin-top: 25px;"><b>회원가입</b></h2></center></legend><br>
			
			<!-- Text input-->
			
			<div class="form-group" style="margin-left: 40%;">
			  <label class="col-md-4 control-label">아이디</label>  
			  <div class="col-md-4 inputGroupContainer">
			  <div class="input-group">
			  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			  <input id="id" name="id" placeholder="아이디" class="form-control"  type="text" required="required">
			  <input class="btn btn-link" type="button" onclick="sendId()" value="중복확인">
			  <input type="hidden" id="idcheck" name="idcheck" value="0">
			    </div>
			  </div>
			</div>
			
			<!-- Text input-->
			
			<div class="form-group" style="margin-left: 40%;">
			  <label class="col-md-4 control-label" >비밀번호</label> 
			    <div class="col-md-4 inputGroupContainer">
			    <div class="input-group">
			  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			  <input name="pw" placeholder="비밀번호" class="form-control"  type="password" required="required">
			    </div>
			  </div>
			</div>
			<!-- Text input-->
			
			<div class="form-group" style="margin-left: 40%;">
			  <label class="col-md-4 control-label" >비밀번호 확인</label> 
			    <div class="col-md-4 inputGroupContainer">
			    <div class="input-group">
			  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			  <input name="pwChk" placeholder="비밀번호 확인" class="form-control"  type="password" required="required">
			    </div>
			  </div>
			</div>
			  <div class="form-group" style="margin-left: 40%;"> 
			  <label class="col-md-4 control-label">이메일</label>
			    <div class="col-md-4 selectContainer">
			    <div class="input-group">
			        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
			    <input name="email" placeholder="Email" class="form-control"  type="text" required="required">
			  </div>
			</div>
			</div>
			  
			<!-- Text input-->
			
			<div class="form-group" style="margin-left: 40%;">
			  <label class="col-md-4 control-label">이름</label>  
			  <div class="col-md-4 inputGroupContainer">
			  <div class="input-group">
			  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			  <input  name="name" placeholder="이름" class="form-control"  type="text" required="required">
			    </div>
			  </div>
			</div>
			
			<!-- Text input-->
			
			<div class="form-group" style="margin-left: 40%;">
			  <label class="col-md-4 control-label" >구분</label> 
			    <div class="col-md-4 inputGroupContainer">
			    <div class="input-group">
			  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			  <select name="state" id="state">
			  	<option value="1" selected="selected">회원</option>
			  	<option value="2">직원</option>
			  </select>
			  	<input type="hidden" id="dept" name="dept">
			    </div>
			  </div>
			</div>
			
			
			
			<!-- Text input-->
			       <div class="form-group" style="margin-left: 40%;">  
			    <div class="col-md-4 inputGroupContainer">
			    <div class="input-group">
			        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
			    <button type="button" id="resetButton"  style="height: 25px; margin-left:0px; background-color:#ffffff; border-color: transparent; color:black; display: none;">-다시선택-</button> 
               <div class="image-upload" id="image-upload">
                  <div class="button">
                     <label class="btn btn-dark" for="chooseFile"> 프로필 이미지 파일 선택</label>
                  </div>
                  <input type="file" id="chooseFile" name="chooseFile"
                     accept="image/*" onchange="loadFile(this)" style="visibility: hidden;">
                                                                 
                  
                  <div class="fileContainer">
                     <div class="fileInput">
                       <p id="fileName">-FileName-</p>
                     </div>
                     <div class="buttonContainer">
                           
                        <div class="btn btn-dark" id="submitButton">미리보기</div>
                     </div>
                  </div>
               </div>
   
               <div class="image-show" id="image-show"></div>
			    </div>
			  </div>
			</div>
			<script src="js/index.js"></script>
			
			
			
			
			
			<!-- Button -->
			<div class="form-group" style="margin-left: 44%;">
			  <label class="col-md-4 control-label"></label>
			  <div class="col-md-4" ><br>
			    <button type="submit" class="btn btn-info" >가입하기 <span class="glyphicon glyphicon-send"></span></button>
			  </div>
			</div>
			
	</fieldset>
</form>
</div>
    </div><!-- /.container -->
</body>
</html>