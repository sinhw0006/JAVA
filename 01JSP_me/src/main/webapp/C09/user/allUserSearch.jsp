<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="C09.DBUtils"%>
<%@ page import="C04.UserDto"%>

<%
//서비스 실행
int pages = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

DBUtils db = DBUtils.getInstance();
int userCount = (int)Math.ceil(db.userCount()/10.0);
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
	border : 1px solid;
	padding: 5px;
}
a{
text-decoration: none;
list-style: none;
}
</style>
</head>
<body>
	<h1>SelectAll</h1>
	<table>
		<thead>
			<tr>
			    <td>INDEX</td>
				<td>USERID</td>
				<td>PASSWORD</td>
				<td>ROLE</td>
				<td></td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<%
			int i = (pages-1)*10;
			for (UserDto userDTO : userDtos) {
				i++;
			%>
			<tr>
			    <td><%=i%></td>
				<td><%=userDTO.getUserid()%></td>
				<td><%=userDTO.getPassword()%></td>
				<td><%=userDTO.getRole()%></td>
				<td><a href="./userUpdate.jsp?userid=<%=userDTO.getUserid()%>">수정</a></td>
				<td><a href="./userDelete.jsp?userid=<%=userDTO.getUserid()%>">삭제</a></td>
			</tr>
			<%
			}
			i = 0;
			%>
		</tbody>
	</table>
	<%
	for(int c= 0; c<userCount; c++){
		%>
		<a href="?page=<%=c+1%>"><%=c+1%></a>
		<%
	}
	%>
	<hr>
	<a href="./join_form.jsp">유저 생성</a>
</body>
</html>