<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 6. 11.
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>설문 결과 이미지 업로드</h1>
    <p>캡처된 이미지로 GPT에게 결과 요약을 요청해보세요.</p>

    <form  action="/survey/upload" method="post"  enctype="multipart/form-data">
        <input type="hidden" name="id" value="${id}"/>
        <span>이미지 파일 : </span><input type="file" name="file"/><br/>
        <input type="submit" value="업로드">
    </form>
</body>
</html>
