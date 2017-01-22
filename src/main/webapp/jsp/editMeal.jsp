<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 21.01.2017
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="../css/mealstyle.css">
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
    <title>editMeal</title>
</head>

<body>
<h2>Редактирование блюда</h2>
<form method="post">
    <input type="hidden" name="id" value="${meal.id}"/>
    <table>
        <tr>
            <td>id</td>
            <td>${meal.id}</td>
        </tr>
        <tr>
            <td>Время</td>
            <td><input type="datetime-local" name="datetime" value="${meal.dateTime}"/></td>
        </tr>
        <tr>
            <td>Описание</td>
            <td><input type="text" name="description" value="${meal.description}"/></td>
        </tr>
        <tr>
            <td>Калорийность</td>
            <td><input type="number" name="cal" value="${meal.calories}"></td>
        </tr>
    </table>
    <button type="submit">Сохранить</button>
    <button onclick="window.history.back()">Отмена</button>
</form>

</body>
</html>
