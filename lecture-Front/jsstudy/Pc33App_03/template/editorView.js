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

    // != write code area
    nodeDiv = document.createElement("div");
    nodeDiv.setAttribute("id", "tareaDiv");

    var nodeTextarea = document.createElement("textarea");
    nodeTextarea.setAttribute("id", "tArea");
    nodeTextarea.setAttribute("rows", "10");
    nodeTextarea.setAttribute("cols", "50");

    nodeDiv.appendChild(nodeTextarea);
    // document.body.appendChild(nodeDiv);
    groundDiv.appendChild(nodeDiv);

    // != button Save
    var nodeInput = document.createElement("input");

    nodeInput.setAttribute("type", "button");
    nodeInput.setAttribute("value", "HwanIn");
    nodeInput.setAttribute("onclick", "handleSave()");

    // document.body.appendChild(nodeInput);
    groundDiv.appendChild(nodeInput);

    // != button Reset
    nodeInput = document.createElement("input");

    nodeInput.setAttribute("type", "button");
    nodeInput.setAttribute("value", "Reset");
    nodeInput.setAttribute("onclick", "handleReset()");

    // document.body.appendChild(nodeInput);
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
        sol.reg_id = "Lee";
        sol.code = tArea.value;
        sol.reg_date = "18/18/18";
        db_solution.push(sol);

        tArea.value = '';

        solutionView(); // ; call solution page
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
    nodeDiv.innerHTML += "<div id='qzDesc'>" + db_quiz[g_selQzId].desc + "</div>";
    nodeDiv.innerHTML += "<div id='qzContents'>" + db_quiz[g_selQzId].contents + "</div>";

    return nodeDiv;
}