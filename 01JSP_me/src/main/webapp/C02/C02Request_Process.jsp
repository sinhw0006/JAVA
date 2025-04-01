
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>
<%--    
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String bgColor = request.getParameter("bgcolor");
        System.out.printf("%s, %s, %s\n", username, password, bgColor);
        %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: <%=bgColor.equals("") ? "gray" : bgColor%>">
username : <%=username%><br/>
password : <%=password%><br/>bgColor : <%=bgColor%>
</body>
</html> --%>


<!-- EL -->
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body style="background-color:${param.bgcolor}">
	EL_Username : ${param.username}
	<br /> EL_Password : ${param.password}
	<br />
</body>
</html>