<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="top-header layout  bg-success text-light">

	<ul class="user-block">
		<%
		Boolean isAuth = session.getAttribute("isAuth") != null ? (Boolean) session.getAttribute("isAuth") : false;
		if (!isAuth) {
		%>
		<li><a href="${pageContext.request.contextPath}/user/login">
				<span class="material-symbols-outlined">login</span>
		</a></li>
		<%
		} else {
		%>
		<li><span class="material-symbols-outlined">Person</span> <span>${username}</span>
		</li>
		<li><a href="${pageContext.request.contextPath}/user/logout">
				<span class="material-symbols-outlined">logout</span>
		</a></li>
		<%
		}
		%>

	</ul>


</div>