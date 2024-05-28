
$(document)
    .ready(
        function () {
            //입력양식 초기화
            $(".updateRules").hide();
            $(".updateRules").css({
                'color': 'red',
                'font-size': '12px'
            });
            $('#updateBtn').on('click', updateCheck);//확인후 submit

            $('#password')
                .focusout(
                    function () {
                        //8~24자 영문대문자,소문자,숫자,특수문자 혼합사용
                        var passwordRule = RegExp(/^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{8, 20}$/);
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
                if ($("#passwordRuleChecked").val() != "ok") {
                    alert("양식에 맞춰 기입해 주세요.");
                    return false;
                }

                return true;
            }

            if (${ passwordChecked != 'ok' }){
    history.back();
    alert("비밀번호 확인 후 접근가능합니다.");

}
						});