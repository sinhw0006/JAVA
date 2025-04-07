<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
nav{
background-color: lightgray;
}
ul {
	display: flex;
	justify-content: left;
	align-content: center;
}
li {
	height: 50px;
	padding: 5px 20px;
}
a{
text-align: center;
width: 100%;
height: 50px;
line-height: 40px;
}
</style>
<nav>
	<ul>
		<li><a href="${pageContext.request.contextPath}/01">후보조회</a></li>
		<li><a href="${pageContext.request.contextPath}/02">투표하기</a></li>
		<li><a href="${pageContext.request.contextPath}/03">투표검수조회</a></li>
		<li><a href="${pageContext.request.contextPath}/04">후보자등수</a></li>
		<li><a href="${pageContext.request.contextPath}/">홈으로</a></li>
	</ul>
</nav>