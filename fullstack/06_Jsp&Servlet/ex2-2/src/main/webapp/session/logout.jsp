<%--
  Created by IntelliJ IDEA.
  User: wha1e
  Date: 2025. 5. 29.
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate();
  response.sendRedirect("loginForm.html");
%>
