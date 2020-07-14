// #아이디 중복 체크
$('#checkId').click(function () {
    var data = {
        id : $('#joinId').val()
    };

    $.ajax({
        type: 'post',
        url: '/rest/checkId',
        data: data
    }).done(function(){
        alert("아이디 중복 점검");
    }).fail(function (error) {
        alert(error);
    });
});