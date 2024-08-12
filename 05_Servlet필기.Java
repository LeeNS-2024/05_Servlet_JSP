[웹 개발 상식]

server : 기능을 제공하는 컴퓨터

Client : 기능을 요청하고 이용하는 고객 컴퓨터

        요청(Request) --->
Client                      server
        <--- 응답(Response)

-----------------------------------------------------

HTTP(Hyper Text Transfer Protocol)
- 서버 - 클라이언트 간의
  HTML 요청 - 응답 전송(전달)규약
  (인터넷에서 HTML을 주고 받을 때의 약속)

IP(Internet Protocol)
 : 인터넷/네트워크를 통해 데이터를 송수신하는 규약
  -> 인터넷/네트워크에 연결된 각종 통신기기를 구분하는 주소
     (컴퓨터, 휴대폰, 단말기 등등)

IPv6 주소 . . . . : fe80::29cf:6738:7e6c:a283%5
IPv4 주소 . . . . : 192.168.10.17

Port 번호 : 컴퓨터 내 프로그램을 구분하는 식별 번호

IP + Port 번호를 알아야
다른 컴퓨터(서버)에 요청을 할 수 있다
ex) http:// 192.168.10.5:8080


bin 에서 cmd 후 startup.bat
후 인터넷 에서 127.0.0.1:8080 or localhost:8080

제너럴 - show heap status
       - 아래 워크 스페이스 - refresh using native
font - 컬러 앤 폰트 - 베이직 - 맨 아래 text font

Runtime Environment -> Add -> Apache -> Apache Tomcat 10.1 선택 후 Next
압축 푼 아파치 선택


-------------------[Servlet]----------------------
클라이언트의 요청(Request)을 처리하고
그 결과를 다시 클라이언트에게 응답(Response)하는
Servlet클래스의 구현 규칙을 지킨 자바 프로그래밍 기술

브라우저 : HTML 해석 도구, 서버 요청

1. 클라이언트가 브라우저에 주소로 요청으로 보내면
2. 서버가 HTML로 응답을 해줘서
        - Servlet 이용
3. 클라이언트 브라우저가 이를 해석해서 화면에 출력해줌


[Servlet Container]
- 어떤 환경에서나 실행 하기 위해 필요한
  모든 요소를 포함 하는 소프트웨어 패키지

HTTP 포트 번호 중 80번
-http:/ / 요청시 80번 포트는 생략 가능!
  (참고 : jttps는 443번 생략 가능)

ex) http:/ /localhost:80
        == http:/ /localhost:

  - {Servlet 동작 방식(순서)}
  1.요청
  1. 객체 생성
  3. Servlet Class 찾기
  4. init() (initialize - 초기화)
  5. req, resp
  6. 응답

------------
vs 에
jsp , jstl 검색설치, 설정 - emmet 후 설정 include langueage jsp & html 추가
설정 - snippets - jsp 검색 후 복붙
---------------

[JSP(Java Server Page)] : Java 에서 html코드로 작성이 어려워
                        기본 작성법을 html로 바꿈

- 표기법은 HTML 이지만 컴파일 시 Servlet으로 변환되어짐
- (HTML 내부에 Java 코드를 작성하는 듯한 형태)

- scriptlet(<% %>, <%= %>), EL(${}), JSTL(<c:if>) 등으로 Java 코드를 표기

<%= %> = view 부분의 write 에서 "" 없이 표현 하게 하는것


- [JSP 동작 구조]
  jspFile.jsp ==> _jspFile.java ==> _jspFile.class

Servlet과 JSP 는 형태가 다르지만 같음




[작성 방법]
doGet, doPost 방식

// 1) 요청 위임할 JSP 경로 작성
//	  -> webapp 폴더를 "/" (최상위 폴더)로 생각하고 작성
String path = "/WEB-INF/views/sign_result.jsp";
		
