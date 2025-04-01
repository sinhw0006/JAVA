<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
	<header>
		<nav>
		<ul style="${param.style}">
		<%
		if(!request.getParameter("col1").equals("")){
			%><li><a href="javascript:void(0)">${param.col1}</a></li>
			<%
		}
		%>
		<%
		if(!request.getParameter("col2").equals("")){
			%><li><a href="javascript:void(0)">${param.col2}</a></li>
			<%
		}
		%>
		<%
		if(!request.getParameter("col3").equals("")){
			%><li><a href="javascript:void(0)">${param.col3}</a></li>
			<%
		}
		%>
		<%
		if(!request.getParameter("col4").equals("")){
			%><li><a href="javascript:void(0)">${param.col4}</a></li>
			<%
		}
		%>
		</ul>
		
		</nav>
	</header>
	<main>
		<section></section>
	</main>
	<footer></footer>
</div>
</body>
</html>