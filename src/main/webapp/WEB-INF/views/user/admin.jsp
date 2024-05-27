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
							<td><input class="carFactText" type="text"
								name="carFactText" value="${carFact.factText }"></td>
						</tr>
					</c:forEach>
				</table>
				<!--  input 자리 -->
			</div>

			<button type="button" id="registerBtn">새로 추가</button>
			<!-- 새로추가 누르면 input박스 생기고 저장 버튼만 보이게 , 해당 부분만 submit(checked) 다른건 readonly?
			저장버튼 누르면 자동새로고침?-->
			<button type="button" id="registerSubmitBtn" style="display: none">저장</button>


			<button type="button" id="modifyBtn">선택한 항목 수정</button>
			<!-- 선택한 항목 수정 누르면 선택항목 reaaonly false되고 수정완료 버튼만 보이게-->
			<button type="button" id="modifySubmitBtn" style="display: none">수정완료</button>

			<!-- confirm으로 취소가능하게 -->
			<button type="button" id="deleteBtn">선택한 항목 삭제</button>
		</form>
	</div>

	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<script>
	/* ajax로 crud */
		$(document).ready(function() {
			$("#registerBtn").on('click', function() {
				/* input 생기게, 저장버튼 보이게*/
			})
			$("#registerSubmitBtn").on('click', function() {
				/* 해당(checked? readonly=false?)form만 전송  register submit */
			})
			
			$("#modifyBtn").on('click', function() {
				/* readyonly=false? 수정완료 버튼 보이게 */
			})
			$("#modifySubmitBtn").on('click', function() {
				/* 해당 form만 update 전송 modify submit */
			})
			$("#deleteBtn").on('click', function() {
				var deleteConfirm = confirm("정말 삭제하시겠습니까?");
				if(deleteConfirm){
					
					/* ajax 해당(checked) 항목 List로 보내서 userController에서 삭제 */
					
					return true;
				}
				return false;
			})
		});
	</script>
</body>
</html>