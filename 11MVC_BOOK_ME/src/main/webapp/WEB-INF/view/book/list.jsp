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

table {
	min-width: 900px;
}

td {
	white-space: nowrap;
	text-align: center;
	height: 50px;
	width: 120px;
	max-width: 120px;
	overflow: hidden;
}

.max-td1 {
	width: 400px;
	min-width: 400px;
	max-width: 400px;
}

.max-td2 {
	width: 50px;
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
			<div style="display: flex; justify-content: space-between;">
				<form class="d-flex"
					action="${pageContext.request.contextPath}/book/list">
					<input class="form-controle me-2" type="text" name="page">
					<button class="btn btn-outline-success">페이지 이동</button>
				</form>
				<div>
					<form class="d-flex"
						action="${pageContext.request.contextPath}/book/list">
						<select name="sortBy">
							<option>bookCode</option>
							<option>bookName</option>
							<option>publisher</option>
							<option>isbn</option>
						</select> <select name="orderBy">
							<option>ASC</option>
							<option>DESC</option>
						</select>
						<button class="btn btn-outline-success">정렬</button>
					</form>
				</div>
			</div>
			<%
			int pageCount = (int) request.getAttribute("pageCount");
			int pages = (int)request.getAttribute("page");
			List<BookDto> bookdtos = (List<BookDto>) request.getAttribute("books");
			int i = (pages - 1) * 10;
			%>
			<div
				style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
				<h1>BookList(${page} / ${pageCount})</h1>
				검색 갯수 :
				<%=request.getAttribute("bookCount")%>
				/ 정렬 기준 :
				<%=session.getAttribute("sortBy")%>
				/ 정렬 순서 :
				<%=session.getAttribute("orderBy")%>
				/ 검색 기준 :
				<%=session.getAttribute("type")%>
				/ 검색어 :
				<%=session.getAttribute("input")%>
				<table class="table">
					<thead>
						<tr>
							<td>순번</td>
							<td>도서코드</td>
							<td>도서명</td>
							<td>출판사</td>
							<td colspan="2">ISBN</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<%
						for (BookDto bookdto : bookdtos) {
							i++;
						%>
						<tr>
							<td><%=i%></td>
							<td><%=bookdto.getBookCode()%></td>
							<td class="max-td1"><a
								href="./read?bookCode=<%=bookdto.getBookCode()%>&page=<%=pages%>"><%=bookdto.getBookName()%></a></td>
							<td><%=bookdto.getPublisher()%></td>
							<td colspan="2"><%=bookdto.getIsbn()%></td>
							<td class="max-td2"><a
								href="./delete?bookCode=<%=bookdto.getBookCode()%>&page=<%=pages%>">삭제</a></td>
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
						</tr>
						<%
						}
						i = 0;
						%>
						<td colspan="3" , style="max-width: 50px; text-align: left;">
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
						<td colspan="1"></td>
						<td colspan="3" style="text-align: right;">
						<a class="btn btn-success" href="${pageContext.request.contextPath}/book/create">도서등록</a>
						<a class="btn btn-secondary" href="${pageContext.request.contextPath}/">처음으로</a></td>
					</tbody>
				</table>

			</div>
		</main>


		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp"%>
	</div>


</body>
</html>