<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>forward 결과 페이지</title>
</head>
<body>
  <h3>request scope 객체를 이용해서 잔달 받은 값</h3>

  <ul>
    <li>forward 입력1 : ${param.forwardInput1}</li>
    <li>forward 입력2 : ${param.forwardInput2}</li>
    <li>str : ${str}</li>
  </ul>


</body>
</html>