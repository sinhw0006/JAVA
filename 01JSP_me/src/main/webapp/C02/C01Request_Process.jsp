<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String bgColor = request.getParameter("bgcolor");
    System.out.printf("%s, %s, %s\n",username,password,bgColor);
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: <%=bgColor.equals("") ? "gray" : bgColor%>">
username : <%=request.getParameter("username")%><br/>
password : <%=request.getParameter("password")%><br/>
bgColor : <%=bgColor %>
</body>
</html>