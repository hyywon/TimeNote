let index = {
    init: function () {
        $("#btn-delete").on("click", () => { //()=> : this 를 binding 하기 위해서 사용
            this.warn();
        })
    },
    warn: function () {
        let id = $("#noteId").val();
        console.log(id);
        $.ajax({
            // 회원가입 수행 요청
            type:"DELETE",
            url:"/note/delete/"+id,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            console.log(resp);
            alert("노트 삭제 완료");
            location.href = "/";
        }).fail(function(error){
            console.log(JSON.stringify(error));

            alert(JSON.stringify(error));
        });
    }

}

index.init();