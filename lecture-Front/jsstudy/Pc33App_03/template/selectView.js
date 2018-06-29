"use strict"

// ===================================
// template/selectView.js
// ===================================


/*
 * Select view
 */
function selectView() {
    groundInit();

    groundDiv = document.querySelector("#groundDiv");

    // ! quiz select make
    nodeDiv = document.createElement("div");
    nodeSelect = document.createElement("select");

    nodeSelect.setAttribute("name", "quizSelect");
    nodeSelect.setAttribute("id", "qSel"); // select#qSel
    nodeSelect.setAttribute("onclick", "quizStart()");
    nodeSelect.setAttribute("multiple", "true");

    nodeDiv.appendChild(nodeSelect);
    groundDiv.appendChild(nodeDiv);

    // ! call quizList
    quizList();
}


/* 
 * Selected quiz start
 */
function quizStart() {
    g_selQzId = qSel.options.selectedIndex;

    // ! call template/editorPage.js
    editorView(); 
}

/* 
 * Show quiz list
 */
function quizList() {
    // ! quiz list view
    qSel = document.querySelector("#qSel");

    for (var e of db_quiz) {
        nodeOption = document.createElement("option");
        nodeOption.setAttribute("value", e.q_id);
        nodeOption.textContent = e.title;
        qSel.appendChild(nodeOption);
    }
}
