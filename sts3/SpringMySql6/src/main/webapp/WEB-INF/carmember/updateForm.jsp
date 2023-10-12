<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
<form action="update" method="post">
<input type="hidden" name="num" value="${dto.num }">
<table class="table table-bordered" style="width:300px;">
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="name" class="form-control" value="${dto.name }">
		</td>
	</tr>
	<tr>
		<th>핸드폰 번호</th>
		<td>
			<input type="text" name="hp" class="form-control" value="${dto.hp }">
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="addr" class="form-control" value="${dto.addr }">
		</td>
	</tr>
	<tr>
		<td>
		<button type="submit" class="btn btn-success">데이터 수정</button>
		</td>
	</tr>

</table>
</form>
</body>
</html>