<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Utils.DBUtils"%>
<%@page import="Utils.teacherDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String a = pageContext.getRequest().getRealPath("/");
System.out.println(a);
%>
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
				<%
				List<teacherDTO> list = DBUtils.getInstance().teacherAllSelect();
				%>
				<h2>강사조회</h2>
				<table>
					<thead>
						<tr>
							<th>강사코드</th>
							<th>강사명</th>
							<th>강의명</th>
							<th>수강료</th>
							<th>강사자격취득일</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (teacherDTO teacherDTO : list) {
						%>
						<tr>
							<td><%=teacherDTO.getTeacher_code()%></td>
							<td><%=teacherDTO.getTeacher_name()%></td>
							<td><%=teacherDTO.getClass_name()%></td>
							<%
							Locale locale = new Locale("ko","KR");
							NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
							String price = numberFormat.format(teacherDTO.getClass_price());
							out.print("<td>"+ price + "</td>");
							
							teacherDTO.getTeacher_regist_date();
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
							LocalDate day = LocalDate.parse(teacherDTO.getTeacher_regist_date(),formatter);
							formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
							String registDate = day.format(formatter);
							out.print("<td>"+ registDate + "</td>");
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