"use strict"

var canIUse = `<body>
    <h1 style="color: yellow; background-color: black">헤드라인 이지용!</h1>
    <h2 id="kms">헤드라인 이지용!</h2>
    <h3>헤드라인 이지용!</h3>
    <h4>헤드라인 이지용!</h4>
    <h5>헤드라인 이지용!</h5>
    <h6>헤드라인 이지용!</h6>
    <script>
    "use strict" // 조금 엄격하게 체크, 항상 습관적으로 제일 위에 쓸 것;

    // a();
    // function a() { alert("Hello World"); }

    // console.log("디버깅을 위해 꼭 필요");
    // alert("얘도 디버깅을 위해 꼭 필요");

    // window.document.write("<h1> WHO I AM!</h1>");
    // var aaa = true;

    // var kms = document.getElementById("kms");
    // alert(kms);
    // kms.innerHTML = "<h1>Handsome guy kms</h1>";

    // * EXAM
    var A = 44,
        B = 55;
    console.log(A, B);
    //A and B의 값을 추가 변수 선언없이 바꾸주세요.
    A = A + B;
    B = A - B;
    A = A - B;
    console.log(A, B);
    </script>
    <p> 여기에&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <br /> 여기에 글을 마구 쓰지용!
        <br /> 여기에 글을 마구 쓰지용!
        <br /> 여기에 글을 마구 쓰지용!
        <br /> 여기에 글을 마구 쓰지용!
        <br /> 여기에 글을 마구 쓰지용!
        <br /> 여기에 글을 마구 쓰지용!
        <br />
    </p>
    <ol>
        <li>아이테무1</li>
        <li>아이테무2</li>
        <li>아이테무3</li>
        <li>아이테무4</li>
        <li>아이테무5</li>
    </ol>
    <ul>
        <li>아이테무1</li>
        <li>아이테무2</li>
        <li>아이테무3</li>
        <li>아이테무4</li>
        <li>아이테무5</li>
    </ul>
</body>
<!-- *ref) caniuse.com 웹브라우저와 파일 호환성 체크 -->`;

var daumMapExam =`<body>
    <!--
    * Daum 지도 - 약도서비스
    * 한 페이지 내에 약도를 2개 이상 넣을 경우에는
    * 약도의 수 만큼 소스를 새로 생성, 삽입해야 합니다.
    -->
    <!-- 1. 약도 노드 -->
    <div id="daumRoughmapContainer1527207676344"
        class="root_daum_roughmap root_daum_roughmap_landing"></div>
    <!-- 2. 설치 스크립트 -->
    <script charset="UTF-8" class="daum_roughmap_loader_script"
        src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>
    <!-- 3. 실행 스크립트 -->
    <script charset="UTF-8">
    new daum.roughmap.Lander({
        "timestamp": "1527207676344",
        "key": "oapo",
        "mapWidth": "1000",
        "mapHeight": "500"
    }).render();
    </script>
</body>`;

var divExam =`<body>
    <h1>div exam</h1>
    <!-- 레이어 형식, z-index를 이용하여 레이어 순서 설정 -->
    <div style="position: absolute; z-index: 999;
		left: 30px; top:80px; height: 100px; background-color: yellow;">AAA</div>
    <div style="position: absolute; z-index:988;
		left:50px; top:80px; height: 100px; background-color: green;">BBB</div>
    <div style="position: absolute; z-index: 977;
		left:70px; top:80px; height: 100px; background-color: purple;">CCC</div>
</body>`;

