<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../resources/css/user.css">
<script src="../../resources/js/user/join.js" type="text/javascript"></script>
<title>회원가입</title>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div id="joinWrap">
		<h1>회원가입</h1>
		<p>*표시된 항목은 필수입력항목입니다.</p>
		<form role="form" method="post" action="/user/join" id="joinForm"
			name="frm">

			<table>
				<tr>
					<td>아이디*</td>
					<td><input class="joinInput" type="text" id="userId"
						name="userId" placeholder="아이디" maxlength="20" autofocus></td>
					<td><input class="joinDupBtn" type="button" id="idDupBtn"
						value="중복확인"></td>
				</tr>
				<tr>
					<td colspan="3" class="joinRules" id="userIdRule">5~20자의 영문
						소문자, 숫자, 특수기호(_)만 사용 가능합니다.</td>
				</tr>
				<tr>
					<td>이름*</td>
					<td><input class="joinInput" type="text" id="userName"
						name="userName" placeholder="이름"></td>
				</tr>
				<tr>
					<td colspan="3" class="joinRules" id="userNameRule">한글만 입력
						가능합니다.</td>
				</tr>
				<tr>
					<td>비밀번호*</td>
					<td><input class="joinInput" type="password" id="password"
						name="password" maxlength="20" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td colspan="3" class="joinRules" id="passwordRule">8~20자의 영문
						대/소문자, 숫자, 특수문자를 모두 사용해 주세요</td>
				</tr>
				<tr>
					<td>비밀번호확인*</td>
					<td><input class="joinInput" type="password"
						id="passwordCheck" maxlength="20" name="passwordCheck"
						placeholder="비밀번호확인"></td>

				</tr>
				<tr>
					<td>이메일*</td>
					<td><input class="joinInput" type="text" id="email"
						name="email" placeholder="이메일"></td>
					<td><input class="joinDupBtn" type="button" id="emailDupBtn"
						value="중복확인"></td>
				</tr>
				<tr>
					<td colspan="3" class="joinRules" id="emailRule">이메일 주소가 정확한지
						확인해 주세요.</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input class="joinInput" type="text" id="nickName"
						name="nickName" placeholder="[선택]닉네임"></td>
				</tr>
				<tr>
					<td>회원등급*</td>
					<td style="text-align: center;"><input type="radio"
						name="auth" value="ROLE_MEMBER" checked="checked">일반회원 <input
						type="radio" name="auth" value="ROLE_ADMIN">관리자</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" id="joinBtn" value="회원가입"></td>
				</tr>

			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
		<div class="checked">
			<input type="hidden" id="idChecked" name="idChecked" value="notYet">
			<input type="hidden" id="emailChecked" name="emailChecked"
				value="notYet"> <input type="hidden" class="ruleChecked"
				id="userIdRuleChecked" name="userIdRuleChecked" value="notYet">
			<input type="hidden" class="ruleChecked" id="userNameRuleChecked"
				name="userNameRuleChecked" value="notYet"> <input
				type="hidden" class="ruleChecked" id="passwordRuleChecked"
				name="passwordRuleChecked" value="notYet"> <input
				type="hidden" class="ruleChecked" id="emailRuleChecked"
				name="emailRuleChecked" value="notYet">
		</div>
	</div>
	<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>
</html>