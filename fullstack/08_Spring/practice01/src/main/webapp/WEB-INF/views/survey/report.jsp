<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 6. 11.
  Time: 오후 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${survey.name}님의 설문에 참여해주세요!</h1>
<p>한마디 : ${survey.comment}</p>
<span>설문 링크 : </span><a href=${survey.link}>${survey.link}</a>
<hr/>
<p>
    링크를 복사하여 공유하거나, 다른 친구들도 참여할 수 있도록 유도해보세요~!
</p>
<hr/>
<h4>업로드한 설문 결과 이미지</h4>
<img src="${imagePath}" />
<a href="/survey/upload?id=${id}">
    다른 설문 등록하기
</a>
</body>
</html>

