"use strict"

console.log("DB/quiz.js");

var q_id;
var title;
var description;
var contents;

var quiz = {
    q_id: "",
    title: "",
    desc: "",
    contents: ""
};

var db_quiz = Array();

var q1 = Object.create(quiz);
q1.q_id = "1";
q1.title = "sum two number";
q1.desc = "two parameter; return number;"
q1.contents = "function mySum(x, y) { // writecode; return 0; }; mysum(2, 3);"
db_quiz.push(q1);

var q2 = Object.create(quiz);
q2.q_id = "2";
q2.title = "concat string";
q2.desc = "two parameter; return string;"
q2.contents = "function myConct(a, b) { // writecode; return ''; }; myConcat('Hello', 'World')"
db_quiz.push(q2);

var q3 = Object.create(quiz);
q3.q_id = "3";
q3.title = "gugugugu";
q3.desc = "make gugudan; one parameter; return string;"
q3.contents = "function gugudan(a) { // writecode; return ''; }; gugudan(3)"
db_quiz.push(q3);

for (var e of db_quiz) {
    console.log(e);
}