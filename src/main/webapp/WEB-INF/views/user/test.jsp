<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인되지 않은 상태에서만 (익명의 사용자의 경우) -->
	<sec:authorize access="isAnonymous()">
		<a href="/user/login">로그인</a>
	</sec:authorize>
	<a
		href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=4f8fd0ea2b58d54fc209c75db615c0e7&redirect_uri=http://localhost:8181/shard/login/oauth"></a>
	<img
		src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
		alt="카카오 로그인 버튼" />
	<a
		href=https://prd.kr-ccapi.hyundai.com/api/v1/user/oauth2/authorize?client_id=400b3231-30db-42f5-ab52-9d69b35a184d&redirect_uri=http://localhost:8282&response_type=code&state=test>로그인</a>
	<!-- 해당 링크 클릭 시 로그인 인증 요청 API 호출-->

	<sec:authorize access="isAuthenticated()">
		${user.username}님,안녕하세요!
		<form role="form" method="post" action="/user/update" id="updateForm" name="frm">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="userid" name="userid"
						placeholder="아이디" maxlength="20" value="${user.userid }" readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="username" name="username"
						placeholder="이름" value="${user.username }"readonly></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="password" name="password"
						placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="password" id="passwordCheck"
						name="passwordCheck" placeholder="비밀번호확인"></td>
					<td><p id="checkMsg">비밀번호가 일치하지 않습니다.</p></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" id="email" name="email"
						placeholder="이메일" value="${user.email }"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" id="nickname" name="nickname"
						placeholder="닉네임" value="${user.nickname }"></td>
				</tr>
				<tr>
					<td>회원등급</td>
					<td><input type="radio" name="auth" value="${user.authList }"
						checked="checked">${user.authList }</td>
				</tr>
				<tr>
					<td>
						<button type="submit" id="updateBtn">회원정보수정</button>
					</td>
				</tr>

			</table>

		</form>
		</sec:authorize>
</body>

</html>