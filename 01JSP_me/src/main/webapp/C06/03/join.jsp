<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void getConnection() throws Exception {
		if (conn == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
		}
	}

	private boolean usernameCheck(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_user where userid = ?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		Boolean isCh = rs.isBeforeFirst();
		rs.close();
		pstmt.close();
		return isCh;
	}

	private boolean userJoin(String username, String password) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,'ROLE_USER')");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		Boolean isCh = pstmt.executeUpdate() > 0;
		rs.close();
		pstmt.close();
		return isCh;
	}%>
<%
getConnection();

String username = request.getParameter("username") == null ? "" : request.getParameter("username");
String password = request.getParameter("password") == null ? "" : request.getParameter("password");

if (username.isEmpty()) {
	request.setAttribute("errorName", "아이디를 입력해주세요");
}
if (password.isEmpty()) {
	request.setAttribute("errorPW", "비밀번호를 입력해주세요");
}

if (username.isEmpty() || password.isEmpty()) {
	request.getRequestDispatcher("./join_form.jsp").forward(request, response);
	return;
}

if (usernameCheck(username)) {
	request.setAttribute("message", "기존 계정이 존재합니다.");
	request.getRequestDispatcher("./join_form.jsp").forward(request, response);
	return;
}
if (userJoin(username, password)) {
%>
<script type="text/javascript">
	alert("회원가입 성공!");
	location.href = './login.jsp';
</script>
<%
}
%>
