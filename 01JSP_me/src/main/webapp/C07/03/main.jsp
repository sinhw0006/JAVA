<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if(session.getAttribute("isAuth")==null){
    	response.sendRedirect("./login_form.jsp?message=Session invalidate Expired");
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./logout.jsp">로그아웃</a>
<h1>MAIN</h1>
<h4>표현식</h4>
isAuth : <%=session.getAttribute("isAuth") %><br>
ROLE : <%=session.getAttribute("role") %>

<h4>EL</h4>
isAuth : ${isAuth}<br>
ROLE : ${role}
</body>
</html>