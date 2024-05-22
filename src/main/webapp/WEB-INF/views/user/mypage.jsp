<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MYPAGE</h1>
	<p>${userVO.userName }님</p>
	<a href="/user/passwordCheck">내 정보 수정</a>
	<a href="${pageContext.request.contextPath}/user/register">차량 등록</a>
	<!-- 차량 등록 링크 추가 -->
	<!-- 차량 정보 수정 페이지로 이동하는 링크 추가 -->
	<a href="${pageContext.request.contextPath}/user/carUpdate">차량 정보
		수정</a>
	<c:if test="${result eq 'success'}">
		<script>
			alert("회원정보가 성공적으로 수정되었습니다.");
		</script>

	</c:if>
	<!-- 회원탈퇴 폼 추가 -->
	<form id="userDeleteForm" method="post"
		action="${pageContext.request.contextPath}/user/userDelete">
		<button type="submit">회원탈퇴</button>
	</form>
	<!-- 게시판으로 이동하는 버튼 추가 (GET 요청) -->
	<button
		onclick="location.href='${pageContext.request.contextPath}/board'">게시글 작성하기
		</button>

	
</body>
</html>