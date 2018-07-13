"use strict"

var form = null;
var input = null;
var textarea = null;

var t = null;
var br = null;

function exam1() {
    form = document.createElement("form");
    input = document.createElement("input");
    textarea = document.createElement("textarea");

    input.setAttribute("id", "itext");
    input.setAttribute("type", "text");
    input.setAttribute("value", "4");
    document.body.appendChild(input);

    document.body.appendChild(document.createTextNode("Dan"));

    input = document.createElement("input");
    input.setAttribute("id", "ibtn");
    input.setAttribute("type", "button");
    input.setAttribute("value", "Print");
    input.setAttribute("onclick", "handlePrint()");
    document.body.appendChild(input);
    document.body.appendChild(document.createElement("br"));

    textarea.setAttribute("id", "tarea");
    textarea.style.width = "95px";
    textarea.style.height = "130px";
    document.body.appendChild(textarea);
    document.body.appendChild(document.createElement("br"));
}

function handlePrint() {
    var it = document.querySelector("#itext");
    var ta = document.querySelector("#tarea");

    var n = it.value;
    ta.value = gugudan(n);
}

function gugudan(n, end) {
    if (end == null) {
        end =  "\n";
    }
    var ret = '';
    for (var i = 1; i <= 9; i++) {
        ret += `${n}x${i} = ${n * i} ${end}`;
    }
    return ret;
}

// exam1();