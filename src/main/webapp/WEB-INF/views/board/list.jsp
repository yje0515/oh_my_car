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
