<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="./Error.jsp"%>

<%@ page import="C04.UserDto"%>

<%
//request로부터 전달받은 파라미터 꺼내서 System.out 확인
//받은 username,password 값이 null인지여부를 체크(String API trim()  + isEmpty() 이용)

UserDto userDTO = (UserDto)request.getAttribute("userDTO");

System.out.println("UserID : "+userDTO.getUserid());
System.out.println("Password : "+userDTO.getPassword());
System.out.println("ROLE : "+userDTO.getRole());
if(userDTO.getUserid().trim().isEmpty()){
	throw new Exception("아이디를 입력하세요");
}
if(userDTO.getPassword().trim().isEmpty()){
	throw new Exception("비밀번호를 입력하세요");
}
request.setAttribute("url", "/join"); // DB 요청 처리
request.setAttribute("serviceNo", 1); // ServiceNo C-1 R-2 U-3 D-4
request.getRequestDispatcher("./dbUtils.jsp").forward(request, response);
%>