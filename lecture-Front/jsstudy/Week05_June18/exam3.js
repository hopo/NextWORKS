"use strict"
var txt = document.querySelector("#txt");
var sel01 = document.querySelector("#sel01");
var sel02 = document.querySelector("#sel02");

function handleAppend() {
    var nodeOption = document.createElement("option");
    nodeOption.textContent = txt.value;
    txt.value = "";
    sel01.appendChild(nodeOption);
}

function handleToR() {
    handleTo(sel01, sel02);
}

function handleToAllR() {
    handleTo(sel01, sel02, true);
}

function handleToL() {
    handleTo(sel02, sel01);
}

function handleToAllL() {
    handleTo(sel02, sel01, true);
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