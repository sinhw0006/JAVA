<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./01PageContext.jsp">
<input type="text" name="name">
<button>제출</button>
</form>
<%
System.out.println("pageContext : " + pageContext);
System.out.println("pageContext : " + pageContext.getResponse());
System.out.println("pageContext : " + pageContext.getSession());
System.out.println("pageContext : " + pageContext.getServletContext());
System.out.println("pageContext : " + pageContext.getRequest().getParameter("name"));

System.out.println("project path : " + pageContext.getServletContext().getContextPath());
%>
PROJECTPATH : <%=pageContext.getServletContext().getContextPath() %><br>

PROJECTPATH : ${pageContext.request.contextPath}


</body>
</html>