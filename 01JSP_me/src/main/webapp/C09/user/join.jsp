<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C09.DBUtils"%>
<%@ page import="C04.UserDto"%>

<%
String userid = request.getParameter("userid");
String password = request.getParameter("password");
String role = "ROLE_USER";

//입력값 검증

//서비스 실행
DBUtils db = DBUtils.getInstance();
int result = db.insertUser(new UserDto(userid,password,role));

if(result>0){
%>
<script type="text/javascript">
alert("회원가입 성공");
location.href='./allUserSearch.jsp';
</script>
<%	
} else{
	%>
	<script type="text/javascript">
	alert("회원가입 실패");
	location.href='./join_form.jsp';
	</script>
	<%
}
%>