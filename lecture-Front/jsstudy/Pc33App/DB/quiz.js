"use strict"

var quiz = {
    q_id: "",
    title: "",
    desc: "",
    contents: ""
};

var db_quiz = Array();

// q0
var q0 = Object.create(quiz);
q0.q_id = "q0";
q0.title = "hello world";
q0.desc = "void";
q0.contents = `
    function prt() {
         // writecode;
         return "hello world";
    };
    prt();
`;
db_quiz.push(q0);

// q1
var q1 = Object.create(quiz);
q1.q_id = "q1";
q1.title = "sum two number";
q1.desc = "two parameter/ return number/";
q1.contents = `
    function mySum(x, y) {
         // writecode;
         return 0; };
    mySum(2, 3);
`;
db_quiz.push(q1);

// q2
var q2 = Object.create(quiz);
q2.q_id = "q2";
q2.title = "concat string";
q2.desc = "two parameter/ return string/"
q2.contents = `
    function myConct(a, b) {
        // writecode; return '';
    };
    myConcat('Hello', 'World')
`;
db_quiz.push(q2);

// q3
var q3 = Object.create(quiz);
q3.q_id = "q3";
q3.title = "gugugugu";
q3.desc = "make gugudan/ one parameter/ return string/"
q3.contents = `
    function gugudan(a) {
        // writecode; return '';
    };
    gugudan(3);
`;
db_quiz.push(q3);

// ;;;check
console.log("(load) DB/quiz.js");