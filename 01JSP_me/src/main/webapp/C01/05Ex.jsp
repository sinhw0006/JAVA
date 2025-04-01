<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<%
				java.util.Scanner sc = new java.util.Scanner(System.in);
				System.out.print("값 입력 : ");
				int a = sc.nextInt();
				for (int i = 1; i < 10; i++) {
				%>
				<tr>
				<td style="border: 1px solid;"><%=a +" X "+ i +" = "+(a*i)%></td>
				</tr>
				<%
				}
				%>
			
		</tbody>
	</table>
</body>
</html>