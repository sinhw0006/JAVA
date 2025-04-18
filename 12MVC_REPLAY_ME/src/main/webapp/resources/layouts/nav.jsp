<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="layout navbar navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand">Navbar</a>
		<form class="d-flex"
			action="${pageContext.request.contextPath}/book/list">
			<select name="type">
				<option>bookCode</option>
				<option>bookName</option>
				<option>publisher</option>
				<option>isbn</option>
			</select>
			<input class="form-control me-2" type="search" placeholder="Search"
				name="input" aria-label="Search">
			<button class="btn btn-outline-success" type="submit">Search</button>
		</form>
	</div>
</nav>