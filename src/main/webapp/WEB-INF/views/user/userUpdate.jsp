<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script src="../../resources/js/user/update.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="../../resources/css/user.css">
<title>내 정보 수정</title>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>

	<div id="userUpdateWrap">
		<h1>내 정보 수정</h1>
		<form role="form" method="post" action="/user/userUpdate"
			id="updateForm" name="frm">
			<table>
				<tr>
					<td>아이디</td>
					<td><input class="updateInput ro" type="text" id="userId"
						name="userId" placeholder="아이디" maxlength="20"
						value="${userVO.userId }" readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input class="updateInput ro" type="text" id="userName"
						name="userName" placeholder="이름" value="${userVO.userName }"
						readonly></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input class="updateInput" type="password" id="password"
						name="password" placeholder="비밀번호" autofocus></td>
				</tr>
				<tr>
					<td colspan="3" class="updateRules" id="passwordRule">8~20자의
						영문 대/소문자, 숫자, 특수문자를 모두 사용해 주세요</td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input class="updateInput" type="password"
						id="passwordCheck" name="passwordCheck" placeholder="비밀번호확인"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input class="updateInput ro" type="text" id="email"
						name="email" placeholder="이메일" value="${userVO.email }" readonly></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input class="updateInput" type="text" id="nickName"
						name="nickName" placeholder="닉네임" value="${userVO.nickName }"></td>
				</tr>
				<tr>
					<td>회원등급</td>
					<td><c:forEach var="auth" items="${userVO.authList }">
							<c:if test="${auth.auth eq 'ROLE_ADMIN' }">
								<c:set var="isAdmin" value="true" />
							</c:if>

						</c:forEach> <c:if test="${isAdmin }">
							관리자
						</c:if> <c:if test="${not isAdmin }">
							일반회원
						</c:if>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" id="updateBtn" value="수정"></td>
				</tr>

			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<div class="checked">
			<input type="hidden" class="ruleChecked" id="passwordRuleChecked"
				name="passwordRuleChecked" value="notYet">
		</div>
	</div>

	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<script>
		if(${passwordChecked != 'ok'}){
			history.back();
			alert("비밀번호 확인 후 접근가능합니다.");
		}
	</script>
</body>
</html>