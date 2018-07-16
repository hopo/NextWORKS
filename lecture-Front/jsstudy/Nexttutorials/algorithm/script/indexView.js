"use strict"

// ===================================
// template/indexView.js
// ===================================


// ! using node
var nodeDiv = null;
var nodeSelect = null;
var nodeOption = null;
var nodeInput = null;
var nodeTextarea = null;

// ! using class, id
var groundDiv = null;
var opening = null;
var qSel = null;
var replyText = null;

// ! screen decoration
nodeDiv = document.createElement("div");
nodeDiv.setAttribute("class", "vl"); // div.vl
document.body.appendChild(nodeDiv);

// ! global variable
var g_selQzId = null; // ;; selectedIndex

// ! global functions
function groundInit() {
	groundDiv = document.querySelector("#groundDiv");
	document.body.removeChild(groundDiv);

	nodeDiv = document.createElement("div");
	nodeDiv.setAttribute("id", "groundDiv");
	document.body.appendChild(nodeDiv);
}

function goMain() {
	location.reload("../../app.html");
}
