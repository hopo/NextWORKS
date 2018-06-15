"use strict"

// ! gloabal variable
var quizLen = 5;
var ansLen = 4;
var ranNums = new Array();

// ! nodes variable
var h3Node = null;
var inputNode = null;
var divNode = null;


// ! 문제 답안 만들기
for (var i = 0; i < quizLen; i++) {
    ranNums[i] = Math.floor(Math.random() * ansLen);

}
console.log(ranNums);



// ! 문제 View
function quizView() {
    for (var n = 1; n <= quizLen; n++) {
        document.write("[[ QUIZ: " + n + " ]]<br>");

        for (var i = 1; i <= ansLen; i++) {
            document.write("0" + i + "&nbsp;");
            inputNode = document.createElement("input");
            inputNode.setAttribute("type", "radio");
            inputNode.setAttribute("name", "mun" + n);

            if (i == 1) {
                inputNode.setAttribute("checked", "true");
            }

            document.body.appendChild(inputNode);
        }

        document.write("<br><br>");
    }
}



// ! 점수 체크 View
function scoreView() {
    h3Node = document.createElement("h3");
    h3Node.innerText = "SCORE MEASURE";
    document.body.appendChild(h3Node);

    inputNode = document.createElement("input");
    inputNode.setAttribute("type", "button");
    inputNode.setAttribute("value", "measure");
    inputNode.setAttribute("onclick", "handleMeasure()");
    document.body.appendChild(inputNode);

    inputNode = document.createElement("input");
    inputNode.setAttribute("type", "button");
    inputNode.setAttribute("value", "reset");
    inputNode.setAttribute("onclick", "handleReset()");
    document.body.appendChild(inputNode);

    divNode = document.createElement("div");
    divNode.setAttribute("id", "board");
    document.body.appendChild(divNode);
}



// ! 체크드 값 알아보기
function handleMeasure() {
    var correctCnt = 0;

    for (var n = 1; n <= quizLen; n++) {
        var eachMun = document.getElementsByName("mun" + n);

        for (var i = 0; i < ansLen; i++) {
            if (eachMun[i].checked) {
                if (ranNums[n - 1] == i) {
                    correctCnt++;
                }
                break;
            }
        }

    }

    document.getElementById("board").innerHTML = `[ ${correctCnt} ]`;
}

function handleReset() {
    location.replace(window.location);
}



// ! main onload
window.onload = function main() {
    quizView();
    scoreView();
}