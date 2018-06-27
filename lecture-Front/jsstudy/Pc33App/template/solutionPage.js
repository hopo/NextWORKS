"use strict"


function solutionPage() {

    removeEditor(); // when load solution page, remoce Editior

    solutionDocu(); // call solutionDocu (make solution document)
}

function idFilter(tar, chk) {
    // return (chk.match(/^[qs][0-9]/g) == expr);
    return tar.slice(0, 2) == chk.slice(2);
}

function removeEditor() {
    var groundDiv = document.querySelector("#groundDiv");
    groundDiv.removeChild(document.querySelector("#tareaDiv"));

    var inputs = groundDiv.getElementsByTagName("input");
    var lnth = inputs.length;

    for (var i = 0; i < lnth; i++) {
        groundDiv.removeChild(inputs[0]);
    }
}


function solutionDocu() {
    var groundDiv = document.querySelector("#groundDiv");

    var nodeDiv = null;
    var lnth = db_solution.length
    var r = null;

    for (var i = 0; i < lnth; i++) {
        r = lnth - 1 - i;
        var tar = db_solution[r].s_id;
        if (idFilter(tar, "00q0")) { // ;앞 아이디를 받아와야 한다.
            nodeDiv = document.createElement("div");
            nodeDiv.setAttribute("class", "solDiv");
            nodeDiv.setAttribute("id", db_solution[r].s_id); // quiz 아이디 체크
            nodeDiv.innerHTML = "[s_id: " + tar + "]";
            nodeDiv.innerHTML += db_solution[r].code;
            groundDiv.appendChild(nodeDiv);

            replyDocu(tar);
        }
    }
}

function replyDocu(chk) {
    var groundDiv = document.querySelector("#groundDiv");

    var nodeDiv = null;
    var lnth = db_reply.length;
    var r = null;

    for (var i = 0; i < lnth; i++) {
        r = lnth - 1 - i;
        var tar = db_reply[r].r_id;
        if (idFilter(tar, chk)) {
            nodeDiv = document.createElement("div");
            nodeDiv.setAttribute("class", "repDiv");
            nodeDiv.setAttribute("id", db_reply[r].r_id);
            nodeDiv.innerHTML = "[r_id: " + tar + "]";
            nodeDiv.innerHTML += db_reply[r].repl;
            groundDiv.appendChild(nodeDiv);
        }
    }
}