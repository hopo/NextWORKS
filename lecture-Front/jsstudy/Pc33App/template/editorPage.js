"use strict"

// ===================================
// editor page template
// ===================================


function editorPage(selQzIdx) {
    var groundDiv = document.querySelector("#groundDiv");
    document.body.removeChild(groundDiv);

    var nodeDiv = document.createElement("div");
    nodeDiv.setAttribute("id", "groundDiv");
    document.body.appendChild(nodeDiv);
    groundDiv = document.querySelector("#groundDiv");

    nodeDiv = document.createElement("div");
    nodeDiv.innerHTML = db_quiz[selQzIdx].title + "<br>";
    nodeDiv.innerHTML += db_quiz[selQzIdx].desc + "<br>";
    nodeDiv.innerHTML += db_quiz[selQzIdx].contents + "<br>";
    // document.body.appendChild(nodeDiv);
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
    nodeInput.setAttribute("value", "Save");
    nodeInput.setAttribute("onclick", `handleSave(${selQzIdx})`);

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

// ! handle save button
function handleSave(selQzIdx) {
    var tArea = document.querySelector("#tArea");

    if (!isEmptyTarea()) {
        var sol = Object.create(solution);
        sol.s_id = "q" + (selQzIdx) + "s" + (db_solution.length);
        sol.reg_id = "Lee";
        sol.code = tArea.value;
        sol.reg_date = "18/18/18";
        db_solution.push(sol);

        tArea.value = '';

        solutionPage(); // ; call solution page
    }
}

function isEmptyTarea() {
    if (!tArea.value || tArea.value == "코드를 입력 하세요~") {
        tArea.value = "코드를 입력 하세요~";
        return true;
    } else {
        return false;
    }
}

// ! handle reset button
function handleReset() {
    var tArea = document.querySelector("#tArea");
    tArea.value = '';
}