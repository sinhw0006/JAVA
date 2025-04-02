<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="C04.UserDto" %>
<!--  
		UserDto객체에 전달받은 파라미터(username,password)를 저장
		request에  setAttribute로 userDto 저장("userDto",userDto);
		02ValidationCheck.jsp 로 forwarding
-->
<%
String userid = request.getParameter("userid");
String password = request.getParameter("password");
UserDto userDTO = new UserDto(userid,password,"ROLE_USER");
request.setAttribute("userDTO", userDTO);
request.getRequestDispatcher("./validationCheck.jsp").forward(request, response);
%>