let index = {
    init: function () {
        $("#btn-save").on("click", () => { //()=> : this 를 binding 하기 위해서 사용
            this.save();
        })
    },
    save: function () {
        let data = {
            subject: $("#subject").val(),
            professor: $("#professor").val(),
            no: $("#no").val(),
            days: $("#days").val(),
            start: $("#start").val(),
            finish: $("#finish").val()
        }
        console.log(data);

        $.ajax({
            // 회원가입 수행 요청
            type:"POST",
            url:"/subject/add",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            console.log(resp);
            alert("과목 추가 완료");
            location.href = "/";
        }).fail(function(error){
                alert(JSON.stringify(error));
        });
    }

}

index.init();