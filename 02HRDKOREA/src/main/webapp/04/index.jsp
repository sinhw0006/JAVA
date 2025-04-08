<%@page import="Utils.DBUtils"%>
<%@page import="java.util.List"%>
<%@page import="Utils.CountVoteDTO"%>
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

th,td {
	border: 1px solid;
	padding: 5px;
}
h2{
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
			<h2>후보자 등수</h2>
			<table>
						<thead>
							<tr>
								<th>후보번호</th>
								<th>성명</th>
								<th>총투표건수</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<CountVoteDTO> list = DBUtils.getInstance().CountVote();
							for (CountVoteDTO countVoteDTO : list) {
							%>
							<tr>
								<td><%=countVoteDTO.getM_no()%></td>
								<td><%=countVoteDTO.getV_name()%></td>
								<td><%=countVoteDTO.getCount()%></td>
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