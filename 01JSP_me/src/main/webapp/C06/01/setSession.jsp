<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //Request (요청 마다 초기화)
    request.setAttribute("ID1", "Request_ID");
    request.setAttribute("PW1", "1111");    
    
    //Session (지정된 시간까지 유지 / 기본 1800초(30분))
    session.setAttribute("ID2", "Session_ID");
    session.setAttribute("PW2", "2222");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./getSession.jsp">정보 확인</a>
</body>
</html>