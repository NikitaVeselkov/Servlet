<%@ page import="com.example.startservlet.logic.Model" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Servlets</title>
</head>
<body>




<h1>Домашняя страница по работе с пользователями </h1>
Введите ид пользователя (0 для вывода всего списка)
</br>
Доступно: <%
        Model model = Model.getInstance();
        out.print(model.getFromList().size());
                %>

<form method="get" action="get">

    <label>
        <input type="text" name="id"> </br>
    </label>
    <button type="submit" >Поиск</button>

    <a href="addUser.html">Создать нового пользователя</a>
    <a href="deleteUser.jsp">Удалить пользователя</a>

</form>


</body>
</html>