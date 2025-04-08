<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@page import="Utils.DBUtils"%>
<%@page import="Utils.VoteDTO"%>
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
				<h2>투표검수조회</h2>
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
						<%
						List<VoteDTO> list = DBUtils.getInstance().selectAllVote();
						for (VoteDTO voteDTO : list) {
							if (voteDTO.getV_area().trim().equals("제1투표장")) {
						%>
						<tr>
							<%
							out.print("<td>" + voteDTO.getV_name() + "</td>");

							String value = "19" + voteDTO.getV_jumin().substring(0, 6);
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
							LocalDate day = LocalDate.parse(value, formatter);
							formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일생");
							String birtyday = day.format(formatter);
							out.print("<td>" + birtyday + "</td>");

							LocalDate now = LocalDate.now();
							int age = Period.between(day, now).getYears();
							out.print("<td>만 " + age + "세</td>");

							String gender = voteDTO.getV_jumin().charAt(6) % 2 == 0 ? "여자" : "남자";
							out.print("<td>" + gender + "</td>");

							out.print("<td>" + voteDTO.getM_no() + "</td>");

							String time = voteDTO.getV_time().substring(0, 2) + ":" + voteDTO.getV_time().substring(2, 4);
							out.print("<td>" + time + "</td>");

							if (voteDTO.getV_confirm().equals("Y")) {
								out.print("<td>확인</td>");
							} else {
								out.print("<td>미확인</td>");
							}
							%>
						</tr>
						<%
						}
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