<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script src="/resources/js/user/userCheck.js" type="text/javascript"></script>
</head>
<body>
	<div class="join">
		<h1>회원가입</h1>

		<form role="form" method="post" action="/user/join" id="joinForm" name="frm">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="userid" name="userid"
						placeholder="아이디" maxlength="20" autofocus></td>
						<td><input type="button" onclick="idCheck()" value="중복확인"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="username" name="username"
						placeholder="이름"></td>
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
						placeholder="이메일"></td>
						<td><button>이메일중복확인</button></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" id="nickname" name="nickname"
						placeholder="닉네임"></td>
				</tr>
				<tr>
					<td>회원등급</td>
					<td><input type="radio" name="auth" value="ROLE_MEMBER"
						checked="checked">일반회원 <input type="radio" name="auth"
						value="ROLE_ADMIN">관리자</td>
				</tr>
				<tr>
					<td>
						<button type="submit" id="joinBtn">회원가입</button>
					</td>
				</tr>

			</table>

		</form>

	</div>
	<script>
		$(document).ready(function() {

			$('#joinBtn').on('click', joinCheck);//빈칸 확인하는 메서드

			
			
			//비밀번호 일치 여부확인
			$('#checkMsg').hide();
			$('input').keyup(function() {
				if ($('#password').val() !== $('#passwordCheck').val()) {
					$('#checkMsg').show();
				}else{
					$('#checkMsg').hide();
				}
			});

			//빈칸 확인
			function joinCheck() {
				if ($('#userid').val() == "") {
					alert("아이디를 입력 해 주세요.");
					$('#userid').focus();
					return false;
				}
				if ($('#username').val() == "") {
					alert("이름을 입력 해 주세요.");
					$('#username').focus();
					return false;
				}
				if ($('#password').val() == "") {
					alert("비밀번호를 입력 해 주세요.");
					$('#password').focus();
					return false;
				}
				if ($('#passwordCheck').val() == "") {
					alert("비밀번호를 확인 해 주세요.");
					$('#passwordCheck').focus();
					return false;
				}
				if ($('#email').val() == "") {
					alert("이메일을 입력 해 주세요.");
					$('#email').focus();
					return false;
				}

				return true;
			}
			
			//아이디 중복 확인
			function idCheck(){
				if($("#userid").val() == ""){
					alert("아이디를 입력 해 주세요.");
					$('#userid').focus();
					return false
				}
				
				//
			}

		});
	</script>
</body>
</html>