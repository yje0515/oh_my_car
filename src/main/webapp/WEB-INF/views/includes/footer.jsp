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
	background-color: #1A87C6;
}

#footerInfoBox {
	background-color: white;
	width: 800px;
	height: 200px;
	position: absolute;
	margin: 50px auto;
	left:0;
	right:0;
}

#footerInfoBox table {
	border-collapse: separate;
	border-spacing:136px 14px;
}

#footerWrap #logoImg {
	margin: 170px 0 0 750px;
	float:right;
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
					<th>ㅇㅇㅇ</th>
					<th>ㅁㅁㅁ</th>
					<th>ㅎㅎㅎ</th>
				</tr>
				<tr>
					<td>회사정보</td>
					<td>회사정보</td>
					<td>회사정보</td>
				</tr>
				<tr>
					<td>사업자정보</td>
					<td>사업자정보</td>
					<td>사업자정보</td>
				</tr>
				<tr>
					<td>사이트소개</td>
					<td>사이트소개</td>
					<td>사이트소개</td>
				</tr>
			</table>
		</div>

		<a id="logoImg" href="/"><img
			src="../resources/img/ohmycar_logo.png" style="width: 250px;"></a>
	</div>

</body>
</html>