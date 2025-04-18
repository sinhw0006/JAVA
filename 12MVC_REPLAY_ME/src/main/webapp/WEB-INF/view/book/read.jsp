<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- link -->
<%@include file="/resources/layouts/link.jsp"%>

<script type="text/javascript">
	const path = '${pageContext.request.contextPath}';
	const bookCode = '${param.bookCode}';
</script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/book/read.css">
<script
	src="${pageContext.request.contextPath}/resources/js/book/read.js"
	defer></script>
<meta charset="UTF-8">
<title class="${pageContext.request.contextPath}">Insert title
	here</title>
<style type="text/css">
label {
	width: 80px;
	text-align: center;
}
</style>
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
					<label for="">bookCode : </label> <input type="text"
						name="bookCode" placeHolder="bookCode" value="${bookDto.bookCode}"
						readonly /> <input type="hidden" name="page"
						placeHolder="bookCode" value="${param.page}" />
				</div>
				<div>
					<label for="">bookName : </label> <input type="text"
						name="bookName" placeHolder="bookName" value="${bookDto.bookName}" />
				</div>
				<div>
					<label for="">publisher : </label> <input type="text"
						name="publisher" placeHolder="publisher"
						value="${bookDto.publisher}" />
				</div>
				<div>
					<label for="">isbn : </label> <input type="text" name="isbn"
						placeHolder="isbn" value="${bookDto.isbn}" />
				</div>
				<div>
					<button class="btn btn-success">도서수정</button>
				</div>
			</form>

			<!--  -->
			<div class="reply-container">
				<div class="reply-header">
					<div>
						댓글수 : <span class="reply-cnt">00</span>
					</div>
					<hr>
					<div>
						<textarea name="" id="" cols="30" rows="5"></textarea>
						<a class="reply-add-btn btn btn-success" href="javascript:void(0)">입력</a>
					</div>
				</div>
				<div class="reply-body">
					<div class="items">
					</div>
				</div>

			</div>

		</main>
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp"%>
	</div>


</body>
</html>