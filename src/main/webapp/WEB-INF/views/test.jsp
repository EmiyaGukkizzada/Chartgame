<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	function hojun() {
		var x = document.getElementById("hojun");
		
		x.style.color = "red";
		x.style.fontSize = "200px";
	}
	function hojun_double() {
		var z = document.getElementById("hojun");
		
		z.style.color = "blue";
		z.style.fontSize = "100px";
	}
</script> 
<title>안녕호준</title> 
</head>
<body>

<h2 id="hojun" onclick="hojun()" ondblclick="hojun_double()" >안녕 나는 호준이야</h2>
</body>
</html>