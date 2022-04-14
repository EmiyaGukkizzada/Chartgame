<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	
<%@include file = "header.jsp"%>
<!-- 
<script type="text/javascript">
  
		function test() {
			if (!(frm.pw.value == frm.pwChk.value)) {
				alert("비밀번호가 일치하지 않습니다");
				return false;
			}
		}

		function delChk() {

			var check;
			check = confirm("정말 탈퇴하시겠습니까?");
			if (check == true) {
				location.href = "memberDelete?id=${member.id}";
			} else if (check == false) {
				return false;
			}
		}
</script> -->
</head>
<body>
   <!-- Back to top button -->
   <div class="back-to-top"></div>
   <div style="text-align: center; margin-top: 100px;">
      <form action="memberUpdateForm" name="frm" onsubmit="return test()">
         <c:choose>
             <c:when test="${empty result}">
             </c:when>
             <c:when test="${result eq '-1'}">
                 <script type="text/javascript">
                    alert("회원정보 수정에 실패하였습니다.");
                 </script>
             </c:when>
             <c:otherwise>
                 <script type="text/javascript">
                    alert("회원정보가 수정되었습니다.");
                 </script>
             </c:otherwise>
         </c:choose>
         <h2>내 정보</h2>
         <p>My Info</p>
         <hr style="width: 30%; height: 40px">
         회원 ID <br> <input type="text" name="id" value="${member.id}"
            readonly="readonly"><br>

         <div style="margin-top: 2%">
            이름 <br> <input type="text" name="name" value="${member.name }"
               readonly="readonly"> <br>
         </div>
         <div style="margin-top: 2%">
            이메일 <br> <input type="text" name="email" value="${member.email }"
               readonly="readonly"> <br>
         </div>

         <div style="margin-top: 4%; margin-bottom: 397px;">
            <!-- <input type="submit" value="수정" class="btn btn-sm btn-primary">
            <input type="button" value="탈퇴"  onclick="delChk()"
               class="btn btn-sm btn-primary"> -->
         </div>
      </form>
   </div>
	<%@include file = "footer.jsp"%>
</body>
</html>