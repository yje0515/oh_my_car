<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<!-- <script src="/resources/js/user/userCheck.js" type="text/javascript"></script> -->
</head>
<body>
	<div class="join">
		<h1>회원가입</h1>
		<p>*표시된 항목은 필수입력항목입니다.</p>
		<form role="form" method="post" action="/user/join" id="joinForm"
			name="frm">

			<table>
				<tr>
					<td>아이디*</td>
					<td><input type="text" id="userId" name="userId"
						placeholder="아이디" maxlength="20" autofocus></td>
					<td><input type="button" id="idDupBtn" value="중복확인"></td>
				</tr>
				<tr>
					<td>이름*</td>
					<td><input type="text" id="userName" name="userName"
						placeholder="이름"></td>
				</tr>
				<tr>
					<td>비밀번호*</td>
					<td><input type="password" id="password" name="password"
						placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td>비밀번호확인*</td>
					<td><input type="password" id="passwordCheck"
						name="passwordCheck" placeholder="비밀번호확인"></td>

				</tr>
				<tr>
					<td>이메일*</td>
					<td><input type="text" id="email" name="email"
						placeholder="이메일"></td>
					<td><input type="button" id="emailDupBtn" value="중복확인"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" id="nickName" name="nickName"
						placeholder="[선택]닉네임"></td>
				</tr>
				<tr>
					<td>회원등급*</td>
					<td><input type="radio" name="auth" value="ROLE_MEMBER"
						checked="checked">일반회원 <input type="radio" name="auth"
						value="ROLE_ADMIN">관리자</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="joinBtn" value="회원가입">
					</td>
				</tr>

			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="hidden" id="idChecked"
				name="idChecked" value="notYet"> <input type="hidden"
				id="emailChecked" name="emailChecked" value="notYet">
		</form>

	</div>
	<div>
		<ul>
			<li>아이디 </li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<script>
		$(document).ready(function() {
			//중복확인
			$('#idDupBtn').on('click', idDupCheck)
			$('#emailDupBtn').on('click', emailDupCheck)
			
			//중복확인 초기화
			$('#userId').on('change', function() {
				$('input[name=idChecked]').val("notYet");
				$('#userId').css('background-color', 'white');
				$('#userId').css('border', 'solid 1px red');
			});
			$('#email').on('change', function() {
				$('input[name=emailChecked]').val("notYet");
				$('#email').css('background-color', 'white');
				$('#email').css('border', 'solid 1px red');
			});

			$('#joinBtn').on('click', joinCheck);//빈칸 확인후 submit

			//비밀번호 일치 여부확인
			$('#password').focusout(pwdCheck);
			$('#passwordCheck').focusout(pwdCheck);
			$('#passwordCheck').css('border', '1px solid black');
			$('#passwordCheck').css('background-color', 'white');
			function pwdCheck() {
				if ($('#passwordCheck').val() == "") {
					$('#checkMsg2').show();
					return false;
				}
				if ($('#password').val() !== $('#passwordCheck').val()) {
					$('#passwordCheck').css('background-color', 'red');
					return false;
				} else {
					$('#passwordCheck').css('border', '1px solid black');
					$('#passwordCheck').css('background-color', 'lightgreen');
					return true;
				}
			}

			//아이디 중복 확인
			function idDupCheck() {
				var form = document.joinForm;
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");

				if ($("#userId").val() == "") {
					alert("아이디를 입력해주세요.");
					$("#userId").css('background-color', 'white');
					;
					$('#userId').focus();
					return false;
				}

				$.ajax({
					url : "/user/idDupCheck",
					type : "post",
					datatype : "text",
					data : {
						"userId" : joinForm.userId.value
					},
					beformSend : function(xhr) {
						xhr.setRequestHeader(header, token);
					},
					success : function(data) {
						if (data === 'success') {//사용가능
							$('#idChecked').val("ok");
							$('#userId').css('border', 'solid 1px black');
							$('#userId').css('background-color', 'lightgreen');
							return true;
						} else {//중복
							alert("이미 사용중인 아이디입니다.");
							$('#idChecked').val("notYet");
							$('#userId').css('background-color', 'red');
							$('#userId').focus();
							return false;
						}
					},
					error : function() {
						alert("Error");
					}
				});

			}
			//이메일 중복 확인
			function emailDupCheck() {
				var form = document.joinForm;
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");

				if ($("#email").val() == "") {
					alert("이메일을 입력 해 주세요.");
					$('#email').focus();
					return false;
				}

				$.ajax({
					url : "/user/emailDupCheck",
					type : "post",
					datatype : "text",
					data : {
						"email" : joinForm.email.value
					},
					beformSend : function(xhr) {
						xhr.setRequestHeader(header, token);
					},
					success : function(data) {
						if (data === 'success') {
							$('#emailChecked').val("ok");
							$('#email').css('border', 'solid 1px black');
							$('#email').css('background-color', 'lightgreen');
							return true;
						} else {
							alert("이미 사용중인 이메일입니다.");
							$('#emailChecked').val("notYet");
							$('#email').css('background-color', 'red');
							$('#email').focus();
							return false;
						}
					},
					error : function() {
						alert("Error");
					}
				});

			}

			//빈칸/중복/비밀번호일치 확인 후 submit
			function joinCheck() {
				if ($('#userId').val() == "") {
					alert("아이디를 입력 해 주세요.");
					$('#userId').focus();
					return false;
				}
				if ($('#idChecked').val() == "notYet") {
					alert("아이디 중복확인이 필요합니다.");
					$('#userId').focus();
					return false;
				}
				if ($('#userName').val() == "") {
					alert("이름을 입력 해 주세요.");
					$('#userName').focus();
					return false;
				}
				if ($('#password').val() == "") {
					alert("비밀번호를 입력 해 주세요.");
					$('#password').focus();
					return false;
				}
				if ($('#password').val() !== $('#passwordCheck').val()) {
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}
				if ($('#email').val() == "") {
					alert("이메일을 입력 해 주세요.");
					$('#email').focus();
					return false;
				}
				if ($('#emailChecked').val() == "notYet") {
					alert("이메일 중복확인이 필요합니다.");
					$('#email').focus();
					return false;
				}

				return true;
			}

		});
	</script>
</body>
</html>