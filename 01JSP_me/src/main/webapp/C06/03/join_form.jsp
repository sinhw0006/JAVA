<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
label {
	font-size: .8rem;
}
span{
font-size: .5rem;
color: red;
}
</style>

</head>
<body>
	<h1>JOIN</h1>
	<div style="min-height: 25px; font-size: .8rem; color: orange;">
	${message}
	</div>
	<form action="${pageContext.request.contextPath}/C06/03/join.jsp"
		method="post">
		<div>
			<label>아이디 : </label>
			<span>${errorName}</span><br>
			<input type="text" name="username" />
		</div>

		<div>
			<label>패스워드 : </label>
			<span>${errorPW}</span><br>
			<input type="password" name="password" />
		</div>
		<div>
			<input type="submit" value="회원가입" />
		</div>
	</form>
</body>
</html>