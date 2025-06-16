<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 6. 4.
  Time: 오후 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${lastSnack != null}">
    <p>
        <b>최근에 고른 간식: ${lastSnack}</b>
    </p>
    이 간식을 다시 드셔보는 건 어떠세요?

</c:if>
<br/>
<br/>
<c:if test="${visitTime != null}">
    최근 방문 시간: ${visitTime}
</c:if>


<h1>🍪우리 반 인기 간식 투표</h1>
<form action="/vote-submit" method="post">
    <fieldset>
    <legend>좋아하는 간식을 하나 골라주세요.</legend>
    <label>
        <input type="radio" name="snack" value="와사비과자">
        와사비과자
    </label>
    <br/>
    <label>
        <input type="radio" name="snack" value="붕어빵">
        붕어빵
    </label>
    <br/>
    <label>
        <input type="radio" name="snack" value="쿠쉬쿠쉬">
        쿠쉬쿠쉬
    </label>
        <br/>
    <label>
        <input type="radio" name="snack" value="초코하임">
        초코하임
    </label>
        <br/>
    <label>
        <input type="radio" name="snack" value="몽쉘">
        몽쉘
    </label>
        <br/>
    <label>
        <input type="radio" name="snack" value="카스타드">
        카스타드
    </label>
        <br/>
    <label>
        <input type="radio" name="snack" value="쿠크다스">
        쿠크다스
    </label>
        <br/>
    <label>
        <input type="radio" name="snack" value="초코파이">
        초코파이
    </label>
        <br/>
    <label>
        <input type="radio" name="snack" value="꿀꽈배기">
        꿀꽈배기
    </label>
        <br/>
        <br/>
        <br/>
        <button type="submit">투표하기</button>
    </fieldset>
</form>
<form action="reset" method="get">
    <button type="submit">초기화</button>
</form>
</body>
</html>
