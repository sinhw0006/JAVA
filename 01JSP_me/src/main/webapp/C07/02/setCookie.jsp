<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Cookie cookie1 = new Cookie("c1","v1");
cookie1.setMaxAge(60*10);
cookie1.setPath("/");

Cookie cookie2 = new Cookie("c2","v2");
cookie2.setMaxAge(60*10);
cookie2.setPath("./");

Cookie cookie3 = new Cookie("c3","v3");
cookie3.setMaxAge(60*10);
cookie3.setPath("/01JSP_me/C07/02/getCookie.jsp");

response.addCookie(cookie1);
response.addCookie(cookie2);
response.addCookie(cookie3);

response.sendRedirect("./getCookie.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>