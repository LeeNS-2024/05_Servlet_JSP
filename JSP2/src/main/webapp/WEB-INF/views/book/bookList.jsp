<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>책 목록 조회</title>
  <%-- webapp폴더를 기분(/)으로 css 파일 경로 작성 --%>
  <link rel="stylesheet" href="/resources/css/book.css">

</head>
<body>
  <h1>책 목록 조회</h1>

  <hr>
  <h3>전체 책 수량 : ${fn:length(bookList)}권 </h3>
  <hr>

  <table border="1">
    <thead>
      <tr>
        <th>번호</th>    
        <th>제목</th>    
        <th>저자</th>    
        <th>가격(원)</th>    
      </tr>
    </thead>

    <tbody>

    <c:forEach items="${bookList}" var="book" varStatus="vs">
      <tr>
        <th>${vs.count}</th>
        <td>${book.title}</td>
        <td>${book.writer}</td>
        <td>${book.price}</td>
      </tr>

      <c:if test="${vs.count % 3 == 0}">
        <tr>
          <td colspan= "4" class="blank">&nbsp;</td>
        </tr>
      </c:if>

    </c:forEach>

    </tbody>

  </table>

  <button id="btn">js 테스트</button>

  <%-- webapp폴더를 기분(/)으로 css 파일 경로 작성 --%>
  <script src="/resources/js/book.js"></script>
</body>
</html>