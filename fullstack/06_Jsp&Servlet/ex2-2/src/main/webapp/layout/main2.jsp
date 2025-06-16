<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 5. 29.
  Time: 오후 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>include 액션 실습</title>
</head>
<body>
<h1>include 태그 실습</h1>
현재 시간을 구하는 예제입니다. 다음줄에 삽입이 됩니다. <br>
<jsp:include page="header.jsp" flush="true" >
  <jsp:param name="nickName" value="Mr Hong" />
</jsp:include>
</body>
</html>
