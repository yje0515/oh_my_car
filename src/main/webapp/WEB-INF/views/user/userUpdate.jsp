<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>내 정보 수정</h1>
	<form role="form" id="updateForm" name="frm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userId" name="userId"
					placeholder="아이디" maxlength="20" value="${userVO.userId }" readonly></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="userName" name="userName"
					placeholder="이름" value="${userVO.userName }" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password" name="password"
					placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="passwordCheck"
					name="passwordCheck" placeholder="비밀번호 확인"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="email" name="email"
					placeholder="이메일" value="${userVO.email }"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" id="nickName" name="nickName"
					placeholder="닉네임" value="${userVO.nickName }"></td>
			</tr>
			<tr>
				<td>회원등급</td>
				<td><c:forEach var="auth" items="${userVO.authList }">
						<c:if test="${auth.auth eq 'ROLE_ADMIN' }">
                            관리자
                        </c:if>
						<c:if test="${auth.auth eq 'ROLE_MEMBER' }">
                            일반회원
                        </c:if>
					</c:forEach></td>
			</tr>
			<tr>
				<td><button type="button" id="updateBtn">수정</button></td>
			</tr>
		</table>
	</form>
	<script>
		$(document)
				.ready(
						function() {
							$('#updateBtn').on(
									'click',
									function() {
										var password = $('#password').val();
										var confirmPassword = $(
												'#passwordCheck').val();
										if (password === confirmPassword) {
											updateUser();
										} else {
											alert("비밀번호가 일치하지 않습니다.");
										}
									});

							function updateUser() {
								$
										.ajax({
											type : "POST",
											url : "${pageContext.request.contextPath}/user/userUpdate",
											data : $("#updateForm").serialize(),
											success : function(response) {
												alert("사용자 정보가 업데이트되었습니다.");
												// 업데이트 성공 후 페이지를 다시 로드하여 변경된 정보를 반영
												location.href = "${pageContext.request.contextPath}/user/mypage"; // 수정 후 마이페이지로 이동
											},
											error : function(xhr, status, error) {
												alert("사용자 정보 업데이트 중 오류가 발생했습니다.");
												console.error(error);
												// 업데이트 실패 시 필요한 작업 수행
											}
										});
							}
						});
	</script>

</body>
</html>
