<%@page import="java.util.Date"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/* response.sendRedirect(""); */

/* response.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT); */
/* response.sendError(HttpServletResponse.SC_NOT_FOUND,"해당 페이지를 찾을 수 없습니다."); */
/* response.sendError(HttpServletResponse.SC_FORBIDDEN,"접근금지"); */
/* response.sendError(HttpServletResponse.SC_BAD_GATEWAY,"서버 장애"); */

/* response.setIntHeader("Refresh", 3); */

/* ServletOutputStream bout = response.getOutputStream();
bout.write('a');
bout.write(98);
bout.flush();
bout.close(); */

PrintWriter o = response.getWriter();
o.write("<h1> HELLO WORLD</h1>");
%>
<%=new Date() %>
</body>
</html>