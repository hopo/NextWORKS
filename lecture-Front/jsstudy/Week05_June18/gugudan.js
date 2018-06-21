"use strict"

// DOM {{{
var input = document.createElement("input");
input.setAttribute("type", "button");
input.setAttribute("onclick", "handleGugudan()");
input.setAttribute("value", "gugudan");
document.body.appendChild(input);

input = document.createElement("input");
input.setAttribute("type", "button");
input.setAttribute("onclick", "handleReset()");
input.setAttribute("value", "reset");
document.body.appendChild(input);
// ! }}}


// ! functions
function inner(n) {
    for (var i = 1; i <= 9; i++) {
        var div = document.createElement("div");
        div.textContent = `${n} x ${i} = ${n * i}`;
        document.body.appendChild(div);
    }
}

function outer() {
    for (var n = 2; n <= 9; n++) {
        var div = document.createElement("div");
        div.textContent = `${n}단`;
        document.body.appendChild(div);
        inner(n);
    }
}

// ! handle functions
function handleGugudan() {
    outer();
}

function handleReset() {
    location.replace(window.location);
}
