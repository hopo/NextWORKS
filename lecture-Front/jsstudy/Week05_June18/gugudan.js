"use strict"

function inner(n) {
    for (var i = 1; i <= 9; i++) {
        var nodeDiv = document.createElement("div");
        nodeDiv.textContent = (n + " x " + i + " = " + (n * i));
        document.body.appendChild(nodeDiv);
    }
}

function outer() {
    for (var n = 2; n <= 9; n++) {
        inner(n);
    }
}

function gugudan() {
    outer();
}

window.onload = gugudan();