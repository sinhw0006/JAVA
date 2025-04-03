<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String cookieName = request.getParameter("cookieName");
System.out.println(cookieName);

Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies){
	if(cookie.getName().equals(cookieName)){
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		%>
		<script type="text/javascript">
			alert("쿠키 삭제 완료");
			location.href='./getCookie.jsp'
		</script>
		<%
	}
}
%>