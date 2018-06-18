"use strict"


var rNum = 3;
var cNum = 3;

var nodeTable = null;
var nodeTbody = null;
var nodeTr = null;
var nodeTd = null;
var nodeInput = null;

nodeTable = document.createElement("table");
nodeTbody = document.createElement("tbody");

var n = 1;
for (let i = 0; i < rNum; i++) {
    nodeTr = document.createElement("tr");

    for (let j = 0; j < cNum; j++) {
        nodeTd = document.createElement("td");
        nodeInput = document.createElement("input");

        nodeInput.setAttribute("type", "button");
        nodeInput.setAttribute("value", `${n++}`);

        nodeTd.appendChild(nodeInput);
        nodeTr.appendChild(nodeTd);
    }

    nodeTbody.appendChild(nodeTr);
}

nodeTable.appendChild(nodeTbody);
document.body.appendChild(nodeTable);