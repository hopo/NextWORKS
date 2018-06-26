"use strict"

// ===================================
// editor page template
// ===================================

function editorPage(selQzIdx) {
    var nodeDiv = document.createElement("div");
    nodeDiv.innerHTML = db_quiz[selQzIdx].title + "<br>";
    nodeDiv.innerHTML += db_quiz[selQzIdx].desc + "<br>";
    nodeDiv.innerHTML += db_quiz[selQzIdx].contents + "<br>";
    document.body.appendChild(nodeDiv);

    // != write code area
    nodeDiv = document.createElement("div");
    var nodeTextarea = document.createElement("textarea");

    nodeTextarea.setAttribute("id", "tArea");
    nodeTextarea.setAttribute("rows", "10");
    nodeTextarea.setAttribute("cols", "50");

    nodeDiv.appendChild(nodeTextarea);
    document.body.appendChild(nodeDiv);

    // != button Save
    var nodeInput = document.createElement("input");

    nodeInput.setAttribute("type", "button");
    nodeInput.setAttribute("value", "Save");
    nodeInput.setAttribute("onclick", `handleSave(${selQzIdx})`);

    document.body.appendChild(nodeInput);

    // != button Reset
    nodeInput = document.createElement("input");

    nodeInput.setAttribute("type", "button");
    nodeInput.setAttribute("value", "Reset");
    nodeInput.setAttribute("onclick", "handleReset()");

    document.body.appendChild(nodeInput);
}

// ! handle save button
function handleSave(selQzIdx) {
    var tArea = document.querySelector("#tArea");

    var sol = Object.create(solution);
    sol.s_id = "q" + (selQzIdx) + "s" + (db_solution.length);
    sol.reg_id = "Lee";
    sol.code = tArea.value;
    sol.reg_date = "18/18/18";
    db_solution.push(sol);

    tArea.value = '';
    console.log("(save #tArea value) textarea#tArea");

    solutionPage();
}

// ! handle reset button
function handleReset() {
    var tArea = document.querySelector("#tArea");
    tArea.value = '';
    console.log("(clear value) textarea#tArea");
}