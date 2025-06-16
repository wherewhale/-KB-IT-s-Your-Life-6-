<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 6. 11.
  Time: 오전 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>나만의 설문 유도 페이지 만들기</h1>
<form action="/survey" method="post">
    <label for="name">이름</label>
    <input id="name" name="name">
    <br/>
    <label for="link">설문 링크</label>
    <input id="link" name="link">
    <br/>
    <label for="comment">멘트</label>
    <input id="comment" name="comment">
    <input type="submit" value="공유 페이지 생성">
</form>

</body>
</html>
