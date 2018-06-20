"use strict"

// ! write document
var nodeInput = document.createElement("input");
nodeInput.setAttribute("type", "button");
nodeInput.setAttribute("onclick", "handleGugudan()");
nodeInput.setAttribute("value", "makeGugudan");
document.body.appendChild(nodeInput);

nodeInput = document.createElement("input");
nodeInput.setAttribute("type", "button");
nodeInput.setAttribute("onclick", "handleReset()");
nodeInput.setAttribute("value", "reset");
document.body.appendChild(nodeInput);


// ! functions
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

// ! handle functions
function handleGugudan() {
    outer();
}

function handleReset() {
    location.replace(window.location);
}
