
seehtml = function(editor) {
    alert(editor.getHTML());
    var title = "title";

    let data = {
        title: title,
        content: editor.getHTML()
    }

    console.log(data);

    $.ajax({
        type: "POST",
        url: "/note/add",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function (resp){
        alert("노트 추가완료");
    }).fail(function (error){
        alert(JSON.stringify(error));
    });

}
