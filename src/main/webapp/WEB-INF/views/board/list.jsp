<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" type="text/css" href="/css/list.css">
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 900px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #002F65;
	font-size: 24px;
	font-weight: 700;
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 12px 15px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f8f8f8;
	color: #333;
	font-weight: bold;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr:hover {
	background-color: #f1f1f1;
}

td {
	color: #333;
}

.action-buttons a {
	text-decoration: none;
	color: white;
	margin: 0 5px;
	padding: 5px 10px;
	background-color: #0056b3;
	border-radius: 3px;
}

.action-buttons a:hover {
	background-color: #004494;
}

button {
	background-color: #0056b3;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	font-weight: 700;
	text-transform: uppercase;
	transition: background-color 0.3s ease, transform 0.2s ease;
	outline: none;
	margin-top: 20px;
	display: block;
	width: 150px;
	text-align: center;
	margin: 20px auto 0;
}

button:hover {
	background-color: #004494;
	transform: scale(1.02);
}
</style>
</head>
<body>
	<div class="table-container">
		<h1>게시판 목록</h1>
		<table>
			<tr>
				<th>게시물 번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>업데이트일</th>
				<th>액션</th>
			</tr>
			<!-- 게시물 목록을 반복하며 테이블에 표시 -->
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.bno}</td>
					<td>${board.title}</td>
					<td>${board.content}</td>
					<td>${board.writer}</td>
					<td>${board.regdate}</td>
					<td>${board.updateDate}</td>
					<td class="action-buttons"><a
						href="${pageContext.request.contextPath}/board/modify?bno=${board.bno}">수정</a>
						<a
						href="${pageContext.request.contextPath}/board/delete?bno=${board.bno}">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/board/write'">글쓰기</button>
	</div>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
