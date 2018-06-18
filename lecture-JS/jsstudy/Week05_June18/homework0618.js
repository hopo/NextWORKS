"use strict"


var num = 9;

var nodeInput = null;
var nodeTd = null;
var nodeTr = null;
var nodeTbody = null;
var nodeTable = null;

nodeTbody = document.createElement("tbody");
nodeTable = document.createElement("table");
nodeTr = document.createElement("tr");

for (let i = 1; i <= num; i++) {
    nodeTd = document.createElement("td");
    nodeInput = document.createElement("input");

    nodeInput.setAttribute("type", "button");
    nodeInput.setAttribute("value", `${i}`);

    nodeTd.appendChild(nodeInput);
    nodeTbody.appendChild(nodeTd);

    // if (!(i % 3)) {
    //     nodeTbody.appendChild(nodeTr);
    // }
}

nodeTr.appendChild(nodeTd)
nodeTable.appendChild(nodeTbody);
document.body.appendChild(nodeTable);