// 2) 요청을 위임 시켜줄 객체 얻어오기
//     + 어디로 위임할지 매개 변수에 작성
//   -> RequestDispatcher(요청 발송자)
RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
// 3) HttpServletRequest/Response 두 객체를
//	  요청 위임(forward) 할 JSP 에서 넘기기
dispatcher.forward(req, resp);



 클라이언트가 서버로 요청을 하는 방법
      1) form 제출 (GET/POST)
      2) a 태그    (GET)
      3) JS - location.href = "주소"; (GET)
      4) JS - Ajax (GET/POST/PUT/DELETE)



------------------[JSTL(Jsp Standard Tag Library)]------------------

 JSP에서 자주 사용하는 Java 코드를
  (if, for, 변수 선언, String 관련 메서드 ....)


[EL/JSTL]

    브라우저 주소창에 서버 컴퓨터 주소(ip:port)만 작성하면

    index.jsp가 변환된 index_jsp.class(java.class) 파일로 요청이 매핑
    -> 클라이언트에게 index.jsp 코드가 그대로 출력됨

    index.html 과 index.jsp 차이
    html : html, css , js 코드 작성가능
          + 정적 페이지(미리 만들어진 형태 그래도)

    jsp  : html, css , js, el, jstl 작성가능
          + 동적 페이지(요청에 따라 응답 화면 변함 가능)

  [EL]

  - EL 구문 내 연산 시 parsing 자동으로 일어남


  - 파라미터 얻어오는 법
  1) ${param.key} -> String
  2) ${paramValues.key}  -> String[]

  - 데이터 유지 범위별 객체에 세팅된 속성 얻어오기


  page        ${pageValue.key}
  request     ${requestValue.key}
  session     ${sessionValue.key}
  apllication ${pllicationValue.key}

  if. ${key} 만 존재하는 경우
  ->좁은 범위의 객체부터 탐색하여
    일치하는 key가 있으면 출력


  -[EL의 특징]
    1. null을 빈칸("")으로 처리
    + NullPointerException을 발생시키지 않음!!

    2. get이라는 단어를 거의 사용하지 않는다!
      - EL은 표현(출력) 언어
        -> 값을대입하고, 조건/대입하는 구문을 작성x
          오로지 출력 (출력하려면 값을 얻어와야 되는게 당연한거라
          get 단어 사용 X)
          ex) ${book.getName()}

============================================

  -[JSTL]
    -Jsp Standard Tag Library
    - 아파치에서 JSP에서 자주 사용하는 Java 구문을
      태그 형태로 만들어서 제공해주는 라이브러리

    - 라이브러리 란?
      남들이 만들어서 준 클래스(코드)
      -> 제공해준 기능을 사용하면됨

    - JSTL을 사용하기위해서 해야하는것들
    1)라이브러리 다운로드
    2) webapp/WEB-INF/lib 폴더에 라이브러리 추가
    3) 사용하려는 JSP위에 <%@ taglib %> 작성

    - 변수 선언(범위 객체에 속성추가(setAttribute))
     <c:set var="" value="" scope="" />

    - 변수제거(removeAttribute)
      <c:remove var="" scope="" />

    - 단일 조건문(else 없음)
      <c:if test = "${}">

    - 연속된 조건문
      <c:choose>
        <c:when test="">
        </c:when>
      
        <c:otherwise>
        </c:otherwise>
      </c:choose>

    - 일반 for문 + 향상된 for문
      {향상}
    <c:forEach items="" var="">
    </c:forEach>

      {일반}
    <c:forEach var="" begin="" end="" step="" >
    </c:forEach>

    -문자열, 배열, 컬렉션 길이
      ${fn:length(문자열|배열|컬렉션)}

    - null 또는 비어있으면 true
    ${empty key|값}


  -{Servlet/JSP 범위별 내장 객체}

   Servlet/JSP에는 4종류 범위를 나타낸 내장 객체가 존재한다!
    -> 각 종류마다 영향을 끼치는 범위가 달라진다

      1. page (pageContext) : 현재 페이지
      -> 현재 JSP에서만 사용 가능한 객체(Servlet X)


      2. request (요청) == HttpServletRequest>
      -> 요청 받은 페이지(Servlet/JSP)와
      위임 받은 페이지(Servlet/JSP)에서 유지되는 객체


      3. session (입회, 접속)
      - session : 서버에 접속한 클라이언트를
                  나타내거나, 관련 정보를 get/set 할 수 있는 객체
                  (session 객체는 서버에서 관리함)
      
      - [중요!] session은 브라우저 마다 하나씩 생성된다!!!
      (새탭, 새창은 아님)

      - [유지 범위]
      사이트 접속 ~ 브라우저 종료 | 세션 만료

      - session이 유지되는 상태에서는 
      아무 곳에서나 가져다 사용할 수 있다!


    4. apllication (ServletContext) 
    - 하나의 웹 애플리케이션 마다 1개만 생성되는 객체
    (Server를 키면 1개만 생성되는 객체)

    - application 객체는 어디서든 사용 가능

    - [유지 범위]
    서버 실행 ~ 서버 종료

    5. 내장 객체의 우선 순위 :  page > request > session > application




