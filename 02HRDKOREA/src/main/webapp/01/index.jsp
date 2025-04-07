<%@page import="Utils.DBUtils"%>
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
h2{
text-align: center;
}
</style>
</head>
<body>
	<%@ page import="java.util.*,Utils.MemberDTO"%>
	<%
	List<MemberDTO> list = DBUtils.getInstance().selectAllMember();
	%>
	<div class="wrapper">
		<%@ include file="/layouts/Header.jsp"%>
		<%@ include file="/layouts/Nav.jsp"%>
		<main>
			<section>
					<h2>후보조회</h2>
					<table>
						<thead>
							<tr>
								<th>후보번호</th>
								<th>성명</th>
								<th>소속정당</th>
								<th>학력</th>
								<th>주민번호</th>
								<th>지역구</th>
								<th>대표전화</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (MemberDTO memberDTO : list) {
								String jumin = memberDTO.getM_jumin().substring(0, 6) + "-" + memberDTO.getM_jumin().substring(6);
							%>
							<tr>
								<td><%=memberDTO.getM_no()%></td>
								<td><%=memberDTO.getM_name()%></td>
								<td><%=memberDTO.getP_name()%></td>
								<td><%=memberDTO.getP_school()%></td>
								<td><%=jumin%></td>
								<td><%=memberDTO.getM_city()%></td>
								<td><%=memberDTO.getP_tel1() + "-" + memberDTO.getP_tel2() + "-" + memberDTO.getP_tel3()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
			</section>
		</main>
		<%@ include file="/layouts/Footer.jsp"%></div>
</body>
</html>