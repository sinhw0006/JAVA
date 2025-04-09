<%@page import="java.time.LocalDate"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="Utils.DBUtils"%>
<%@page import="Utils.memberinfoDTO"%>
<%@page import="java.util.List"%>
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
				<h2>회원정보조회</h2>
				<table>
					<thead>
						<tr>
							<th>수강월</th>
							<th>회원번호</th>
							<th>회원명</th>
							<th>강의명</th>
							<th>강의장소</th>
							<th>수강료</th>
							<th>등급</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<memberinfoDTO> list = DBUtils.getInstance().memberInfoSelect();
						for (memberinfoDTO memberinfoDTO : list) {
						%>
						<tr>
							<%
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
							LocalDate day = LocalDate.parse(memberinfoDTO.getRegist_month() + "01", formatter);
							formatter = DateTimeFormatter.ofPattern("yyyy년MM월");
							String registDate = day.format(formatter);
							out.print("<td>" + registDate + "</td>");
							%>
							<td><%=memberinfoDTO.getC_no()%></td>
							<td><%=memberinfoDTO.getC_name()%></td>
							<td><%=memberinfoDTO.getClass_name()%></td>
							<td><%=memberinfoDTO.getClass_area()%></td>
							<%
							Locale locale = new Locale("ko", "KR");
							NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
							String price = numberFormat.format(memberinfoDTO.getTuition());
							out.print("<td>" + price + "</td>");
							%>
							<td><%=memberinfoDTO.getGrade()%></td>
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