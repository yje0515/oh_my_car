<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a
		href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=4f8fd0ea2b58d54fc209c75db615c0e7&redirect_uri=http://localhost:8181/shard/login/oauth">
		<img
		src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
		alt="카카오 로그인 버튼" />
		<body>
			<a
				href=https://prd.kr-ccapi.hyundai.com/api/v1/user/oauth2/authorize?
				client_id={YOUR_CLIENT_ID}&redirect_uri={YOUR_REDIRECT_URI}&response_type=code&state={YOUR_STATE_TEXT}>로그인</a>
			<!-- 해당 링크 클릭 시 로그인 인증 요청 API 호출-->
		</body>
</body>
<script>
let express = require('express');
let request = require('request');
let app = express();

let client_id = "400b3231-30db-42f5-ab52-9d69b35a184d";
let redirect_uri = "http://localhost:8282/main";
let state = "200";

const login_url = "https://prd.kr-ccapi.hyundai.com/api/v1/user/oauth2/authorize?response_type=code&client_id=" + client_id + "&redirect_uri=" + redirect_uri + "&state=" + state;

app.get('/login', (req, res) => {
res.redirect(login_url);
console.log("redirect login_url!!");
});
</script>
</html>