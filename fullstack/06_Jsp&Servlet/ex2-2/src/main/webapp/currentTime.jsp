<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 5. 29.
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>스크립트릿 실습</title>
</head>
<body>
<h1>현재 날짜 출력 실습</h1>
<%
  Date d = new Date();
  Date d2 = null;
%>
<%--d2가 null일 때, null이라는 문자가 출력된다. 이를 해결하려면 조건문을 넣어주어야 하는데 매우 불편하다.--%>
<%--d3는 없는 변수이기 때문에 에러가 발생함.--%>
현재 날짜 : <%= d %>, <%= d2%> <%= d3%>
</body>
</html>
