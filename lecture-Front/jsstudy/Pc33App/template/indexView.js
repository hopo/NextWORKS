"use strict"

// ===================================
// template/indexView.js
// ===================================

// ! global variable
var g_selQzId = null; // ;; selectedIndex
var g_selSolId = null;

// ! using node
var nodeDiv = null;
var nodeSelect = null;
var nodeOption = null;
var nodeInput = null;

// ! using class, id
var groundDiv = null;
var opening = null;
var qSel = null;

// ! screen decoration
nodeDiv = document.createElement("div");
nodeDiv.setAttribute("class", "vl"); // div.vl
document.body.appendChild(nodeDiv);


// ! global functions
function groundInit() {
    /*
    // ! clear div#groundDiv
    groundDiv = document.querySelector("#groundDiv");
    var chil = groundDiv.children;
    var lnth = chil.lenth;
    while (chil != null) {
        groundDiv.removeChild(chil[0]);
    }
    */

    groundDiv = document.querySelector("#groundDiv");
    document.body.removeChild(groundDiv);

	nodeDiv = document.createElement("div"); 
	nodeDiv.setAttribute("id", "groundDiv");
	document.body.appendChild(nodeDiv);
}
