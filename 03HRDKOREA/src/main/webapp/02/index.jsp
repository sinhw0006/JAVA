<%@page import="Utils.teacherDTO"%>
<%@page import="java.util.List"%>
<%@page import="Utils.DBUtils"%>
<%@page import="Utils.memberDTO"%>
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
				<h2>수강신청</h2>
				<form name="form" action="./create.jsp" onsubmit="return isValid()">
					<table>
						<tbody>
							<tr>
								<th>수강월</th>
								<td><input type="text" name="regist_month"> 예)
									2022년03월 -> 202203</td>
							</tr>
							<tr>
								<th>회원명</th>
								<td><select name="c_name">
										<option hidden></option>
										<%
										List<memberDTO> list = DBUtils.getInstance().memberAllSelect();
										for (memberDTO memberDTO : list) {
											out.println("<option>" + memberDTO.getC_name() + "</option>");
										%>
										<%
										}
										%>
								</select></td>
							</tr>
							<tr>
								<th>회원번호</th>
								<td><input type="text" name="c_no" readonly>
									예)10001</td>
							</tr>
							<tr>
								<th>강의장소</th>
								<td><input type="text" name="class_area"></td>
							</tr>
							<tr>
								<th>강의명</th>
								<td><select name="class_name">
										<option hidden></option>
										<%
										List<teacherDTO> list2 = DBUtils.getInstance().teacherAllSelect();
										for (teacherDTO teacherDTO : list2) {
											out.println("<option>" + teacherDTO.getClass_name() + "</option>");
										%>
										<%
										}
										%>
								</select></td>
							</tr>
							<tr>
								<th>수강료</th>
								<td><input type="text" name="tuition" readonly>원</td>
							</tr>
							<tr>
								<th colspan="2">
									<button>수강신청</button>
									<button type="reset" onclick="resetinput()">다시쓰기</button>
								</th>
							</tr>
						</tbody>
					</table>
				</form>
			</section>
		</main>
		<%@ include file="/layouts/Footer.jsp"%>
	</div>

	<script type="text/javascript">
	    var member = new Map();
	    var teacher = new Map();
	    <%for (memberDTO memberDTO : list) {%>
		member.set("<%=memberDTO.getC_name()%>","<%=memberDTO.getC_no()%>");
		<%}%>
	    <%for (teacherDTO teacherDTO : list2) {%>
	    teacher.set("<%=teacherDTO.getClass_name()%>",<%=teacherDTO.getClass_price()%>);
		<%}%>
		const form = document.form;
		form.c_name.addEventListener('change',(e)=>{
			let select = e.target.value;
			form.c_no.value = member.get(select);
			form.tuition.value = null;
			form.class_name.value = null;
		});
		
		form.class_name.addEventListener('change',(e)=>{
			let select = e.target.value;
			if(parseInt(form.c_no.value) >= 20000){
                form.tuition.value = teacher.get(select) / 2;
            } else {
            	form.tuition.value = teacher.get(select);
            }
		});
		function isValid() {
			if (form.regist_month.value === "") {
				alert("수강월이 입력되지 않았습니다!");
				form.regist_month.focus();
				return false;
			}
			if (form.c_name.value === "") {
				alert("회원명이 입력되지 않았습니다!");
				form.c_name.focus();
				return false;
			}
			if (form.c_no.value === "") {
				alert("회원번호가 입력되지 않았습니다!");
				form.c_no.focus();
				return false;
			}
			if (form.class_area.value === "") {
				alert("강의장소가 입력되지 않았습니다!");
				form.class_area.focus();
				return false;
			}
			if (form.class_name.value === "") {
				alert("강의명이 입력되지 않았습니다!");
				form.class_name.focus();
				return false;
			}
			if (form.tuition.value === "") {
				alert("수강료가 입력되지 않았습니다!");
				form.tuition.focus();
				return false;
			}
			return true;
		}
		function resetinput() {
            console.log("test");
			alert("모든 정보를 지우고 처음부터 다시 입력합니다!");
			form.regist_month.focus();
		}
	</script>
</body>
</html>