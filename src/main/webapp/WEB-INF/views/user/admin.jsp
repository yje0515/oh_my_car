<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#adminWrap{
		width:1000px;
		height:1000px;
		background-color:lightgray;
	}
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>

	<div id="adminWrap">
		<h1>ADMIN</h1>
		<p>${userVO.userName }님</p>

		자동차간단상식 CRUD
	</div>

	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>