<%@page import="Utils.DBUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Utils.MemberDTO, java.util.*"%>
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
	text-align: left;
	margin: 0 auto;
}

th, td {
	padding: 5px;
	border: 1px solid;
}

th {
	text-align: center;
}

h2 {
	text-align: center;
}

input[type="text"], select {
	width: 200px;
}
</style>
</head>
<body>
	<div class="wrapper">
		<%@ include file="/layouts/Header.jsp"%>
		<%@ include file="/layouts/Nav.jsp"%>
		<main>
			<section>
				<h2>투표하기</h2>
				<form name="vote_form" action="./create.jsp" method="post">
					<table>
						<tbody>
							<tr>
								<th>주민번호</th>
								<td><input type="text" name="v_jumin" maxlength="13">
									예 : 99010110001</td>
							</tr>
							<tr>
								<th>성명</th>
								<td><input type="text" name="v_name" maxlength="20"></td>
							</tr>
							<tr>
								<th>투표번호</th>
								<td><select name="m_no">
										<option hidden></option>
										<%
										List<MemberDTO> list = DBUtils.getInstance().selectAllMember();
										for (MemberDTO memberDTO : list) {
										%>
										<option>[<%=memberDTO.getM_no()%>]
											<%=memberDTO.getM_name()%></option>
										<%
										}
										%>
								</select></td>
							</tr>
							<tr>
								<th>투표시간</th>
								<td><input type="text" name="v_time" maxlength="4"></td>
							</tr>
							<tr>
								<th>투표장소</th>
								<td><input type="text" name="v_area" maxlength="20"></td>
							</tr>
							<tr>
								<th>유권자확인</th>
								<td><input type="radio" name="v_confirm" value="Y">
									<label>확인</label> <input type="radio" name="v_confirm"
									value="N"> <label>미확인</label></td>
							</tr>
							<tr>
								<th colspan="2">
									<button type="button" onclick="isValid()">투표하기</button>
									<button type="reset">다시하기</button>
								</th>
							</tr>
						</tbody>
					</table>
					<input type="submit" name="submit" style="display: none">
				</form>
			</section>
		</main>
		<%@ include file="/layouts/Footer.jsp"%>
	</div>
	<script type="text/javascript">
		function isValid() {
			var form = document.vote_form;
			if (form.v_jumin.value === "") {
				alert("주민번호가 입력되지 않았습니다!");
				form.v_jumin.focus();
				return true;
			}
			if (form.v_name.value === "") {
				alert("성명이 입력되지 않았습니다!");
				form.v_name.focus();
				return;
			}
			if (form.m_no.value === "") {
				alert("후보번호가 선택되지 않았습니다!");
				form.m_no.focus();
				return;
			}
			if (form.v_time.value === "") {
				alert("투표시간이 입력되지 않았습니다!");
				form.v_time.focus();
				return;
			}
			if (form.v_area.value === "") {
				alert("투표장소가 입력되지 않았습니다!");
				form.v_area.focus();
				return;
			}
			if (form.v_confirm.value === "") {
				alert("유권자확인이 선택되지 않았습니다!");
				form.v_confirm.focus();
				return;
			}
			form.submit.click();
		}
	</script>
</body>
</html>