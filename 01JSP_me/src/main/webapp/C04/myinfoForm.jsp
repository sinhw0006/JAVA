<%@page import="C04.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
UserDto userDto = (UserDto) request.getAttribute("userDTO");
String userid = request.getParameter("userid");
if (userid != null && userDto == null) {
	request.getRequestDispatcher("./dbUtils.jsp").forward(request, response);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<header>
			<%@ include file="./Layout/TopHeader.jsp"%>
			<%@ include file="./Layout/Nav.jsp"%>
		</header>
		<main>
			<section>
				<h1>MYINFO</h1>
				<form action="myinfoForm.jsp" method="post">
					<input type="text" name="userid" /><br> <input type="hidden"
						name="url" value="/myinfo" /><br> <input type="submit"
						value="조회" />
				</form>
			</section>

			<%
			if (userDto != null) {
			%>
			<hr>
			USERID : <%=userDto.getUserid()%><hr>
			PASSWORD : <%=userDto.getPassword()%><hr>
			ROLE : <%=userDto.getRole()%><hr>
			<%
			}
			%>

		</main>

		<footer>
			<%@ include file="./Layout/Footer.jsp"%>
		</footer>
	</div>

</body>
</html>