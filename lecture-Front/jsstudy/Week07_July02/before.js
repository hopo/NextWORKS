"use strict"

/*
// exA
function key_check() {
    console.log("[You Key Pressed Keycode is '" + event.keyCode + "' ]");
}

function key_check1() {
    console.log("[You Key Down Keycode is '" + event.keyCode + "' ]");
}
*/

// exB
function key_check(evt) {
    console.log("[You Key Pressed Keycode is '" + evt.keyCode + "' ]");
}

function key_check1() {
    console.log("[You Key Down Keycode is '" + event.keyCode + "' ]");
}

// !! Accept event function
// ;; function rear. No ()
document.getElementById("tb").onkeypress = key_check1;