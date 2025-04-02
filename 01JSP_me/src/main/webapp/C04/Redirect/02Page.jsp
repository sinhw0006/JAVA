<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println("-----------02PAGE-----------");
    System.out.println("- username : "+username);
    System.out.println("- password : "+password);    
    System.out.println("----------------------------");
    response.sendRedirect("./03Page.jsp?hobby="+URLEncoder.encode("등산","UTF-8"));
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
</body>
</html>