<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>1:1 문의하기</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
    <h2>1:1 문의하기</h2>
    <form action="/board/write" method="post">			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
        <label for="title">제목:</label> <input type="text" id="title"
            name="title"> <br> <label for="content">문의 내용:</label>
        <textarea id="content" name="content"></textarea>
        <br> <label for="writer">작성자:</label> <input type="text"
            id="writer" name="writer"> <br>
        <button type="submit">제출</button>
    </form>
    <jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
