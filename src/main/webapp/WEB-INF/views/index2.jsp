<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>

<div>
	<h1>index2</h1>

	<div>
		<form method="get">
			<label> 검색 <input type="text"></label> <input type="submit">
		</form>
	</div>
	<br />

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boards }">
				<tr>
					<td>${board.id }</td>
					<td><a href="/post/${board.id }"> ${board.title } </a></td>
					<td>${board.user.userName }</td>
					<td>${board.createdAt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:forEach var="page" begin="1" end="${totalPage }">
		<a href="/index2?page=${page }">
			<button>${page }</button>
		</a>
	</c:forEach>

</div>
<%@ include file="./layout/footer.jsp"%>
