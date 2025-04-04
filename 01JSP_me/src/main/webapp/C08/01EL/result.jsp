<%@page import="C04.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
pageContext.setAttribute("P_ATTR", "P_ATTR_VALUE");
request.setAttribute("R_ATTR", "R_ATTR_VALUE");
session.setAttribute("S_ATTR", "S_ATTR_VALUE");
application.setAttribute("A_ATTR", "A_ATTR_VALUE");

pageContext.setAttribute("DUP", "PAGE_VALUE");
request.setAttribute("DUP", "REQUEST_VALUE");
session.setAttribute("DUP", "SESSION_VALUE");
application.setAttribute("DUP", "APPLICATION_VALUE");

UserDto userDto = new UserDto("user1", "1234", "ROLE_USER");
request.setAttribute("userDto", userDto);
%>
<!-- EL  : PARAM -->
USERNAME : ${param.username}<br>
PASSWORD : ${param.password}<hr>

<!-- EL  : ATTRIBUTE -->
PAGE_CONTEXT ATTR : ${P_ATTR}<br>
PAGE_CONTEXT ATTR : ${pageScope.P_ATTR}<br>
REQUEST ATTR : ${R_ATTR}<br>
REQUEST ATTR : ${requestScope.R_ATTR}<br>
SESSION ATTR : ${S_ATTR}<br>
SESSION ATTR : ${sessionScope.S_ATTR}<br>
APPLICATION ATTR : ${A_ATTR}<br>
APPLICATION ATTR : ${applicationScope.A_ATTR}<hr>

<!-- EL  : ATTRIBUTE(중복값) -->
DUPLICATION VALUE : ${DUP}<br><hr>

<!-- EL  : OBJECT -->
표현식 : <%=userDto.getUserid()%><br>
EL : ${userDto.userid}<hr>

<!-- EL  : 연산자 -->
표현식 : <%=1 + 1%> / <%=1+"1" %><br>
EL : ${1+1} / ${1+'1'}<hr>

<!-- NULL CHECK -->
NULL : ${null}<br>
empty NULL : ${empty null}<br>
empty not NULL : ${!empty null}
