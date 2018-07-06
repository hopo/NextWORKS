
"use strict"


// ============================================================================
// DB quiz
// ============================================================================

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
q0.desc = "문자열 'HelloWorld'를 출력하시오";
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
q1.desc = "입력 받은 두 수의 합을 구하시오";
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
q2.desc = "문자열 둘을 입력 받아 합쳐서 하나의 문자열로 반환하시오";
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
q3.title = "구구단 만들기";
q3.desc = "구구단 고고고";
q3.contents = `
    function gugudan(a) {<br>
        // writecode; return '';<br>
    };<br>
    gugudan(3);<br>
`;
db_quiz.push(q3);



// ============================================================================
// DB solution
// ============================================================================

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
    function mySum(x, y) {<br>
        return x + y;
    }<br>
`;
s1.reg_date = "18/06/25";
db_solution.push(s1);

// s2
var s2 = Object.create(solution);
s2.s_id = "q1s2";
s2.reg_id = "Hillary";
s2.code = `
    function mySum(a, b) {<br>
        var x = "";<br>
        var y = "";<br>
        var tmp = "";<br>
        x = tmp;<br>
        tmp = y;<br>
        y = x;<br>
        return a + b;<br>
    }<br>
`;
s2.reg_date = "18/06/27";
db_solution.push(s2);

// s3
var s3 = Object.create(solution);
s3.s_id = "q2s3";
s3.reg_id = "Trump";
s3.code = `
    function myConcat(x, y) {<br>
        ls = Array();<br>
        for (var x of ls) {<br>
            console.log(x);<br>
        }<br>
        return x + y;<br>
    }<br>
`;
s3.reg_date = "18/07/01";
db_solution.push(s3);

// s4
var s4 = Object.create(solution);
s4.s_id = "q2s4";
s4.reg_id = "Xi";
s4.code = `
    function myConcat(x, y) {<br>
        var ret = x.push(y);<br>
        if (ret != null) {<br>
            console.log("format c:");<br>
        }<br>
        return ret;<br>
    }<br>
`;
s4.reg_date = "18/06/25";
db_solution.push(s4);

// s5
var s5 = Object.create(solution);
s5.s_id = "q3s5";
s5.reg_id = "Hillary";
s5.code = `
    function myGugudan(x, y) {<br>
        import java.util.*;<br>
        return 3*3;<br>
    }<br>
`;
s5.reg_date = "18/06/27";
db_solution.push(s5);

// s6
var s6 = Object.create(solution);
s6.s_id = "q3s6";
s6.reg_id = "Abe";
s6.code = `
    function myGugudan(x, y) {<br>
        var ret = '';<br>
        for (var i = 0; i <= 9) {<br>
            ret += 9*1 + ", ";<br>
        }<br>
        return retsss;<br>
    }<br>
`;
s6.reg_date = "18/06/30";
db_solution.push(s6);



// ============================================================================
// DB reply
// ============================================================================

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
r0.repl = "좋아요!";
r0.reg_date = "18/07/11";
db_reply.push(r0);

// r1
var r1 = Object.create(reply);
r1.r_id = "s1r1";
r1.reg_id = "GD";
r1.repl = "멋진 코드네요!";
r1.reg_date = "18/07/01";
db_reply.push(r1);

// r2
var r2 = Object.create(reply);
r2.r_id = "s1r2";
r2.reg_id = "Simin";
r2.repl = "형편없는 코드군요...ㅉㅉ";
r2.reg_date = "18/07/03";
db_reply.push(r2);

// r3
var r3 = Object.create(reply);
r3.r_id = "s2r3";
r3.reg_id = "Amber";
r3.repl = "쩔어.";
r3.reg_date = "18/07/13";
db_reply.push(r3);

// r4
var r4 = Object.create(reply);
r4.r_id = "s2r4";
r4.reg_id = "Sully";
r4.repl = "와따시와아쿠마다";
r4.reg_date = "18/07/01";
db_reply.push(r4);

// r5
var r5 = Object.create(reply);
r5.r_id = "s2r5";
r5.reg_id = "Akiyama";
r5.repl = "컴퓨터 얼마 주고 사셨나요???";
r5.reg_date = "18/07/03";
db_reply.push(r5);

// r6
var r6 = Object.create(reply);
r6.r_id = "s3r6";
r6.reg_id = "Messi";
r6.repl = "4885 너지?!";
r6.reg_date = "18/07/11";
db_reply.push(r6);

// r7
var r7 = Object.create(reply);
r7.r_id = "s5r7";
r7.reg_id = "GD";
r7.repl = "누가 기침을 하였느냐";
r7.reg_date = "18/07/01";
db_reply.push(r7);

// r8
var r8 = Object.create(reply);
r8.r_id = "s5r8";
r8.reg_id = "Simin";
r8.repl = "$$$$$ 쉽게 돈버는 방법 www.showmethemoney.com $$$$$$";
r8.reg_date = "18/07/03";
db_reply.push(r8);

// r9
var r9 = Object.create(reply);
r9.r_id = "s6r9";
r9.reg_id = "Amber";
r9.repl = "지구망해라!";
r9.reg_date = "18/07/13";
db_reply.push(r9);

