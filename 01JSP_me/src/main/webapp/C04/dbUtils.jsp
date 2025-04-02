<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="C04.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="./Error.jsp"%>

<!-- 속성/기능추가 -->
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

	private int insert(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		int result = pstmt.executeUpdate();

		conn.commit();

		pstmt.close();

		return result;
	}
	private UserDto select(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_user where userid = ?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		if(!rs.isBeforeFirst()){
			throw new Exception("존재하지 않는 유저 입니다.");
		}
		rs.next();
		UserDto userDto = new UserDto(rs.getString("userid"),rs.getString("password"),rs.getString("role"));
		rs.close();
		pstmt.close();

		return userDto;
	}
	%>
	
<!-- Service 함수 -->
<%
String url = (String)request.getAttribute("url") == null ? request.getParameter("url"):(String)request.getAttribute("url");
getConnection();
UserDto userDTO = (UserDto) request.getAttribute("userDTO");
if (url.equals("/join")) {
	if (insert(userDTO) > 0) {
		response.sendRedirect("./loginForm.jsp");
		return;
	}
}
if (url.equals("/myinfo")) {
	String userid = request.getParameter("userid");
	if(userid.trim().isEmpty())
		throw new Exception("아이디를 입력해주세요");
	UserDto userDto2 = select(userid);
	if(!userDto2.getUserid().equals(null) || !userDto2.getUserid().equals("")){
		request.setAttribute("userDTO", userDto2);
		request.getRequestDispatcher("./myinfoForm.jsp").forward(request, response);
	};
}
%>

