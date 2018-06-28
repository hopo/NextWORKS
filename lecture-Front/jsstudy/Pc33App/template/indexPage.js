"use strict"

// ===================================
// idex page template
// ===================================

var nodeDiv = document.createElement("div");
nodeDiv.setAttribute("id", "groundDiv");

var nodeSelect = document.createElement("select");
nodeSelect.setAttribute("name", "quizSelect");
nodeSelect.setAttribute("id", "qSel"); // select#qSel
nodeSelect.setAttribute("onclick", "quizStart()");
nodeSelect.setAttribute("multiple", "true");

nodeDiv.appendChild(nodeSelect);
document.body.appendChild(nodeDiv);

nodeDiv = document.createElement("div");
nodeDiv.setAttribute("id", "groundDiv"); // div#groundDiv


nodeDiv = document.createElement("div");
nodeDiv.setAttribute("class", "vl"); // div.vl

document.body.appendChild(nodeDiv);

function quizStart() {
    var selQzIdx = qSel.options.selectedIndex;
    editorPage(selQzIdx); // call template/editorPage.js
}