<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 6. 5.
  Time: 오후 5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>손놈이 주문하러 왔어요!</h1>
<p>"${randomMenu.name}"</p>
<p>${randomMenu.price}원</p>
<p>주문합니다.</p>
<form action="/order/confirm" method="post">
    <input type="hidden" name="menuName" value="${randomMenu.name}" />
    <input type="hidden" name="price" value="${randomMenu.price}" />
    <button type="submit">주문 확정</button>
</form>
</body>
</html>