var mainTo = `<body>
    <pre>
        <b> Hello </b>
        <i> I am free</i>
        <strong>Many many</strong>
        <em>This is</em>
        <code>An apple</code>
        <sup>I hate</sup>
        <sub>Love song</sub>
    </pre>
    <hr /> 작거나 표시&lt; 크거나 표시&gt; 쿼테이션&quot; 앰퍼센드 &amp;
</body>
<dl>
    <dt>에스프레소</dt>
    <dd>- 커피의 기본, 커피의 원액이다.</dd>
    <dt>아메리카노</dt>
    <dd>- 에스프레소에 물을 넣은 것</dd>
    <dt>카페라떼</dt>
    <dd>- 커피에 우유를 섞은 것</dd>
</dl>
<a href="https://google.com" target="_blank">gogo google</a>
<br>
<a href="#section1">참고 사항으로 가려면 여기를 클릭하세요.</a>
<p> Hello World!</p>
<p> Hello World!</p>
<p> Hello World!</p>
<br>
<br>
<hr>
<a id="section1">참고 사항</a>
<hr>
<p> 동일한 페이지 안에서도 점프할 수 있습니다. </p>
<a href="mailto:hong@naver.com">hong@naver.com</a>
<br>
<img src="./image/Canon.png" width=600 height=600 alt="Canon_Camera_Image">`;

var media = `<body>
    <h2>audio</h2>
    <audio src="../media/horse.mp3" autoplay controls>
        Your browser does not support the audio element.
    </audio>
    <br>
    <h2>video</h2>
    <video src="../media/Casino.mp4" width=400 height=200 muted autoplay controls>
        Your browser does not support the audio element.
    </video>
    <h2> * iframe - ssam/jsstudy</h2>
    <iframe src="../http://192.168.20.2/jsstudy"
		width="700" height="500" frameborder="0"></iframe>
</body>`;

var tableExam = `<body>
    <!-- Table 01 -->
    <h2>Table 01</h2>
    <table border="2">
        <tr>
            <th>Title1</th>
            <th>Title1</th>
            <th>Title1</th>
        </tr>
        <tr>
            <td colspan="2">Nayong1</td>
            <td rowspan="2">Nayong1</td>
        </tr>
        <tr>
            <td rowspan="2">Nayong1</td>
            <td>Nayong1</td>
        </tr>
        <tr>
            <td>Nayong1</td>
            <td>Nayong1</td>
        </tr>
        <tr>
            <td>Nayong1</td>
            <td>Nayong1</td>
            <td>Nayong1</td>
        </tr>
    </table>
    <!-- Table 02 -->
    <h2>Table 02</h2>
    <table border="2">
        <tr>
            <th>Header</th>
            <th>Header</th>
            <th>Header</th>
            <th>Header</th>
            <th>Header</th>
            <th>Header</th>
        </tr>
        <tr>
            <td colspan="2">Data</td>
            <td colspan="2">Data</td>
            <td>Data</td>
            <td>Data</td>
        </tr>
        <tr>
            <td colspan="4">Data</td>
            <td colspan="2">Data</td>
        </tr>
        <tr>
            <td colspan="4">Data</td>
            <td colspan="2" rowspan="2">Data</td>
        </tr>
        <tr>
            <td>Data</td>
            <td>Data</td>
            <td>Data</td>
            <td>Data</td>
        </tr>
    </table>
    <pre>
        먼저 정체 행/열수로 테이블로 만든다.
        colspan=숫자를 적용하면 옆에서 (숫자-1) 만큼 지운다.
        rwospan=숫자를 적요하면 아래 tr에서 (숫자-1) 만큼 를 지운다.
    </pre>
</body>`;

var variable = `<body>
    <script>
    "use strict"

    // 변수 선언법 var만 붙이면 OK, type 신경안씀
    var js_num = 100; // 숫자 선언
    var js_str = "Hello I am JaeSeok." // 문자열 선언
    var js_bool = true; // 불리언 선언
    var js_null = null; // 널
    var js_undef; // 선언만..
    var js_obj = {}; // 오브젝트
    var js_arr = [1, 2, 3]; // 배열

    document.write(this + "<br>"); // this는 window - 곧 브라우저 객체
    document.write(js_num + "<br>");
    document.write(window.js_num + "<br>"); // 선언ㅇ한 변수가 window 속성이 되어 있다

    // 반복문
    var js_max = 10;
    var js_sum = 0; // 초기값은 항상 주는 습관
    for (var i = 1; i < js_max; i++) {
        js_sum += i;
    }
    document.write("js_sum = " + js_sum);
    </script>
</body>`;
