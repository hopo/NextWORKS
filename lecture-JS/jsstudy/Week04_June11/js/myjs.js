"use strict"

var h1_el = document.getElementById("test");

h1_el.style.backgroundColor = "pink";
// h1_el.style["backgroundColor"] ="pink";

console.log('01: ', window.navigator.userAgent); // ;브라우저 정보 알 수 있다
console.log('02: ', window.location.href);

// window.location.href = "http://nextit.or.kr"; // ;값을 넣을 수 도 있디.
// location.replace("http://nextit.or.kr"); // ;refresh! (갱신이 된따)