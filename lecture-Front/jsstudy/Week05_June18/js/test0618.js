"use strict"

function check() {

    // ! 개체까지만 변수화
    var s1 = document.f1.s1; // array
    var txt1 = document.f1.txt1;
    var txt2 = document.f1.txt2;
    var txt3 = document.f1.txt3;
    var ckb = document.f1.ckb; // array
    var btn1 = document.f1.btn1;


    // // ! 태그로 접근
    // var nodeForms = document.getElementsByTagName("form");
    // nodeForms[1].textarea.innerHTML = txt1.value + "\n";
    // nodeForms[1].textarea.innerHTML += txt2.value + "\n";
    // nodeForms[1].textarea.innerHTML += txt3.value + "\n";

    // document.f1.txt1.value = document.f1.btn1.value;
    // document.f1.txt2.value = document.f1.btn1.value;
    // document.f1.btn1.value = "Button Name changed";


    // ! 이름으로 접근
    // ;textarea의 value는 innerHTML 같은?
    var nameF2 = document.getElementsByName("f2");

    // ;;select
    // ;;;select의 selected의 값은 하나다
    var sltidx = s1.options.selectedIndex;
    nameF2[0].textarea.value = s1[sltidx].value + "\n";

    // ;;text
    nameF2[0].textarea.value += txt1.value + "\n";
    nameF2[0].textarea.value += txt2.value + "\n";
    nameF2[0].textarea.value += txt3.value + "\n";

    // ;;checkbox
    // ;;;checkbox의 checked의 값은 하나이상이다. 그래서 for문 순회가 필요
    for (let c of ckb) {
        if (c.checked) {
            nameF2[0].textarea.value += c.value + "\n";
        }
    }

    // ! button value change
    btn1.value = "Button was clicked";

}