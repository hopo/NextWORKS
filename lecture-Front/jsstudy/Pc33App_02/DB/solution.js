"use strict"

var solution = {
    s_id: "",
    reg_id: "",
    code: "",
    reg_date: ""
}

var db_solution = Array();

// s0
var s0 = Object.create(solution);
s0.s_id = "q0s0";
s0.reg_id = "Hillary";
s0.code = `
    function HelloWorld(x, y) {<br>
        return null;<br>
    }<br>
`;
s0.reg_date = "18/06/29";
db_solution.push(s0);

// s1
var s1 = Object.create(solution);
s1.s_id = "q1s1";
s1.reg_id = "Obama";
s1.code = `
    function mySum(x, y) {
        return x + y;
    }
`;
s1.reg_date = "18/06/25";
db_solution.push(s1);

// s2
var s2 = Object.create(solution);
s2.s_id = "q1s2";
s2.reg_id = "Hillary";
s2.code = `
    function mySum(a, b) {
        return a + b;
    }
`;
s2.reg_date = "18/06/27";
db_solution.push(s2);

// s3
var s3 = Object.create(solution);
s3.s_id = "q2s3";
s3.reg_id = "Trump";
s3.code = `
    function myConcat(x, y) {
        return x + y;
    }
`;
s3.reg_date = "18/07/01";
db_solution.push(s3);

// s4
var s4 = Object.create(solution);
s4.s_id = "q2s4";
s4.reg_id = "Xi";
s4.code = `
    function myConcat(x, y) {
        var ret = x.push(y)
        return ret;
    }
`;
s4.reg_date = "18/06/25";
db_solution.push(s4);

// s5
var s5 = Object.create(solution);
s5.s_id = "q3s5";
s5.reg_id = "Hillary";
s5.code = `
    function myGugudan(x, y) {
        return 3*3;
    }
`;
s5.reg_date = "18/06/27";
db_solution.push(s5);

// s6
var s6 = Object.create(solution);
s6.s_id = "q3s6";
s6.reg_id = "Abe";
s6.code = `
    function myGugudan(x, y) {
        var ret = '';
        for (var i = 0; i <= 9) {
            ret += 9*1 + ", ";
        }
        return retsss;
    }
`;
s6.reg_date = "18/06/30";
db_solution.push(s6);


// ;;;check
console.log("(load) DB/solution.js");