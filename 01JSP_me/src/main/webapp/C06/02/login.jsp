<%@page import="java.lang.reflect.AccessFlag.Location"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.removeAttribute("username");
String username = request.getParameter("username") == null ? "" : request.getParameter("username");
String password = request.getParameter("password") == null ? "" : request.getParameter("password");

// 유효성 체크
if(username.isEmpty()){
	request.setAttribute("error_id", "username을 입력하세요");
}
if(password.isEmpty()){
	request.setAttribute("error_pw", "password를 입력하세요");
}
if(username.isEmpty() || password.isEmpty()){
	request.getRequestDispatcher("./login_form.jsp").forward(request, response);
	return;
}
// 1. ID 확인
// 2. PW 확인
// 3. 사용자 상태정보 저장
session.setAttribute("isAuth", true);
session.setAttribute("role", "ROLE_ADMIN");
session.setMaxInactiveInterval(30);
%>
<script type="text/javascript">
alert("로그인 성공!");
location.href = './main.jsp';
</script>