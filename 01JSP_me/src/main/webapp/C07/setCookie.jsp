<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Cookie cookie1 = new Cookie("myCookie1", "myCookie1Value");
    cookie1.setMaxAge(30);
    
    Cookie cookie2 = new Cookie("myCookie2", "myCookie2Value");
    cookie1.setMaxAge(60*5);
    
    response.addCookie(cookie1);
    response.addCookie(cookie2);
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