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
<%

String num=request.getParameter("num");

SinSangDao dao=new SinSangDao();
SinSangDto dto=dao.getData(num);

%>

<body>
<form action="updateAction.jsp" method="post">

	<!-- hidden은 위치 상관 없다 폼 안에만 있으면 됨 -->
	<input type="hidden" name="num" value="<%=num %>">
	<table class='table table-bdrdered' style="width:400px;">
	<tr>
		<th>이름</th>
		<td>
		<input type='text' name='name' style='width: 150px;' ,
		required="required" class='form-control' value="<%=dto.getName()%>">
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
		<input style='width: 150px;'type="text" name="addr" size="7" value="<%=dto.getAddr() %>" required="required" class="form-control">
		</td>
	</tr>
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="수정" class="btn btn-info">
	<input type="button" value="목록" onclick="location.href='list.jsp'" class='btn btn-success'>
	</td>
	</tr>
	
	</table>

</form>
</body>
</html>