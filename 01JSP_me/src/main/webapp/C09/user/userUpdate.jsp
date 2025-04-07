<%@page import="C09.UserDto"%>
<%@page import="C09.DBUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
// 파라미터값 확인
String userid = request.getParameter("userid");
int pages = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
String changeuserid = request.getParameter("changeuserid") != null ? request.getParameter("changeuserid") : null;
String addr = request.getParameter("addr") != null ? request.getParameter("addr") : null;
String password = request.getParameter("password") != null ? request.getParameter("password") : null;
String role = request.getParameter("role") != null ? request.getParameter("role") : null;


UserDto userDto = null;

//DB 연결
DBUtils db = DBUtils.getInstance();

// 2번째 호출
if (role != null) {	
	userDto = new UserDto(changeuserid, addr, password, role);
	int result = db.updateUser(userDto, userid);
	System.out.println("result : " + result);
	if (result > 0) {
	%>
	<script type="text/javascript">
	alert("회원수정 성공");
	location.href = './allUserSearch.jsp?page=<%=pages%>';
    </script>
    <%
} else {
    %>
    <script type="text/javascript">
	alert("회원수정 실패");
	location.href = './allUserSearch.jsp?page=<%=pages%>';
    </script>
    <%
}
} else {
    userDto = db.selectUser(userid);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		UPDATE - USERID :
		<%=userid%></h1>
	<form action="./userUpdate.jsp">
	<input type="hidden" name="userid" value="<%=userid%>">
	<input type="hidden" name="page" value="<%=pages%>">
		ID : <input type="text" name="changeuserid" value="<%=userid%>"><br>
		ADDR : <input type="text" name="addr" value="<%=userDto.getAddr()%>"><br>
		PW : <input type="password" name="password" value="<%=userDto.getPassword()%>"><br>
		ROLE <input type="text" name="role" value="<%=userDto.getRole()%>"><br>
		<button>수정</button><br>
		<a href="javascript:history.go(-1)">이전으로</a>
	</form>
</body>
</html>