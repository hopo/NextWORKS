
"use strict"


/*
 * BACKGROUND
 */

var imgs = [];
for (var i = 0; i <= 10; i++) {
    imgs[i] = "../image/tiger" + i + ".jpg";
}

var count = 0;
function chgBgImg() {
    count++;
    if (count == 100) {
        count = 0;
        var rand = Math.floor(Math.random() * 11);
        document.styleSheets[0].cssRules[0].style.backgroundImage = "url(" + imgs[rand] + ")";
    }
}



/*
 * BALL
 */

var ting_ball = document.getElementById("tingBall");
var ting_ball_style = document.styleSheets[0].cssRules[2].style;
var move_hor = 10;   // ;수평 정보
var move_ver = 10;   // ;수직 정보   
var move_angle = 0;

function moveBall() {
    chgBgImg(); // ;배경 바꾸기
    if (parseInt(ting_ball_style.top) > 700) {  // ;공의 종료 시점
        ting_ball_style.top = "-150px";
        document.styleSheets[0].cssRules[3].style.backgroundColor = "gray";
        bottomBlock.innerHTML = "<h1> FAILED </h1>";
        clearTimeout(coll_t);
    } else {
        move_angle = (move_angle % 360) + 10;
        ting_ball_style.transform = "rotate(" + move_angle + "deg)";
        ting_ball_style.left = (parseInt(ting_ball_style.left) + move_hor) + "px";
        ting_ball_style.top = (parseInt(ting_ball_style.top) + move_ver) + "px";
        setTimeout(moveBall, 50);
    }
}



/*
 * COLLISION
 */

var coll_t;

function collisionBall() {
    if (parseInt(ting_ball_style.left) >= 895 || parseInt(ting_ball_style.left) <= 0) {
        move_angle = (move_angle % 360) + 10;
        ting_ball_style.transform = "rotate(" + move_angle + "deg) skew(30deg)";
        move_hor = -move_hor;
    }
    if (parseInt(ting_ball_style.top) <= 10) {
        move_angle = (move_angle % 360) + 10;
        ting_ball_style.transform = "rotate(" + move_angle + "deg) skew(30deg)";
        move_ver = -move_ver;
    }

    var ballVerticalPos = parseInt(ting_ball_style.top) + 100;
    var ballHorizonPos = parseInt(ting_ball_style.left);
    var barHorizonPos = parseInt(row_bar_style.left);

    if (ballVerticalPos > 650) {
        if ((ballHorizonPos > barHorizonPos - 100) && (ballHorizonPos < barHorizonPos + 100)) {
            ting_ball_style.transform = "rotate(" + move_angle + "deg) skew(30deg)";
            move_ver = -move_ver;
        }
    }
    coll_t = setTimeout(collisionBall, 50);
}



/* 
 * BAR 
 */

// ! 바를 컨트롤 하기 위한 베리어블
// var row_bar = document.getElementById("rowBar");
var row_bar_style = document.styleSheets[0].cssRules[1].style;

// ! 누르는 키에 따른 바 이동 이벤트핸들러
window.onkeydown = function moveBar(evt) {
    evt = evt || window.event;
    var keyValue = evt.keyCode || evt.which;

    switch (keyValue) {
        case 37:
            if (parseInt(row_bar_style.left) <= 0) {
                row_bar_style.left = "7px";
            }
            row_bar_style.left = (parseInt(row_bar_style.left) - 20) + "px";
            break;
        case 39:
            if (parseInt(row_bar_style.left) >= 845) {
                row_bar_style.left = "840px";
            }
            row_bar_style.left = (parseInt(row_bar_style.left) + 20) + "px";
            break;
    }
}



/*
 * MAIN
 */

// ! 시작 펑션
function initStart() {
    var ran_left = Math.floor(Math.random() * 800 + 50);
    ting_ball_style.left = ran_left + "px";
    ting_ball_style.top = "11px";

    moveBall(); // 공의 이동
    collisionBall(); // 공의 충돌
}

// ! 윈도우가 열리면 시작되는 펑션
window.onload = initStart();
