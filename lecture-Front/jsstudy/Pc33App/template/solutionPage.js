"use strict"


function solutionPage() {
    var nodeDiv = null;
    var lnth = db_solution.length
    var r = null;
    for (var i = 0; i < lnth; i++) {
        r = lnth - 1 - i;
        nodeDiv = document.createElement("div");
        nodeDiv.setAttribute("class", "solDiv");
        nodeDiv.setAttribute("id", db_solution[r].s_id);
        nodeDiv.textContent = db_solution[r].code;
        document.body.appendChild(nodeDiv);
    }
}

