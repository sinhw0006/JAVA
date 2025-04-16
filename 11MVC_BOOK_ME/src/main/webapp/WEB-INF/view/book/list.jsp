<%@page import="Domain.Dto.BookDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- link -->
<%@include file="/resources/layouts/link.jsp"%>

<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.pages {
	color: red;
}

td {
	
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
			BookCount :
			<%=request.getAttribute("bookCount")%> / <%=session.getAttribute("orderBy") %> / <%=session.getAttribute("sortBy") %> / <%=session.getAttribute("input") %>
			
			<div
				style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
				<h1>BookList</h1>
				<table class="table">
					<thead>
						<tr>
							<td>순번</td>
							<td>도서코드</td>
							<td>도서명</td>
							<td>출판사</td>
							<td colspan="2">ISBN</td>
							<td></td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<%
						int pageCount = (int) request.getAttribute("pageCount");
						int pages = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
						List<BookDto> bookdtos = (List<BookDto>) request.getAttribute("books");
						int i = (pages - 1) * 10;
						for (BookDto bookdto : bookdtos) {
							i++;
						%>
						<tr>
							<td><%=i%></td>
							<td><%=bookdto.getBookCode()%></td>
							<td><%=bookdto.getBookName()%></td>
							<td><%=bookdto.getPublisher()%></td>
							<td colspan="2"><%=bookdto.getIsbn()%></td>
							<td><a href="./book/read?userid=<%=bookdto.getBookCode()%>">수정</a></td>
							<td><a
								href="./book/delete?userid=<%=bookdto.getBookCode()%>">삭제</a></td>
						</tr>
						<%
						}
						while (i % 10 != 0) {
						i++;
						%>
						<tr>
							<td><%=i%></td>
							<td>-</td>
							<td>-</td>
							<td>-</td>
							<td colspan="2">-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<%
						}
						i = 0;
						%>
						<td colspan="3" , style="max-width: 50px">
							<%
							if (pages != 1) {
							%> <a href="?page=<%=pages - 1%>">◀</a> <%
 } else {
 %><a href="javascript:void(0)">●</a> <%
 }
 %> <%
 int minpage = pageCount > 5 ? pageCount - pages <= 1 ? pageCount - 5 : (pages - 3 <= 0 ? 0 : pages - 3) : 0;
 int maxpage = (pages - 3 <= 0 ? 0 : pages - 3) + 5 > pageCount ? pageCount : (pages - 3 <= 0 ? 0 : pages - 3) + 5;
 for (int c = minpage; c < maxpage; c++) {
 	String number = "";
 	if (c + 1 < 10) {
 		number = "000" + (c + 1);
 	} else if (c + 1 < 100) {
 		number = "00" + (c + 1);
 	} else if (c + 1 < 1000) {
 		number = "0" + (c + 1);
 	} else {
 		number = "" + (c + 1);
 	}
 	if ((c + 1) == pages) {
 %> <a class="pages" href="?page=<%=number%>"><%=number%></a> <%
 } else {
 %> <a href="?page=<%=number%>"><%=number%></a> <%
 }
 }
 %> <%
 if (pages != pageCount) {
 %> <a href="?page=<%=pages + 1%>">▶</a> <%
 } else {
 %><a href="javascript:void(0)">●</a> <%
 }
 %>
						</td>
						<td colspan="2"></td>
						<td colspan="3" style="text-align: right;"><a
							href="${pageContext.request.contextPath}/book/create">도서등록</a> <a
							href="${pageContext.request.contextPath}/">처음으로</a></td>
					</tbody>
				</table>

			</div>

			<form action="${pageContext.request.contextPath}/book/list">
				<input type="text" name="page">
				<button>페이지 이동</button>
			</form>
			<form action="${pageContext.request.contextPath}/book/list">
				<select name = "orderBy">
				<option>ASC</option>
				<option>DESC</option>
				</select>
				<select name = "sortBy">
				<option>bookCode</option>
				<option>bookName</option>
				<option>publisher</option>
				<option>isbn</option>
				</select>
				<input type="text" name="input">
				<button>검색</button>
			</form>
		</main>


		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp"%>
	</div>


</body>
</html>