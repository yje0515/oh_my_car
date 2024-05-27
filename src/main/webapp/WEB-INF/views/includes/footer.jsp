<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0 auto;
}

a {
	text-decoration: none;
}

#footerWrap {
	margin: 0 auto;
	width: 100%;
	height: 300px;
	background-color: #002F65;
}

#footerInfoBox {
	width: 1000px;
	height: 300px;
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	width: 1000px;
}

#footerInfoBox table {
	margin: 70px 0 0 65px;
	float: left;
	text-align: left;
}

#footerInfoBox th {
	color: white;
}

#footerInfoBox td {
	color: lightgray;
}

#footerWrap #logoImg {
	margin: 170px 0 0 750px;
	float: right;
}

.footerSmallText{
	font-size:13px;
}
</style>
</head>
<body>
	<!-- #underHeader sticky설정을 위한 div-->
	</div>
	<!-- 실수 아님 -->

	<div id="footerWrap">
		<div id="footerInfoBox">
			<table>
				<tr>
					<th>ⓒOhmycar Factory</th>
				</tr>
				<tr>
					<td>(주)오마이카팩토리 | 대표 앗차차팀</td>
				</tr>
				<tr>
					<td>00도 00시 00구 00로 0가 000-00 0층</td>
				</tr>
				<tr>
					<td class="footerSmallText">사업자등록번호 : 000 00 00000</td>
				</tr>
				<tr>
					<td class="footerSmallText">통신판매업 : 2024 0000 0000</td>
				</tr>
				<tr>
					<td class="footerSmallText">전화번호 : 000 0000 0000</td>
				</tr>
			</table>
			<table>
				<tr>
					<th>약관</th>
				</tr>
				<tr>
					<td>서비스 이용약관</td>
				</tr>
				<tr>
					<td>개인정보 처리 방침</td>
				</tr>
			</table>
			<table>
				<tr>
					<th>문의</th>
				</tr>
				<tr>
					<td>서비스 문의(e-mail)</td>
				</tr>
				<tr>
					<td>사업 제휴 문의</td>
				</tr>
			</table>
			<table>
				<tr>
					<th>SNS</th>
				</tr>
				<tr>
					<td>네이버 블로그</td>
				</tr>
				<tr>
					<td>인스타그램</td>
				</tr>
				<tr>
					<td>페이스북</td>
				</tr>
			</table>
		</div>

		<a id="logoImg" href="/"><img
			src="../resources/img/logo_white.png" style="width: 250px;"></a>
	</div>

</body>
</html>