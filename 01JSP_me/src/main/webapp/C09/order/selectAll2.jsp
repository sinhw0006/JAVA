<%@page import="C09.DBUtils"%>
<%@page import="C09.OrderDto3"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<OrderDto3> list = DBUtils.getInstance().selectAllOrder3();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	text-align: center;
	border: 1px solid;
	padding: 5px;
}

a {
	text-decoration: none;
	list-style: none;
}
</style>
</head>
<body>
	<h1>지역 + 날짜별 구매총액</h1>
	<table>
		<thead>
			<tr>
				<td>ADDR</td>
				<td>DATE</td>
				<td>SUM</td>
			</tr>
		</thead>
		<tbody>
			<%
			for (OrderDto3 orderDto : list) {
			%>
			<tr>
				<td><%=orderDto.getAddr()%></td>
				<td><%=orderDto.getDate()%></td>
				<td><%=orderDto.getSum()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<hr>
	<a href="../user/allUserSearch.jsp">돌아가기</a>
</body>
</html>