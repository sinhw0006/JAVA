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
request.getRequestDispatcher("./04Result.jsp").forward(request, response);
%>
