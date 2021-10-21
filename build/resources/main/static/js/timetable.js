$().ready(function () {
    var index = {
        init: function () {
            var subject = document.querySelectorAll(".sub");
            console.log(subject);
            for (var i = 0; i < subject.length; i++) {
                var item = subject.item(i);

                console.log(item);
                console.log(item.children[0]);
                var v1 = item.getAttribute("value");
                const h = 'height :' + v1.toString() + 'px;';
                var v2 = item.children[0].getAttribute("value");
                const p = 'top :' + v2.toString() + 'px';
                const change = h + p;
                item.setAttribute("style", change);



                // item.style
            }
        }
    }
    index.init();
});