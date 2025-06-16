<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 6. 5.
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<title>Title</title>
<h1>Todo 보기</h1>
<div>
  <a href="list">목록보기</a> |
  <a href="update">수정하기</a>
</div>
<form action="delete" method="POST">
  <input type="submit" value="삭제">
</form>
</body>
</html>