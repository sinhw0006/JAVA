<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.Scanner,C03.SimpleDTO"%>

<%
Scanner sc = new Scanner(System.in);
SimpleDTO simpleDTO = new SimpleDTO("홍길동",24,"대구");
System.out.println(simpleDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name : <%=simpleDTO.getName() %>
age : <%=simpleDTO.getAge() %>
addr : <%=simpleDTO.getAddr() %>
</body>
</html>