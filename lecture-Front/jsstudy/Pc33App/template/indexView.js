"use strict"

// ===================================
// index view
// ===================================

var x = 42;
function xy () {
	return x*2;
}
console.log('indexView x: ', x)
console.log('indexView xy: ', xy())

var nodeDiv = document.createElement("div");
nodeDiv.setAttribute("class", "vl");	// div.vl
document.body.appendChild(nodeDiv);
