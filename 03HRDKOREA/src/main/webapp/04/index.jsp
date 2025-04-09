<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="Utils.DBUtils"%>
<%@page import="Utils.teacherInfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
:root {
	
}

* {
	box-sizing: border-box;
}

body {
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

a {
	display: block;
	text-decoration: none;
	color: black;
}

wrapper {
	
}

.wrapper>header {
	height: 80px;
}

.wrapper>nav {
	height: 50px;
}

.wrapper>main {
	
}

.wrapper>main>section {
	height: calc(100vh - 210px);
}

.wrapper>footer {
	height: 80px;
}

table {
	border-collapse: collapse;
	text-align: center;
	margin: 0 auto;
}

th, td {
	border: 1px solid;
	padding: 5px;
	width: 150px;
}

h2 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="wrapper">
		<%@ include file="/layouts/Header.jsp"%>
		<%@ include file="/layouts/Nav.jsp"%>
		<main>
			<section>
				<h2>강사매출현황</h2>
				<table>
					<thead>
						<tr>
							<th>수강월</th>
							<th>강의명</th>
							<th>강사명</th>
							<th>총매출</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<teacherInfoDTO> list = DBUtils.getInstance().teacherInfoSelect();
						for (teacherInfoDTO teacherInfoDTO : list) {
						%>
						<tr>
							<td><%=teacherInfoDTO.getTeacher_code()%></td>
							<td><%=teacherInfoDTO.getClass_name()%></td>
							<td><%=teacherInfoDTO.getTeacher_name()%></td>
							<%
							Locale locale = new Locale("ko", "KR");
							NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
							String price = numberFormat.format(teacherInfoDTO.getSum());
							out.print("<td>" + price + "</td>");
							%>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
			</section>
		</main>
		<%@ include file="/layouts/Footer.jsp"%>
	</div>
</body>
</html>