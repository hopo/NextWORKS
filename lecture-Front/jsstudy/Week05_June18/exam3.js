"use strict"

var myTxt = null
var mySel01 = null;
var mySel02 = null;

// document {{{
function exam3() {
    var nodeH3 = document.createElement("h3");
    nodeH3.textContent = "Exam3";

    var nodeSelect = document.createElement("select");

    var sel01 = nodeSelect.cloneNode();
    sel01.setAttribute("id", "sel01");
    sel01.setAttribute("size", "9");

    var sel02 = nodeSelect.cloneNode();
    sel02.setAttribute("id", "sel02");
    sel02.setAttribute("size", "9");

    var nodeInput = document.createElement("input");

    var toRBtn = nodeInput.cloneNode();
    toRBtn.setAttribute("type", "button");
    toRBtn.setAttribute("value", ">");
    toRBtn.setAttribute("onclick", "handleToR()");

    var toLBtn = nodeInput.cloneNode();
    toLBtn.setAttribute("type", "button");
    toLBtn.setAttribute("value", "<");
    toLBtn.setAttribute("onclick", "handleToL()");

    var allToRBtn = nodeInput.cloneNode();
    allToRBtn.setAttribute("type", "button");
    allToRBtn.setAttribute("value", ">>");
    allToRBtn.setAttribute("onclick", "handleToR()");

    var allToLBtn = nodeInput.cloneNode();
    allToLBtn.setAttribute("type", "button");
    allToLBtn.setAttribute("value", "<<");
    allToLBtn.setAttribute("onclick", "handleToL()");

    var btnsDiv = document.createElement("div");
    var btns = [toRBtn, toLBtn, allToRBtn, allToLBtn];
    for (var b of btns) {
        btnsDiv.appendChild(b);
    }

    var appendBtn = nodeInput.cloneNode();
    appendBtn.setAttribute("type", "button");
    appendBtn.setAttribute("value", "Append");
    appendBtn.setAttribute("onclick", "handleAppend()");

    var boxesDiv = document.createElement("div");
    boxesDiv.appendChild(sel01);
    boxesDiv.appendChild(btnsDiv);
    boxesDiv.appendChild(sel02);

    var txtDiv = document.createElement("div");
    txtDiv.textContent = "InputTxt";

    var txt = document.createElement("input");
    txt.setAttribute("id", "txt");
    txt.setAttribute("value", "testtext");


    // ! append
    var children = [nodeH3, boxesDiv, txtDiv, txt, appendBtn];
    for (var c of children) {
        document.body.appendChild(c);
    }

    myTxt = document.querySelector("#txt");
    mySel01 = document.querySelector("#sel01");
    mySel02 = document.querySelector("#sel02");
}
// }}}



function handleAppend() {
    var nodeOption = document.createElement("option");
    nodeOption.textContent = myTxt.value;
    myTxt.value = "";
    mySel01.appendChild(nodeOption);
}

function handleToR() {
    handleTo(mySel01, mySel02);
}

function handleToL() {
    handleTo(mySel02, mySel01);
}

function handleAllToR() {
    handleTo(mySel01, mySel02, true);
}

function handleAllToL() {
    handleTo(mySel02, mySel01, true);
}

function handleTo(from, to, all) {
    if (all) {
        while (from.options) {
            to.add(from.options[0]); // ;console에 에러 남
        }
    }

    var idx = from.options.selectedIndex;

    /*
    // ;1. node를 사용
    var nodeOption = document.createElement("option");
    nodeOption.textContent = from[idx].value;
    to.appendChild(nodeOption);
    from.removeChild(from[idx]);
    */

    // ;2. add()를 사용한다면
    to.add(from.options[idx]);

}