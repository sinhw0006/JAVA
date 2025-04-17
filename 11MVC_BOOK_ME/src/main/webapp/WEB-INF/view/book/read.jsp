<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- link -->
<%@include file="/resources/layouts/link.jsp"%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp"%>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp"%>
		</header>
		<main class="layout">
			<h1>/Book/READ</h1>

			<form action="${pageContext.request.contextPath}/book/update"
				method="post">
				<div>
					<label for="">bookCode : </label> <span>${bookDto.bookCode}</span><br />
					<input type="hidden" name="bookCode" placeHolder="bookCode" value="${bookDto.bookCode}" />
					<input type="hidden" name="page" placeHolder="bookCode" value="${param.page}" />
				</div>
				<div>
					<label for="">bookName</label>
					<input type="text" name="bookName" placeHolder="bookName" value="${bookDto.bookName}" />
				</div>
				<div>
					<label for="">publisher</label>
					<input type="text" name="publisher" placeHolder="publisher" value="${bookDto.publisher}" />
				</div>
				<div>
					<label for="">isbn : </label>
					<input type="text" name="isbn" placeHolder="isbn" value="${bookDto.isbn}" />
				</div>
				<div>
					<button>도서수정</button>
				</div>
			</form>
		</main>
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp"%>
	</div>


</body>
</html>