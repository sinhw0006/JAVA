<%@page import="C09.DBUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userid = request.getParameter("userid");
    int pages = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
    DBUtils db = DBUtils.getInstance();
    int result = db.deleteUser(userid);
    if (result > 0) {
    	%>
    	<script type="text/javascript">
    	alert("회원삭제 성공");
    	location.href = './allUserSearch.jsp?page=<%=pages%>';
    </script>
    <%
    } else {
    %>
    <script type="text/javascript">
    	alert("회원삭제 실패");
    	location.href = './allUserSearch.jsp?page=<%=pages%>';
    </script>
    <%
    }
    %>