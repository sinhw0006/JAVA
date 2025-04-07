<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 품목별 총합 (내림차순) -->

<%@ page import="C09.DBUtils,C09.UserDto,java.util.*, C09.OrderDto, C09.OrderDto2"%>
<%
List<OrderDto> list = DBUtils.getInstance().selectAllOrder();
List<OrderDto2> list2 = DBUtils.getInstance().selectAllOrder2();
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
	<h1>품목별 총액(50000원 이상)</h1>
	<table>
		<thead>
			<tr>
				<td>품목</td>
				<td>총합</td>
			</tr>
		</thead>
		<tbody>

			<%
			for (OrderDto orderDto : list) {
			%>
			<tr>
				<td><%=orderDto.getCategory()%></td>
				<td><%=orderDto.getSum()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<h1>날짜별 구매 총평균</h1>
	<table>
		<thead>
			<tr>
				<td>품목</td>
				<td>총합</td>
			</tr>
		</thead>
		<tbody>

			<%
			for (OrderDto2 orderDto : list2) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
			%>
			<tr>
				<td><%=orderDto.getDate().format(formatter)%></td>
				<td><%=orderDto.getAvg()%></td>
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