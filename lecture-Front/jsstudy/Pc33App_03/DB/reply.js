"use strict"

var reply = {
    r_id: "",
    reg_id: "",
    repl: "",
    reg_date: ""
}

var db_reply = Array();

// r0
var r0 = Object.create(reply);
r0.r_id = "s0r0";
r0.reg_id = "Amber";
r0.repl = "GOOD";
r0.reg_date = "18/07/11";
db_reply.push(r0);

// r1
var r1 = Object.create(reply);
r1.r_id = "s1r1";
r1.reg_id = "GD";
r1.repl = "awsome code!";
r1.reg_date = "18/07/01";
db_reply.push(r1);

// r2
var r2 = Object.create(reply);
r2.r_id = "s1r2";
r2.reg_id = "Simin";
r2.repl = "shit. code is shit.";
r2.reg_date = "18/07/03";
db_reply.push(r2);

// r3
var r3 = Object.create(reply);
r3.r_id = "s2r3";
r3.reg_id = "Amber";
r3.repl = "beutiful code";
r3.reg_date = "18/07/13";
db_reply.push(r3);

// r4
var r4 = Object.create(reply);
r4.r_id = "s2r4";
r4.reg_id = "Sully";
r4.repl = "watasiwa akumda.";
r4.reg_date = "18/07/01";
db_reply.push(r4);

// r5
var r5 = Object.create(reply);
r5.r_id = "s2r5";
r5.reg_id = "Akiyama";
r5.repl = "merong";
r5.reg_date = "18/07/03";
db_reply.push(r5);

// r6
var r6 = Object.create(reply);
r6.r_id = "s3r6";
r6.reg_id = "Messi";
r6.repl = "beutiful code";
r6.reg_date = "18/07/11";
db_reply.push(r6);

// r7
var r7 = Object.create(reply);
r7.r_id = "s5r7";
r7.reg_id = "GD";
r7.repl = "awsome code!";
r7.reg_date = "18/07/01";
db_reply.push(r7);

// r8
var r8 = Object.create(reply);
r8.r_id = "s5r8";
r8.reg_id = "Simin";
r8.repl = "Oh!";
r8.reg_date = "18/07/03";
db_reply.push(r8);

// r9
var r9 = Object.create(reply);
r9.r_id = "s6r9";
r9.reg_id = "Amber";
r9.repl = "Nu A B O";
r9.reg_date = "18/07/13";
db_reply.push(r9);

// ;;;check
console.log("(load) DB/reply.js");