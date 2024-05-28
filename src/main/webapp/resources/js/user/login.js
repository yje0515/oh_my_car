$(document).ready(function () {
    $('#loginBtn').on('click', loginCheck);
    $("#wrongAccess").hide();

   

function loginCheck(token, header) {
    var form = document.loginForm;
    var token = $("meta[name='_csrf']").attr(
        "content");
    var header = $("meta[name='_csrf_header']")
        .attr("content");

    if ($('#userId').val() == "") {
        alert("아이디를 입력 해 주세요.");
        $('#userId').focus();
        return false;
    }
    if ($('#password').val() == "") {
        alert("비밀번호를 입력 해 주세요.");
        $('#password').focus();
        return false;
    }

    $.ajax({
        url: "/user/loginCheck",
        type: "post",
        datatype: "text",
        data: {
            "userId": loginForm.userId.value,
            "password": loginForm.password.value
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data.trim() === 'success') {//로그인 성공
                form.submit();
            } else {//아이디가 없거나,비밀번호가 틀림
                $("#wrongAccess").show();
            }
        },
        error: function (xhr, status, error) {
            alert("서버요청실패");
        }
    });
}
    
    
});