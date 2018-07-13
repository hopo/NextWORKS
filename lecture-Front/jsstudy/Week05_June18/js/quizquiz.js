"use strict"


// DOM {{{
var input = document.createElement("input");
input.setAttribute("type", "button");
input.setAttribute("value", "quiz1");
input.setAttribute("onclick", "handleQuiz1()");
document.body.appendChild(input);

input = document.createElement("input");
input.setAttribute("type", "button");
input.setAttribute("value", "quiz2");
input.setAttribute("onclick", "handleQuiz2()");
document.body.appendChild(input);

var div = document.createElement("div");
div.setAttribute("id", "printDiv");
document.body.appendChild(div);
// }}}


// array print
function arrDisp(arr) {
    var printDiv = document.getElementById("printDiv");
    printDiv.innerHTML = "[  ";
    for (var i in arr) {
        printDiv.innerHTML += arr[i];
        if (i != arr.length - 1) {
            printDiv.innerHTML += ", ";
        }
    }
    div.textContent += "  ]";
}


// quiz1)
//  사람이름을계속입력받아배열에저장하고그저장된이름을 출력하는 프로그램을 작성하시오.
// (단, 입력은 prompt 명령을 이용하고, 입력의 마지막은 공백문자를 
// 입력하거나 "취소" 버튼 을 눌렀을 때로 한다. "취소" 버튼은 null 또는 "null"이 입력될 때이다.)
function handleQuiz1() {
    var names = Array();
    while (true) {
        var str = prompt("What your name?");
        if (str == null || str == '') {
            break;
        }
        names.push(str);
    }
    arrDisp(names);
}


// quiz2)
//  서로 중복되지 않은 정수 5개를 입력 받아 출력하는 프로그램을 작성하시오.
function handleQuiz2() {
    var numbers = Array();
    while (numbers.length < 5) {
        var num = parseInt(prompt("Input number: "));
        if (numbers.indexOf(num) != -1) {
            alert("중복!!!");
        } else {
            numbers.push(num);
        }
    }
    arrDisp(numbers);
}
