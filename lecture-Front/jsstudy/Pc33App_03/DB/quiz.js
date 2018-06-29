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
q0.title = "HelloWorld";
q0.desc = "void";
q0.contents = `
    function prt() {<br>
         // writecode;<br>
         return "hello world";<br>
    };<br>
    prt();<br>
`;
db_quiz.push(q0);

// q1
var q1 = Object.create(quiz);
q1.q_id = "q1";
q1.title = "숫자 더하기";
q1.desc = "two parameter/ return number/";
q1.contents = `
    function mySum(x, y) {<br>
         // writecode;<br>
         return 0; };<br>
    mySum(2, 3);<br>
`;
db_quiz.push(q1);

// q2
var q2 = Object.create(quiz);
q2.q_id = "q2";
q2.title = "문자열 더하기";
q2.desc = "two parameter/ return string/"
q2.contents = `
    function myConcat(a, b) {<br>
        // writecode;<br>
        return '';<br>
    };<br>
    myConcat('Hello', 'World');<br>
`;
db_quiz.push(q2);

// q3
var q3 = Object.create(quiz);
q3.q_id = "q3";
q3.title = "구구단";
q3.desc = "make gugudan/ one parameter/ return string/"
q3.contents = `
    function gugudan(a) {<br>
        // writecode; return '';<br>
    };<br>
    gugudan(3);<br>
`;
db_quiz.push(q3);

// ;;;check
console.log("(load) DB/quiz.js");