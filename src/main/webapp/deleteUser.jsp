<%@ page import="com.example.startservlet.logic.Model" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Удаление пользователя</title>

</head>
<body>
<form method="get" action="delete">

  <label> Введите ID пользователя:
    <input type="text" name="id">
  </label>
  </br>


  <button type="submit">Удалить</button>

</form>

<a href="index.jsp">Домой </a>;

</body>
</html>