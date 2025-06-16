<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 6. 5.
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>📋오늘의 메뉴판</h1>
<div>
    <ul>
        <c:forEach var="menu" items="${menuList}">
<li>
    ${menu.name} - ${menu.price}원
</li>
        </c:forEach>
    </ul>

    <a href="/menu/add">🧂메뉴 추가</a>
    <br/>
  <a href="/">🏠돌아가기</a>
</div>

</body>
</html>
