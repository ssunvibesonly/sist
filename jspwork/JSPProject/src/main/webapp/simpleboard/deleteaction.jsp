<%@page import="db.simpleboard.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
String num=request.getParameter("num");
String pass=request.getParameter("pass");

SimpleBoardDao dao=new SimpleBoardDao();

boolean flag=dao.passCheck(num, pass);

if(flag){
	dao.deleteBoard(num);
	response.sendRedirect("boardlist.jsp");
	
}else{%>
<script>
	alert("비밀번호가 틀렸습니다.")
	history.back();
</script>	
<% }

%>
</body>
</html>