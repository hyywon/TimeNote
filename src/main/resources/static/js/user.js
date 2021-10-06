let index = {
    init: function () {
        $("#btn-join").on("click", () => { //()=> : this 를 binding 하기 위해서 사용
            this.save();
        }),
        $("#btn-login").on("click", () => { //()=> : this 를 binding 하기 위해서 사용
            this.login();
        });
    },
    save: function () {
        let data = {
            email: $("#email").val(),
            username: $("#username").val(),
            password: $("#password").val(),
        }
        console.log(data);
        // ajax 통신을 통해서 입력받은 데이터 input 요청
        // ajax 호출 시 default 가 비동기 호출
        $.ajax({
            // 회원가입 수행 요청
            type:"POST",
            url:"/join",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            console.log(resp);
            alert("회원가입 성공");
            location.href = "/";
        }).fail(function(error){
                alert(JSON.stringify(error));
                alert("회원가입 실패");

        });
    },
    login: function () {
        let data = {
            email: $("#email").val(),
            password: $("#password").val()
        }

        $.ajax({
            type: "POST",
            url: "/login",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json; charset=utf-8"
        }).done(function (resp) {
            console.log(data);
            alert("로그인완료");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
            console.log(JSON.stringify(error));
        });
    }
}

index.init();