"use strict"

var form = null;
var input = null;
var textarea = null;

function exam2() {
    form = document.createElement("form");
    input = document.createElement("input");
    textarea = document.createElement("textarea");

    // !! NAME
    document.body.appendChild(document.createTextNode("NAME: "));

    input.setAttribute("id", "itext2");
    input.setAttribute("type", "text");
    input.setAttribute("value", "Sam");
    document.body.appendChild(input);
    document.body.appendChild(document.createElement("br"));

    // !! GENDER
    document.body.appendChild(document.createTextNode("GENDER: "));

    input = document.createElement("input");
    input.setAttribute("type", "radio");
    input.setAttribute("name", "rdo");
    input.setAttribute("value", "male")
    document.body.appendChild(document.createTextNode("Male"));
    document.body.appendChild(input);

    input = document.createElement("input");
    input.setAttribute("type", "radio");
    input.setAttribute("name", "rdo");
    input.setAttribute("value", "female")
    input.setAttribute("checked", "true")
    document.body.appendChild(document.createTextNode("Female"));
    document.body.appendChild(input);
    document.body.appendChild(document.createElement("br"));

    // ! interest
    document.body.appendChild(document.createTextNode("INTEREST: "));
    document.body.appendChild(document.createTextNode("Book"));
    input = document.createElement("input");
    input.setAttribute("type", "checkbox")
    input.setAttribute("name", "ckb")
    input.setAttribute("value", "Book")
    input.setAttribute("checked", "true")
    document.body.appendChild(input);

    document.body.appendChild(document.createTextNode("Movie"));
    input = document.createElement("input");
    input.setAttribute("type", "checkbox")
    input.setAttribute("name", "ckb")
    input.setAttribute("value", "Movie")
    document.body.appendChild(input);

    document.body.appendChild(document.createTextNode("Music"));
    input = document.createElement("input");
    input.setAttribute("type", "checkbox")
    input.setAttribute("name", "ckb")
    input.setAttribute("value", "Music")
    document.body.appendChild(input);

    document.body.appendChild(document.createTextNode("Sports"));
    input = document.createElement("input");
    input.setAttribute("type", "checkbox")
    input.setAttribute("name", "ckb")
    input.setAttribute("value", "Sports")
    document.body.appendChild(input);

    document.body.appendChild(document.createElement("br"));


    // !! print button
    input = document.createElement("input");
    input.setAttribute("id", "ibtn");
    input.setAttribute("type", "button");
    input.setAttribute("value", "Print");
    input.setAttribute("onclick", "handlePrint2()");
    document.body.appendChild(input);
    document.body.appendChild(document.createElement("br"));


    // !! textarea
    textarea.setAttribute("id", "tarea2");
    textarea.style.width = "200px";
    textarea.style.height = "130px";
    document.body.appendChild(textarea);
    document.body.appendChild(document.createElement("br"));
}

function handlePrint2() {
    var it = document.querySelector("#itext2");
    var ta = document.querySelector("#tarea2");
    var rdo = document.getElementsByName("rdo"); // find radio checked
    var ckb = document.getElementsByName("ckb");

    var name = it.value;
    var gender = '';

    for (var e of rdo) {
        if(e.checked) {
            gender = e.value;
            break;
        }
    }

    ta.value = `Hello! ${name}\nYou Are ${gender}.\n`;
    for (var e of ckb) {
        if (e.checked) {
            ta.value += e.value + " ";
        }
    }
    ta.value += "is your interest!!!";
}

// exam2();
