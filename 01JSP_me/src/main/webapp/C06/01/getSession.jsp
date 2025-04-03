<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>REQUEST</h1>
ID : <%=request.getAttribute("ID1") %>
PW : <%=request.getAttribute("PW1") %>
<h1>Session</h1>
ID : <%=session.getAttribute("ID2") %>
PW : <%=session.getAttribute("PW2") %>


</body>
</html>