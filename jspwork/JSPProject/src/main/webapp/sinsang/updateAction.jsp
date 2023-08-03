<%@page import="model.sinsang.SinSangDao"%>
<%@page import="model.sinsang.SinSangDto"%>
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
	//데이터를 읽어서 dto에 넣기
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	String num=request.getParameter("num");
	
	SinSangDto dto=new SinSangDto();
	
	dto.setName(name);
	dto.setAddr(addr);
	dto.setNum(num);
	
	//update호출
	SinSangDao dao=new SinSangDao();
	dao.updateSinsang(dto);
	
	//목록으로 이동
	response.sendRedirect("list.jsp");
	
%>
</body>
</html>