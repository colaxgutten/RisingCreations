function editName() {
    document.getElementById("namecontainer").style.display = "none";
    var nameInput = document.getElementById("get_name");
    nameInput.value = document.getElementById("name").innerText;
    nameInput.style.display = "block";
    nameInput.focus();
}

function editDesc() {
    document.getElementById("desccontainer").style.display = "none";
    var nameInput = document.getElementById("get_desc");
    nameInput.value = document.getElementById("desc").innerText;
    nameInput.style.display = "block";
    nameInput.focus();
}

function cancelName() {
    document.getElementById("namecontainer").style.display = "block";
    document.getElementById("get_name").style.display = "none";
}

function cancelDesc() {
    document.getElementById("desccontainer").style.display = "block";
    document.getElementById("get_desc").style.display = "none";
}

function editImg() {
    document.getElementById("get_file").click();
    // document.getElementById("get_file").style.display="block";
}

$(document).keyup(function (e) {
    if (e.keyCode == 27) { // escape key maps to keycode `27`
        cancelName();
        cancelDesc();
    }
});

$('#profileli').addClass("active");