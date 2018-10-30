var csrf_name = $('meta[name="csrf_name"]').attr('content');
var csrf_value = $('meta[name="csrf_value"]').attr('content');

function loveOrLike(url, counter, btnid, newclass) {
    $.ajax({
        type: "POST",
        url: url,
        data: csrf_name + "=" + encodeURIComponent(csrf_value),
        success: function (obj) {
            document.getElementById(counter).innerText = obj.key;
            if (obj.value) {
                document.getElementById(btnid).setAttribute("class", "fas " + newclass);
            } else {
                document.getElementById(btnid).setAttribute("class", "far " + newclass);
            }
        }
    });
}