<%@page import="java.time.Period"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Utils.VoteDTO"%>
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
				<h2>ㅁㅁㅁ</h2>
				<table>
					<thead>
						<tr>
							<th>성명</th>
							<th>생년월일</th>
							<th>나이</th>
							<th>성별</th>
							<th>후보번호</th>
							<th>투표시간</th>
							<th>유권자확인</th>
						</tr>
					</thead>
					<tbody>
						<!-- useBean -->
						<jsp:useBean id="voteDTO" class="Utils.VoteDTO" scope="request"/>
						<jsp:setProperty property="*" name="voteDTO" />
						<tr>
							<td><%=voteDTO.getV_name()%></td>
							<td><%=voteDTO.getV_jumin()%></td>
							<%
							String age = "19" + voteDTO.getV_jumin().substring(0,6);
							System.out.println(age);
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
							LocalDate date = LocalDate.parse(age,formatter);
							
							LocalDate today = LocalDate.now();
							
							int ages = Period.between(date, today).getYears();
							
							
							%>
							<td>만 <%=ages%>세</td>
							<%
							String gender = voteDTO.getV_jumin().charAt(6) % 2 == 0 ? "여자" : "남자" ;
							%>
							<td><%=gender%></td>
							<td><%=voteDTO.getM_no().substring(1,2)%></td>
							<td><%=voteDTO.getV_time()%></td>
							<td><%=voteDTO.getV_confirm()%></td>
						</tr>
					</tbody>
				</table>
			</section>
		</main>
		<%@ include file="/layouts/Footer.jsp"%></div>
</body>
</html>