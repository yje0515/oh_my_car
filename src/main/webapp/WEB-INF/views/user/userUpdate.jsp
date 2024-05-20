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
	<form role="form" method="post" action="/user/userUpdate"
		id="updateForm" name="frm">
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
				<td colspan="3" class="updateRules" id="passwordRule">8~20자의 영문
					대/소문자, 숫자, 특수문자를 모두 사용해 주세요</td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" id="passwordCheck"
					name="passwordCheck" placeholder="비밀번호확인"></td>
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
							<c:set var="isAdmin" value="true" />
						</c:if>

					</c:forEach> <c:if test="${isAdmin }">
							관리자
						</c:if> <c:if test="${not isAdmin }">
							일반회원
						</c:if>
			</tr>
			<tr>
				<td><input type="submit" id="updateBtn" value="수정"></td>
			</tr>

		</table>

	</form>
	<div class="checked">
		<input type="hidden" class="ruleChecked" id="passwordRuleChecked"
			name="passwordRuleChecked" value="notYet">
	</div>
	<script>
		$(document)
				.ready(
						function() {
							//입력양식 초기화
							$(".updateRules").hide();
							$(".updateRules").css({
								'color' : 'red',
								'font-size' : '12px'
							});
							$('#updateBtn').on('click', updateCheck);//확인후 submit

							$('#password')
									.focusout(
											function() {
												//8~24자 영문대문자,소문자,숫자,특수문자 혼합사용
												var passwordRule = RegExp(/^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{8,20}$/);
												if (!passwordRule.test($(
														"#password").val())) {
													$("#passwordRule").show();
													$("#passwordRuleChecked")
															.val("notYet");
													return false;
												} else {
													$("#passwordRule").hide();
													$("#passwordRuleChecked")
															.val("ok");
												}
											})

							//비밀번호 일치 여부확인
							$('#password').focusout(pwdCheck);
							$('#passwordCheck').focusout(pwdCheck);
							$('#passwordCheck')
									.css('border', '1px solid black');
							$('#passwordCheck')
									.css('background-color', 'white');
							function pwdCheck() {
								if ($('#passwordCheck').val() == "") {
									$('#checkMsg2').show();
									return false;
								}
								if ($('#password').val() !== $('#passwordCheck')
										.val()) {
									$('#passwordCheck').css('border',
											'1px solid red');
									$('#passwordCheck').css('background-color',
											'red');
									return false;
								} else {
									$('#passwordCheck').css('border',
											'1px solid black');
									$('#passwordCheck').css('background-color',
											'lightgreen');
									return true;
								}
							}

							//빈칸/중복/비밀번호일치 확인 후 submit
							function updateCheck() {
								if ($('#password').val() == "") {
									alert("비밀번호를 입력 해 주세요.");
									$('#password').focus();
									return false;
								}
								if ($('#password').val() !== $('#passwordCheck')
										.val()) {
									alert("비밀번호가 일치하지 않습니다.");
									return false;
								}

								return true;
							}

						});
	</script>
</body>
</html>