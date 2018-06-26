"use strict"

// ===================================
// quiz select page template
// ===================================

var qSel = document.querySelector("#qSel");

// quiz view template
for (var e of db_quiz) {
    var nodeOption = document.createElement("option");
    nodeOption.setAttribute("value", e.q_id);
    nodeOption.textContent = e.title;
    qSel.appendChild(nodeOption);
}