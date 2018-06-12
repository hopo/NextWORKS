"use strict"


// 1 그냥 구구단
// 2 입력 단 빼고 구구단
// 3 입력 단 까지 구구단
// 4 시작단 과 끝단

function writeStr(i, j) {
    return i + " x " + j + " = " + i * j + "<br>";
}

function gugu(numA, numB) {
    var ret = '';
    for (var i = numA; i <= numB; i++) {
        for (var j = 1; j <= 9; j++) {
            ret += writeStr(i, j);
        }
    }
    return ret;
}

function fun01() {
    document.getElementById("div01").innerHTML = gugu(2, 9);
}

function fun02() {
    var extNum = prompt("extNum: ");
    document.getElementById("div02").innerHTML = gugu(2, extNum-1);
    document.getElementById("div02").innerHTML += gugu(extNum+1, 9);
}

function fun03() {
    var endNum = prompt("endNum: ");
    document.getElementById("div03").innerHTML = gugu(2, endNum);
}

function fun04() {
    var startNum = prompt("startNum: ");
    var endNum = prompt("endNum: ");
    document.getElementById("div04").innerHTML = gugu(startNum, endNum);
}
