"use strict"

// ===================================
// template/editorView.js
// ===================================


/*
 * editor view
 */
function editorView() {
    groundInit();

    groundDiv = document.querySelector("#groundDiv");
    nodeDiv = document.createElement("div");

    nodeDiv.appendChild(quizComboDiv());

    groundDiv.appendChild(nodeDiv);

    // ! write code area
    nodeDiv = document.createElement("div");
    nodeDiv.setAttribute("id", "tareaDiv");

    nodeTextarea = document.createElement("textarea");
    nodeTextarea.setAttribute("id", "tArea");
    nodeTextarea.setAttribute("rows", "10");
    nodeTextarea.setAttribute("cols", "80");
    nodeTextarea.setAttribute("placeholder", "// write your code..");

    nodeDiv.appendChild(nodeTextarea);
    groundDiv.appendChild(nodeDiv);

    // ! button Save
    nodeInput = document.createElement("input");

    nodeInput.setAttribute("type", "button");
    nodeInput.setAttribute("value", "체크");
    nodeInput.setAttribute("onclick", "handleSave()");

    groundDiv.appendChild(nodeInput);

    // ! button Reset
    nodeInput = document.createElement("input");

    nodeInput.setAttribute("type", "button");
    nodeInput.setAttribute("value", "리셋");
    nodeInput.setAttribute("onclick", "handleReset()");

    groundDiv.appendChild(nodeInput);
}

/*
* Handle save button
*/
function handleSave() {
    var tArea = document.querySelector("#tArea");

    if (!isEmptyTarea()) {
        var sol = Object.create(solution);

        sol.s_id = "q" + g_selQzId + "s" + db_solution.length;
        sol.reg_id = "O-Kane";
        sol.code = tArea.value;
        sol.reg_date = "18/18/18";

        db_solution.push(sol);

        tArea.value = ''; // ;clear text area

        solutionView(); // ;call solution page
    }
}


/*
* Check is empty text area
*/
function isEmptyTarea() {
    var emptyMsg = "코드를 입력 하세요...";
    if (!tArea.value || tArea.value == emptyMsg) {
        tArea.value = emptyMsg;
        return true;
    } else {
        return false;
    }
}


/*
* Handle reset button
*/
function handleReset() {
    var tArea = document.querySelector("#tArea");
    tArea.value = '';
}


/*
 * Quiz Combo Make
 */
function quizComboDiv() {
    nodeDiv = document.createElement("div");
    nodeDiv.innerHTML = "<div id='qzTitle'>" + db_quiz[g_selQzId].title + "</div>";
    nodeDiv.innerHTML += "<div id='qzDesc'> 설명: " + db_quiz[g_selQzId].desc + "</div>";
    nodeDiv.innerHTML += "<pre id='qzContents'>" + db_quiz[g_selQzId].contents + "</pre>";

    return nodeDiv;
}