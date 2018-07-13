"use strict"

var form = null;
var select = null;
var option = null;
var input = null;
var h3 = null;
var div = null

function exam4() {
    form = document.createElement("form");
    select = document.createElement("select");
    select.setAttribute("id", "sel");

    for (var i = 2; i <= 9; i++) {
        option = document.createElement("option");
        option.setAttribute("value", i);
        option.textContent = i + " Dan";
        select.appendChild(option);
    }
    form.appendChild(select);

    document.body.appendChild(form);

    input = document.createElement("input");
    input.setAttribute("type", "button");
    input.setAttribute("value", "print");
    input.setAttribute("onclick", "handlePrint4()");
    document.body.appendChild(input);

    h3 = document.createElement("h3");
    h3.appendChild(document.createTextNode("ResultPrint"));
    document.body.appendChild(h3);

    div = document.createElement("div");
    div.setAttribute("id", "resultDiv");
    document.body.appendChild(div);
}

function handlePrint4() {
    var resultDiv = document.querySelector("#resultDiv");
    var sel = document.querySelector("#sel");

    resultDiv.innerHTML = gugudan(sel.value, "<br>");
}
