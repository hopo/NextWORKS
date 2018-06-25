"use strict"

function examSelect() {
    var sel = document.querySelector("#examSel");
    var selIdx = sel.options.selectedIndex;

    var myDiv = document.querySelector("#myDiv");

    switch (selIdx) {
        case 0:
            exam1();
            break;
        case 1:
            exam2();
            break;
        case 2:
            exam3();
            break;
        case 3:
            exam4();
            break;
    }
}