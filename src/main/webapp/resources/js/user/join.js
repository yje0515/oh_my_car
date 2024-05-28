$(document)
	.ready(
		function () {
			//입력양식 초기화
			$(".joinRules").hide();
			$(".joinRules").css({
				'color': 'red',
				'font-size': '12px'
			});

			//중복확인
			$('#idDupBtn').on('click', idDupCheck)
			$('#emailDupBtn').on('click', emailDupCheck)

			//중복확인 초기화
			$('#userId').on('change', function () {
				$('input[name=idChecked]').val("notYet");
				$('#userId').css('background-color', 'white');
				$('#userId').css('border', 'solid 1px red');
			});
			$('#email').on('change', function () {
				$('input[name=emailChecked]').val("notYet");
				$('#email').css('background-color', 'white');
				$('#email').css('border', 'solid 1px red');
			});

			//joinCheck함수 실행 후 submit
			$('#joinBtn').on('click', joinCheck);

			//비밀번호 일치 여부확인
			$('#password').focusout(pwdCheck);
			$('#passwordCheck').focusout(pwdCheck);
			$('#passwordCheck')
				.css('border', '1px solid black');
			$('#passwordCheck')
				.css('background-color', 'white');

			function pwdCheck() {
				if ($('#passwordCheck').val() == "") {
					/* $('#checkMsg2').show(); */
					return false;
				}
				if ($('#password').val() !== $('#passwordCheck')
					.val()) {
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

			//입력양식 확인
			$('#userId').focusout(function () {
				//영문소문자,숫자,언더바 5~20자
				var userIdRule = RegExp(/^[a-z0-9_]{5,20}$/);
				if (!userIdRule.test($("#userId").val())) {
					$("#userIdRule").show();
					$("#userIdRuleChecked").val("notYet");
					return false;
				} else {
					$("#userIdRule").hide();
					$("#userIdRuleChecked").val("ok");
				}
			})

			$('#userName').focusout(function () {
				//한글만 가능(자음 불가능)
				var userNameRule = RegExp(/^[가-힣]+$/);
				if (!userNameRule.test($("#userName").val())) {
					$("#userNameRule").show();
					$("#userNameRuleChecked").val("notYet");
					return false;
				} else {
					$("#userNameRule").hide();
					$("#userNameRuleChecked").val("ok");
				}
			})
			$('#password')
				.focusout(
					function () {
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
			$('#email')
				.focusout(
					function () {
						//이메일형식
						var emailRule = RegExp(/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/);
						if (!emailRule.test($("#email")
							.val())) {
							$("#emailRule").show();
							$("#emailRuleChecked").val(
								"notYet");
							return false;
						} else {
							$("#emailRule").hide();
							$("#emailRuleChecked").val(
								"ok");
						}

					})

			//아이디 중복 확인
			function idDupCheck(token, header) {
				var form = document.joinForm;
				var token = $("meta[name='_csrf']").attr(
					"content");
				var header = $("meta[name='_csrf_header']")
					.attr("content");

				if ($("#userId").val() == "") {
					alert("아이디를 입력해주세요.");
					$("#userId").css('background-color',
						'white');
					$('#userId').focus();
					return false;
				}

				$.ajax({
					url: "/user/idDupCheck",
					type: "post",
					datatype: "text",
					data: {
						"userId": joinForm.userId.value
					},
					beforeSend: function (xhr) {
						xhr.setRequestHeader(header, token);
					},
					success: function (data) {
						if (data === 'success') {//사용가능
							$('#idChecked').val("ok");
							$('#userId').css('border',
								'solid 1px black');
							$('#userId').css(
								'background-color',
								'lightgreen');
							return true;
						} else {//중복
							alert("이미 사용중인 아이디입니다.");
							$('#idChecked').val("notYet");
							$('#userId').css(
								'background-color', 'red');
							$('#userId').focus();
							return false;
						}
					},
					error: function (xhr, status, error) {
						alert("서버 요청 실패 " + error);
					}
				});

			}
			//이메일 중복 확인
			function emailDupCheck(token, header) {
				var form = document.joinForm;
				var token = $("meta[name='_csrf']").attr(
					"content");
				var header = $("meta[name='_csrf_header']")
					.attr("content");

				if ($("#email").val() == "") {
					alert("이메일을 입력 해 주세요.");
					$('#email').focus();
					return false;
				}

				$.ajax({
					url: "/user/emailDupCheck",
					type: "post",
					datatype: "text",
					data: {
						"email": joinForm.email.value
					},
					beforeSend: function (xhr) {
						xhr.setRequestHeader(header, token);
					},
					success: function (data) {
						if (data === 'success') {
							//이메일이 사용 가능한 경우
							$('#emailChecked').val("ok");
							$('#email').css('border',
								'solid 1px black');
							$('#email').css('background-color',
								'lightgreen');
							return true;
						} else {
							//이미 사용중인 이메일인 경우
							alert("이미 사용중인 이메일입니다.");
							$('#emailChecked').val("notYet");
							$('#email').css('background-color',
								'red');
							$('#email').focus();
							return false;
						}
					},
					error: function (xhr, status, error) {
						alert("서버 요청 실패 " + error);
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
				if ($('#idChecked').val() != "ok") {
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
				if ($('#password').val() !== $('#passwordCheck')
					.val()) {
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}
				if ($('#email').val() == "") {
					alert("이메일을 입력 해 주세요.");
					$('#email').focus();
					return false;
				}
				if ($('#emailChecked').val() != "ok") {
					alert("이메일 중복확인이 필요합니다.");
					$('#email').focus();
					return false;
				}
				if ($("#userIdRuleChecked").val() != "ok") {
					alert("양식에 맞춰 기입해 주세요.");
					return false;
				}
				if ($("#userNameRuleChecked").val() != "ok") {
					alert("양식에 맞춰 기입해 주세요.");
					return false;
				}
				if ($("#passwordRuleChecked").val() != "ok") {
					alert("양식에 맞춰 기입해 주세요.");
					return false;
				}
				if ($("#emailRuleChecked").val() != "ok") {
					alert("양식에 맞춰 기입해 주세요.");
					return false;
				}

				return true;
			}

		});