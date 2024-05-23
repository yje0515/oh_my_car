<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 20px;
	color: #333;
}

h1 {
	color: #1A87C6;
	text-align: center;
	font-size: 36px;
	margin-bottom: 30px;
	text-transform: uppercase;
	letter-spacing: 1.5px;
}

.table-container {
	max-width: 1200px;
	margin: 0 auto;
	overflow-x: auto;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 0;
	border-radius: 8px;
	overflow: hidden;
}

th, td {
	padding: 16px 12px;
	text-align: left;
}

th {
	background-color: #1A87C6;
	color: white;
	text-transform: uppercase;
	font-size: 14px;
	letter-spacing: 1px;
}

td {
	font-size: 14px;
	color: #555;
	background-color: #ffffff;
}

tr:nth-child(even) td {
	background-color: #f2f2f2;
}

tr:hover td {
	background-color: #e1f5fe;
}

.footer {
	background-color: #1A87C6;
	color: white;
	padding: 20px;
	font-size: 14px;
	text-align: center;
	margin-top: 30px;
	border-radius: 8px;
}
</style>
</head>
<body>
	<h1>게시판 목록</h1>
	<table border="1">
		<tr>
			<th>게시물 번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>업데이트일</th>
		</tr>
		<!-- 게시물 목록을 반복하며 테이블에 표시 -->
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bno}</td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td>${board.updatedate}</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
