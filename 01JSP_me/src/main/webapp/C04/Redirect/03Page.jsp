<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");
String page02Value = (String)request.getAttribute("02Page");
System.out.println("-----------03PAGE-----------");
System.out.println("- username : " + username);
System.out.println("- password : " + password);
System.out.println("- page02Value : " + page02Value);
System.out.println("----------------------------");

request.setAttribute("03Page", "03PageValue");

String hobby=request.getParameter("hobby");
System.out.println(hobby);

response.sendRedirect("./04Result.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>03PAGE</h1>
	USERNAME : <%=username%><br>
	PASSWORD : <%=password%><br>
	PAGE02VALUE : <%=page02Value%><br>
</body>
</html>