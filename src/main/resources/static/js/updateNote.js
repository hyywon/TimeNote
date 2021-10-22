seehtml = function (editor) {
    alert(editor.getHTML());
    const title = document.getElementById('title').value;
    const sub = document.getElementById('selectSub').value;
    let id = $("#id").val();

    let data = {
        title: title,
        content: editor.getHTML(),
        subject_id: Number(sub),
    }

    console.log(data);

    $.ajax({
        type: "PUT",
        url: "/note/update/"+id,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function (resp) {
        alert("노트 수정완료");
        location.href = "/detail?id="+id;
    }).fail(function (error) {
        alert(JSON.stringify(error));
    });

}
