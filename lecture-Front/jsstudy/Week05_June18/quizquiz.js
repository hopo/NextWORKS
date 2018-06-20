"use strict"


// array print
function arrDisp(arr) {
    document.write("[ ");
    for (var a of arr) {
        document.write(a + " ");
    }
    document.write("]");
}


// quiz1)
//  사람이름을계속입력받아배열에저장하고그저장된이름을 출력하는 프로그램을 작성하시오.
// (단, 입력은 prompt 명령을 이용하고, 입력의 마지막은 공백문자를 
// 입력하거나 "취소" 버튼 을 눌렀을 때로 한다. "취소" 버튼은 null 또는 "null"이 입력될 때이다.)
function quiz1() {
    var names = Array();
    while (true) {
        var str = prompt("What your name?");
        if (str == null || str == '') {
            break;
        }
        names.push(str);
    }
    document.write("quiz1 <br>");
    arrDisp(names);
}


// quiz2)
//  서로 중복되지 않은 정수 5개를 입력 받아 출력하는 프로그램을 작성하시오.
function quiz2() {
    var numbers = Array();
    while (numbers.length < 5) {
        var num = parseInt(prompt("Input number: "));
        if (numbers.indexOf(num) != -1) {
            alert("중복!!!");
        } else {
            numbers.push(num);
        }
    }
    document.write("quiz2 <br>");
    arrDisp(numbers);
}

// main()
window.onload = function main() {
    var select = prompt("이름입력1 / 숫자입력2: ");
    if (select == "1") {
        quiz1();
    } else if (select == "2") {
        quiz2();
    } else {
        document.write("그냥 끝.")
    }
}