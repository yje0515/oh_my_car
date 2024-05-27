<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간단 차량 상식 편집페이지 -관리자</title>

<style>

/* 관리자페이지 */
#adminWrap {
	width: 1000px;
	height: 1200px;
	background-color: lightyellow;
}

#adminWrap h1 {
	padding: 30px 0 0px 15px;
	font-size: 40px;
}

#carFactsBox {
	width: 100%;
	height: 1000px;
	overflow: scroll;
	overflow-x: hidden;
	border: 1px solid gray;
	margin: 50px 0 0 0;
}

.carFactText {
	width: 900px;
}

#carFactsBox table {
	border-collapse: collapse;
}

#carFactsBox td {
	border: 1px solid lightgray;
}
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>

	<div id="adminWrap">
		<h1>간단 차량 상식 편집 -관리자 [ ${userVO.userName }님 ]</h1>
		<form>
			<div id="carFactsBox">

				<table>
					<c:forEach var="carFact" items="${AllCarFacts}">
						<tr>
							<td><input type="checkbox" name="carFactId"
								value="${carFact.factId}"></td>
							<td>${carFact.factId }</td>
							<td><input class="carFactText" type="text" name="carFactText"
								value="${carFact.factText }"></td>
						</tr>
					</c:forEach>
				</table>

			</div>

			<button type="button" id="adminDeleteBtn">선택한 항목 삭제</button>
		</form>
	</div>

	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function() {

		});
	</script>
</body>
</html>