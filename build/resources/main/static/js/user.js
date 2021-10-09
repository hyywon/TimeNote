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
            school: $("#school").val()
        }
        console.log(data);
        // ajax 통신을 통해서 입력받은 데이터 input 요청
        // ajax 호출 시 default 가 비동기 호출
        $.ajax({
            // 회원가입 수행 요청
            type:"POST",
            url:"/auth/join",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            if(resp.status === 500){
                console.log(resp);
                alert("Email 중복");
            }else{
                console.log(resp);
                alert("회원가입 성공");
                location.href = "/";
            }
        }).fail(function(error){
                alert(JSON.stringify(error));
                alert("회원가입 실패");

        });
    },
}

index.init();