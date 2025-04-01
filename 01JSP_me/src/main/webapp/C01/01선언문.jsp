<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 선언문 -->
	<%!
	//서블릿파일의 멤버변수(속성)
	String name = "Hong Gil Dong";
	//서블릿파일의 멤버함수(기능)
	public String testFunc(){
		System.out.println("선언문 TEST");
		return "name :" + name;
	}
	%>
	<!-- 표현식 -->
	NAME : <%=name %></br>
	testFunc() : <%=testFunc() %></br>
</body>
</html>