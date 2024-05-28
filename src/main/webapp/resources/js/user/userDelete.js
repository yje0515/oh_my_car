$(document).ready(function() {
    $("#deleteBtn").on('click', function() {
        var result = confirm("정말 탈퇴하시겠습니까?");
        if (result) {
            $("#deleteForm").submit();
        } else {
            $("#deleteForm").attr("action", "/user/mypage").attr("method","get").submit();
        }

    })
    

});