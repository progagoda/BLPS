<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Главная</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
      <h4><a href="/login">Войти</a></h4>
      <h4><a href="/registration">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
      <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>
    <div class = "container">
        <h2>Video streaming</h2>
        <video src="video/1" width="720px" height="480px" controls preload="none">
        </video>
    </div>

  <form:form method="POST" modelAttribute="commentForm">
    <h2>Оставить комментарий</h2>
    <div>
      <textarea type="text" cols="40" rows="5" name="comment" id="comment" path="comment" placeholder="Comment..." style="width: 480px; height: 200px"
                  autofocus="false"></textarea>
      <form:errors path="commentErrors"></form:errors>
        ${commentError}
    </div>
    <button type="submit">Отправить</button>
  </form:form>
</body>
</html>