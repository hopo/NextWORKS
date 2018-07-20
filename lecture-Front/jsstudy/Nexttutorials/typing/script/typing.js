"use strict"

/*
 * =====================================================
 * Author : 272
 * =====================================================
 */


var movTime = 900; //글자Div 움직이게 부르는 간격
var makeTime = 1700; //글자Div 화면에 나타나게 추가하는 시간
var tajaStart = null;
var tajaTyping = null;

var score = 1;
var scoreBoardDiv = document.getElementById("scoreBoard");

// 자바script 공부!
var jsWordsStr = `abstract    arguments   boolean break   byte    case    catch char    class   const   continue
default delete  do double  else    enum    eval export  extends false   final finally float   for function
goto    if  implements  import in  instanceof  int interface let    long    new null  package private protected
public  return  short   static super  switch  synchronized    this throw   throws  transient   true
try typeof  var void volatile    while   with    yield Array   Date    eval    function Infinity    
length  Math    NaN name    Number  Object  prototype String  toString    undefined   valueOf alert   all anchor  anchors
area    assign  blur    button checkbox    clearInterval close   closed  confirm constructor decodeURI
document    element embed encodeURI   escape event   fileUpload  focus   form
frame   innerHeight innerWidth layer   link    location navigate    frames
frameRate   hidden  history image open    option  outerWidth  packages parent  parseFloat
parseInt    password    plugin prompt  radio   reset screenX screenY scroll  
select  self    setInterval setTimeout status  submit  text textarea    top 
window onblur  onclick onerror onfocus onkeydown   onkeypress  onkeyup
onmouseover onload  onmouseup   onmousedown onsubmit 272`;

var javaStudy = jsWordsStr.split(/\W+/);

var onDiv = []; // 현재 화면에서 움직이는 div만 담을 배열

/** javaStudy 배열에서 단어 뽑아 화면에 보이기 **/
function wordsManufacture() {

    var wordRanId = Math.round(Math.random() * (javaStudy.length - 1));
    var wordRanX = Math.round(Math.random() * 500);
    var newDiv = document.getElementById("word" + wordRanId);
    var wordWidth = newDiv.innerHTML.length * 11;

    newDiv.style.width = wordWidth + "px";
    newDiv.style.left = wordRanX + "px";
    newDiv.style.display = "block";
    onDiv.push(newDiv);
    tout = setTimeout(wordsManufacture, makeTime);
}

/** 뽑은 단어 움직이기 **/
var tout = null;
var tout2 = null;

function wordsMove() {
    for (var i = 0; i < onDiv.length; i++) {
        if (onDiv[i] == "") {
            continue;
        }

        var speed = Math.round(Math.random() * 20) + 1;
        if (!onDiv[i].style.top) {
            onDiv[i].style.top = "-30px"; //이런 경우 잘 디버깅하면 굳!
        }

        onDiv[i].style.top = (parseInt(onDiv[i].style.top) + speed) + "px";
        if (parseInt(onDiv[i].style.top) > 430) {
            onDiv[i].style.display = "none";
            onDiv[i].style.top = "-30px";
            onDiv[i] = "";
        }
    }

    tout2 = setTimeout(wordsMove, movTime);
}

/** 시작 함수로 글자만드는 함수와 글자 움직임함수 불러줌! **/
function tajaGoGo() {
    // var bg = document.styleSheets[0].cssRules[0];

    tajaBackground.style.backgroundColor = "#eeffee";

    wordsManufacture();
    wordsMove();
}


/** 엔터키 입력하면 처리~ **/
function wordsCheck() {
    var tajaTyping = document.getElementById("tajaTyping");
    var wordAnswer = tajaTyping.value;
    if (event.keyCode == 13) {
        for (var i = 0; i < onDiv.length; i++) {
            if (onDiv[i] == "") {
                continue;
            }
            if (onDiv[i].innerHTML == wordAnswer) {
                onDiv[i].style.display = "none";
                onDiv[i].style.top = "-30px";
                onDiv[i] = "";
                scoreBoard.textContent = score++;
                if(score == 272) {
                    alert('****** 272 ******');
                }
            }
        }
        tajaTyping.value = "";
    }
}

/**javaStudy 배열 만큼 div 태그 만들고,
시작 클릭과, 엔터키 입력 이벤트  함수에 연결 **/
function tajaInit() {
    var tajaBackground = document.getElementById("tajaBackground");
    var tajaTyping = document.getElementById("tajaTyping");
    var tajaStart = document.getElementById("tajaStart");

    var movDiv = "";
    for (var i = 0; i < javaStudy.length; i++) {
        movDiv = movDiv + "<DIV id=word" + i + " class=txtBox >" + javaStudy[i] + "</div>";
    }
    tajaBackground.innerHTML = movDiv;
    tajaStart.focus();
}

function tajaStop() {
    clearTimeout(tout);
    clearTimeout(tout2);

    // var bg = document.styleSheets[0].cssRules[0];
    tajaBackground.style.backgroundColor = "gray";

    for (var e of onDiv) {
        e.style.top = "-30px";
    }

}