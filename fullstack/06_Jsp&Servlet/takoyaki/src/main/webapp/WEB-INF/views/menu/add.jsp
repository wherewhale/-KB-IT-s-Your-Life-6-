<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 6. 5.
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>🧂새 타코야끼 메뉴 추가</h1>
<form action="/menu/add" method="post">
  <ul style="list-style: none">
    <li>
      <label for="name">이름</label>
      <input type="text" id="name" name="name">
    </li>
    <li>
      <label for="price">가격</label>
      <input type="number" id="price" name="price">
    </li>
    <li><input type="submit" value="추가"></li>
  </ul>
</form>
<a href="/menu/list">📋메뉴판으로 돌아가기</a>
</body>
</html>