[요청 처리]
		1. page scope -> JSP 에서만 확인 가능
		
		
		2. request scope
		- 요청 받은 Servlet/JSP와
		 요청이 위임된 Servlet/JSP에서 유지되는 객체
		
		* Servlet/JSP범위 객체에
		1) 값(속성) 추가하는 방법
		범위객체.setAttribute("key",value);
		
		2) 값(속성) 얻어오는 방법
	  Object 범위객체.getAttribute("key");
		 -> 반환형 Object -> 필요 시 다운 캐스팅 

    3. session(입회, 접속) scope
		 - 클라이언트가 서버에 첫 요청 시
			 서버 쪽에 생성되는 객체
		
		 - 클라이언트가 브라우저를 종료 하거나
			 지정된 세션 만료 시간이 지나면 사라짐
		   -> 위 상황이 아니면 계속 유지되는 객체

       1) session scope 객체 얻어오기

       2) session scope 객체에 값 세팅


  4. application scope
		 - 서버 전체에 1개만 존재하는 객체
			-> 모든 클라이언트가 공유  
		
		 - 서버 시작 시 생성, 서버 종료 시 소멸
		
		 1) application scope 객체 얻어오기
     2) 값 세팅

  5. 범위별 우선순위 확인
		 (좁은 범위가 우선순위가 높다!)
		 page > request > session > application
		
		 key 값을 동일하게하여 범위별 객체에 값 추가


-------------------------[c: 태그]-----------------------------

1. 변수 선언(== 속성 추가)  -  c:set 태그

  
    - 원하는 scope 객체에 값을 세팅할 수 있는 태그
      == 객체.setAttribute("key", value);
  
    [속성]
    1) var : 변수명(== key)

    2) value : 대입할 값(== value)

    3) scope : 범위 지정(page, request, session, application)
              -> 기본 값은 page

    <c:set var="num1" value="10" scope="page" />
    <h5>page - num1 : ${pageScope.num1}</h5>


2. 변수 제거(== 속성 제거) - c:remove 태그

  
    - scope 객체에 세팅된 속성을 제거하는 태그
     (== 객체.removeAttribute("key"))

    [속성]
    1) var : 변수명 (== key)

    2) scope : 범위 지정(page, request, session, application)
              -> 기본 값 : 전 범위 일괄 제거
    
    <c:remove var="test2" scope="session" />


3. 단일 조건문 - c:if

    - Java의 if문을 태그 형태로 만든 것

    * 주의사항 : else 구문이 없다!

    [속성]
    1) test : 조건식을 작성하는 속성

    - 작성법 1 : 대입되는 값은 무조건 EL 구문으로 작성!
    - 작성법 2 : 작성된 조건식의 결과는 무조건 T/F

  <%-- 쌍따옴표 안에 쌍따옴표가 들어갈 수 없어서 오류로 ' '사용 --%>
  <c:if test='${test3 == "숯불 닭갈비"}' >
    <h4>${test3} 맛있겠다</h4>
  </c:if>


