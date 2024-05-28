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
<link rel="stylesheet" type="text/css" href="css/list.css">
<style>
/* 기본 스타일 정의 */
body {
    font-family: 'Segoe UI', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
}

h1 {
    color: #002F65;
    text-align: center;
    font-size: 36px;
    margin: 20px 0;
    font-weight: 700;
    letter-spacing: 1px;
}

.table-container {
    width: 80%;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
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
    background-color: #002F65;
    color: #fff;
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
}

button:hover {
    background-color: #004494;
    transform: scale(1.02);
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
				<td>${board.updateDate}</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
