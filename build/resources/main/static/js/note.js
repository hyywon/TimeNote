seehtml = function (editor) {
    alert(editor.getHTML());
    const title = document.getElementById('title').value;
    const sub = document.getElementById('selectSub').value;
    const user = document.getElementById('user_id').innerHTML;
    let data = {
        title: title,
        content: editor.getMarkdown(),
        subject_id: Number(sub),
        user_id: user
    }

    $.ajax({
        type: "POST",
        url: "/note/add",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function (resp) {
        alert("노트 추가완료");
        location.href = "/";
    }).fail(function (error) {
        alert(JSON.stringify(error));
    });

}
