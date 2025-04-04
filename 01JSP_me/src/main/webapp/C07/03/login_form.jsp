<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
    if(session.getAttribute("isAuth")!=null){
    	response.sendRedirect("./main.jsp");
    	
    }
    %>
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
	<h1>LOGIN</h1>
	<div style="min-height: 25px; font-size: .8rem; color: orange;">
	${param.message}
	</div>
	<form action="${pageContext.request.contextPath}/C07/03/login.jsp"
		method="post">
		<div>
			<label>아이디 : </label>
			<span>${error_id}</span><br>
			<input type="text" name="username" value="${cookie.idSave.value}"/>
		</div>

		<div>
			<label>패스워드 : </label>
			<span>${error_pw}</span><br>
			<input type="password" name="password" value="${cookie.pwSave.value}"/>
		</div>
		<div>
		<input type="checkbox" id="idSave" name="idSave" ${cookie.idSave != null ? 'checked=\"checked\"' : ''}>
		<label for="idSave">ID 저장</label>
		
		<input type="checkbox" id="pwSave" name="pwSave" ${cookie.pwSave != null ? 'checked=\"checked\"' : ''}>
		<label for="pwSave">PW 저장</label>
		</div>
		<div>
			<input type="submit" value="로그인" />
		</div>
	</form>
</body>
</html>