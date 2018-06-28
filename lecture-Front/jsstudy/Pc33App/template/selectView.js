"use strict"

// ===================================
// select view
// ===================================

function selectView() {
    var groundDiv = document.querySelector("#groundDiv");
    
    // ! opening remove
    // ! clear div#groundDiv children
    var opening = document.querySelector("#opening");
    groundDiv.removeChild(opening);

    var nodeDiv = document.createElement("div");
    var nodeSelect = document.createElement("select");

    nodeSelect.setAttribute("name", "quizSelect");
    nodeSelect.setAttribute("id", "qSel"); // select#qSel
    nodeSelect.setAttribute("onclick", "quizStart()");
    nodeSelect.setAttribute("multiple", "true");

    nodeDiv.appendChild(nodeSelect);
    groundDiv.appendChild(nodeDiv);

    quizList();
}

function quizStart() {
    var selQzIdx = qSel.options.selectedIndex;
    editorPage(selQzIdx); // call template/editorPage.js
}

function quizList() {
    var qSel = document.querySelector("#qSel");

    // quiz view template
    for (var e of db_quiz) {
        var nodeOption = document.createElement("option");
        nodeOption.setAttribute("value", e.q_id);
        nodeOption.textContent = e.title;
        qSel.appendChild(nodeOption);
    }
}