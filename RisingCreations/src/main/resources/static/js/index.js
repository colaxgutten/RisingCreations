var modal = document.getElementById('modal');
var modalimage = document.getElementById('modalimg');
var caption = document.getElementById('caption');

function imgclick(url, title) {
    modal.style.display = "block";
    caption.textContent = title;
    modalimage.src = url;
}

var close = document.getElementById('close');

close.onclick = function () {
    modal.style.display = "none";
};

$(document).keyup(function (e) {
    if (e.keyCode == 27) { // escape key maps to keycode `27`
        modal.style.display = "none";
    }
});

$('#homeli').addClass("active");