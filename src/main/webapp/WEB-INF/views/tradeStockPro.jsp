<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${result == 11 }">
	<script type="text/javascript">
		alert("잔액이 부족합니다.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 10 }">
	<script type="text/javascript">
		alert("보유수량보다 주문한 수량이 많습니다.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 9 }">
	<script type="text/javascript">
		alert("보유수량보다 주문한 수량이 많습니다.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 8 }">
	<script type="text/javascript">
		alert("오류입니다.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 7 }">
	<script type="text/javascript">
		alert("매수 청산 완료.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 6 }">
	<script type="text/javascript">
		alert("매도 청산 완료.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 5 }">
	<script type="text/javascript">
		alert("매수 및 매도를 선택해 주세요.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 4 }">
	<script type="text/javascript">
		alert("주문수량을 입력해 주세요.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 3 }">
	<script type="text/javascript">
		alert("추가 매도완료.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 2 }">
	<script type="text/javascript">
		alert("매도완료.");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("매수완료");
		location.href="index2";
	</script>
</c:if>
<c:if test="${result == 1 }">
	<script type="text/javascript">
		alert("추가 매수완료");
		location.href="index2";
	</script>
</c:if>
</body>
</html>