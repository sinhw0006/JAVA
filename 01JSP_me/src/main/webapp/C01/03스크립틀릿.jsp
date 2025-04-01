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
	String str1 = "Hello01";
	String str2 = "Hello02";
	String str3 = str1+str2;
	int a = 0;
	for(int i=0; i<10; i++){
		a++;
		System.out.println(i);
	}
	%>
	<%=str1 %>
	<%=str2 %>
	<%=str3 %>
	<%=a %>
</body>
</html>