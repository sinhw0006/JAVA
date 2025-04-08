<%@page import="Utils.DBUtils"%>
<%@page import="Utils.VoteDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>

<!-- useBean -->
<jsp:useBean id="voteDTO" class="Utils.VoteDTO" scope="request" />
<jsp:setProperty property="*" name="voteDTO" />
<%

String m_no = request.getParameter("m_no").substring(1, 2);
voteDTO.setM_no(m_no);
System.out.println(voteDTO);

int result = DBUtils.getInstance().insertVote(voteDTO);
if (result > 0) {
%>
<script type="text/javascript">
	alert("투표하기 정보가 정상적으로 등록 되었습니다!");
</script>
<%
request.getRequestDispatcher("./read.jsp").forward(request,response);
} else {
%>
<script type="text/javascript">
	alert("투표하기 실패!");
	location.href = './index.jsp';
</script>
<%
}
%>