<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
:root {
	
}
*{box-sizing: border-box; padding: 10px; border: 1px solid;}
a{}
ul{}
body {padding: 0; margin: 0;}
.wrapper{}
.wrapper>header{min-height: 100px;}
.wrapper>header>.top-header{min-height: 25px;}
.wrapper>header>nav{min-height: 75px;}
.wrapper>main{min-height: 1000px;}
.wrapper>main>section{}
.wrapper>footer{min-height: 250px;}

</style>

</head>
<body>
	<div class="wrapper">
		<header>
		<%@include file="./Layout/TopHeader.jsp" %>
		<%@include file="./Layout/Nav.jsp" %>
		</header>
		<main>
			<section>MAIN>SECTION 영역</section>
		</main>
		<%@include file="./Layout/Footer.jsp" %>
	</div>
</body>
</html>