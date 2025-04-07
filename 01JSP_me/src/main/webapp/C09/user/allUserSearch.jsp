<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="C09.DBUtils"%>
<%@ page import="C09.UserDto"%>

<%
//서비스 실행
int pages = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

DBUtils db = DBUtils.getInstance();
int userCount = db.userCount();
int pageCount = (int) Math.ceil(userCount / 10.0);
if(pages > pageCount) pages = pageCount;
if(pages <= 0) pages = 1;
List<UserDto> userDtos = db.selectAllUser(pages);
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

.pages {
	color: red;
}
</style>
</head>
<body>
	USER :
	<%=userCount%>
	<div
		style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<h1>SelectAll</h1>
		<table>
			<thead>
				<tr>
					<td>INDEX</td>
					<td>USERID</td>
					<td>ADDR</td>
					<td>PASSWORD</td>
					<td>ROLE</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<%
				int i = (pages - 1) * 10;
				for (UserDto userDTO : userDtos) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=userDTO.getUserid()%></td>
					<td><%=userDTO.getAddr()%></td>
					<td><%=userDTO.getPassword()%></td>
					<td><%=userDTO.getRole()%></td>
					<td><a href="./userUpdate.jsp?userid=<%=userDTO.getUserid()%>&page=<%=pages%>">수정</a></td>
					<td><a href="./userDelete.jsp?userid=<%=userDTO.getUserid()%>&page=<%=pages%>">삭제</a></td>
				</tr>
				<%
				}
				while (i % 10 != 0) {
				i++;
				%>
				<tr>
					<td><%=i%></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<%
				}
				i = 0;
				%>
			</tbody>
		</table>
		<div>
			<%
			if (pages != 1) {
			%>
			<a href="?page=<%=pages - 1%>">◀</a>
			<%
			}
			%>

			<%
			int minpage = pageCount > 5 ? pageCount - pages <= 1 ? pageCount - 5 : (pages - 3 <= 0 ? 0 : pages - 3) : 0;
			int maxpage = (pages - 3 <= 0 ? 0 : pages - 3) + 5 > pageCount ? pageCount : (pages - 3 <= 0 ? 0 : pages - 3) + 5;
			for (int c = minpage; c < maxpage; c++) {
				if ((c + 1) == pages) {
			%>
			<a class="pages" href="?page=<%=c + 1%>"><%=c + 1%></a>
			<%
			} else {
			%>
			<a href="?page=<%=c + 1%>"><%=c + 1%></a>
			<%
			}
			}
			%>
			<%
			if (pages != pageCount) {
			%>
			<a href="?page=<%=pages + 1%>">▶</a>
			<%
			}
			%>
		</div>
		<a href="./join_form.jsp">유저 생성</a>
		<hr>
		<a href="../order/selectAll.jsp">품목별 총합 조회</a> <a
			href="../order/selectAll2.jsp">지역 + 날짜별 구매총액</a>
	</div>
	<hr>
</body>
</html>