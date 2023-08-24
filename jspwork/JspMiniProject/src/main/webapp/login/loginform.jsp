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
<style type="text/css">
.loginform{

margin-left:300px;
}
.cnter{
margin-top:130px;

}


</style>
<%
//세션값 얻기
String saveok=(String)session.getAttribute("saveok");

String myid="";
if(saveok!=null){
	myid=(String)session.getAttribute("myid");
}


%>
</head>
<body>


<div class="loginform" >
  	<form action="login/loginaction.jsp" method="post">
  	<h2>루피월드 로그인</h2><br>
  		<input type="text" name="id" style="width:200px;"
  		class="form-control" placeholder="로그인 아이디" required="required" value="<%=myid %>" ><br>
  		<input type="password" name="pass" style="width:200px" class="form-control" placeholder="로그인 비밀번호" required="required"><br>
  		<label><input type="checkbox" name="cbsave" <%=saveok==null?"":"checked" %> >아이디 저장</label><br><br> <!-- //value값이 없으면 null이나 on으로 나옴 -->
  		<button type="submit" class="btn btn-success btn-lg"
  		style="width:200px;">로그인</button>
  	</form>
  	</div>
</body>
</html>