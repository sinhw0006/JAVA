<%@page import="Utils.DBUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>

<!-- useBean -->
<jsp:useBean id="classDTO" class="Utils.classDTO" scope="request" />
<jsp:setProperty property="*" name="classDTO" />
<%
String class_name = request.getParameter("class_name");

int result = DBUtils.getInstance().classinsert(classDTO, class_name);
if (result > 0) {
%>
<script type="text/javascript">
	alert("수강신청이 정상적으로 완료되었습니다!");
	location.href = '../index.jsp';
</script>
<%
//request.getRequestDispatcher("./read.jsp").forward(request,response);
} else {
%>
<script type="text/javascript">
	alert("수강신청 실패 실패!");
	location.href = './index.jsp';
</script>
<%
}
%>