4. 연속된 조건문 - c:choose, c:when, c:otherwise
- 주소창에 값 대입
  [c:choose 태그] 
  - 내부에 조건문 태그를 작성하겠다는 태그
    -> 내부에 c:when, c:otherwise 태그만 작성 가능!!
  
  * 주의 사항 *
    바로 한 단계 아래에는
    c:when, c:otherwise, 공백, jsp 주석만 작성할 수 있고
    나머진 모두 에러 발생!!

      [c:when]
      - if(조건식) / else if(조건식)를 나타내는 태그
        -> 조건식을 작성하는 속성은 [test]
      
      [c:otherwise]
      - else를 나타내는 태그
        -> 아무 속성도 없음!

        empty 연산자
        ${empty param.age}

      - EL에서 사용하는 연산자

      1) null 인 경우 true
      2) 연산 대상이 배열/컬렉션인데
         내부에 아무 요소도 없는 경우 true
      
      나머지는 false


5. 향상된 for문 + 추가 기능 - c:forEach

    - 일반 for + 추가 기능
    !forEach
    - 속성
    1) var   : 현재 반복 횟수에 해당하는 변수 (int i)
    2) begin : 반복 시 var 시작 값
    3) end   : 반복이 종료될 var 값
    4) step  : 반복 시 마다 var의 증가 값 (기본값 1)
    
    5) items : 반복 접근한 객체(배열, 컬렉션 객체)
    
    6) varStatus : 현재 반복 상태와 관련된 정보를 제공하는 변수 선언
    
      varStatus="변수명"
      -> c:forEach 구문 내에서 "변수명"을 통해 원하는 값을 얻을 수 있다.
    
      * varStatus에서 제공되는 값
      - current : 현재 반복 횟수(현재 var 값) 
      또는 현재 반복 접근 중인 객체(컬렉션/배열 요소)

      - index : 현재 인덱스값 반환 (0부터 시작)
      
      - count : 현재 몇바퀴째인지 반복 횟수 반환 (1부터 시작)
      
      - first : 첫 번째 반복이면 true, 아니면 false
      
      - last : 마지막 반복이면 true, 아니면 false

  5-1) 일반 for문 처럼 사용하기

  <p>1~6까지 1씩 증가하는 for문</p>

  <c:forEach var="i" begin="1" end="6" step="1" >
    ${i}
  </c:forEach>


  5-2) 일반 for문 + 컬렉션 List 사용하기
  
  nameList의 길이(저장된 데이터 개수) : ${fn:length(nameList)}



  ------------{forward와 redirect}----------

  -{forward : 요청 위임}
    - 클라이언트 요청을 받은 Servlet/JSP가
      직접 응답하는 것이 아닌
      다른 Servlet/JSP에 HttpServletRquest, HttpServletResponse
      객체를 넘겨서(위임) 대신 응답하게 하는 것

    - 요청 위임시
      RequestDispatcher(요청 발송자)를 이용

    - 요청 위임할 JSP ***"파일 경로"*** 작성

    - 응답 화면(결과 페이지) 주소는 
      처음 Servlet이 요청 받은 주소 그대로!


  -{redirect (redirection의 줄임말(재 요청, 다른 Servlet 요청))}

    - 클라이언트의 요청을 받은 Servlet/JSP에서
      직접 응답하지 않고 다른 Servlet/JSP를 다시 요청 하는 것

    - 보통 Servlet요청 처리 후
      특정 JSP로 요청을 위임해 결과 화면을 응답해 주는 것이 아닌
      (요청 받은 Servlet이 응답해줄 JSP가 없음)

      다른 Servlet을 다시 요청하여
      다른 Servlet의 결과 화면을 응답해줌

    - redirect는 다시 요청하는 것!!
      -> 기존 클라이언트의 req, resp 객체가 사라지고
        새로운 req, resp 객체가 생성된다!!
        -> request scope에 세팅된 값들이 모두 사라짐!!

    - redirect는 응답 화면의 주소가
      처음 요청한 Servlet 주소가 아닌
      다시 요청한 Servlet 주소로 변경된다 !!

    - 다른 Servlet을 요청하기 위해서는
      "요청 주소"를 작성해야 한다


