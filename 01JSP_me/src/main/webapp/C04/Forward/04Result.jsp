<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");
String page02Value = (String)request.getAttribute("02Page");
String page03Value = (String)request.getAttribute("03Page");
System.out.println("-----------04Result-----------");
System.out.println("- username : " + username);
System.out.println("- password : " + password);
System.out.println("- page02Value : " + page02Value);
System.out.println("- page03Value : " + page03Value);
System.out.println("----------------------------");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>RESULT</h1>
	USERNAME : <%=username%><br>
	PASSWORD : <%=password%><br>
	PAGE02VALUE : <%=page02Value%><br>
	PAGE03VALUE : <%=page03Value%><br>
</body>
</html>