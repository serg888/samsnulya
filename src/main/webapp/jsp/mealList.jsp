<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page import="ru.javawebinar.topjava.util.ThreadSafeCounter" %><%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 21.01.2017
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="../css/mealstyle.css">
    <title>мой mealList</title>
</head>
<body>
<a href="/">Назад</a>
<p>
    <a href="/meals?action=new">Создать новое</a> </td>
</p>

<table>
<tr>
    <th>id</th>
    <th>Дата</th>
    <th>Описание</th>
    <th>кал.</th>
</tr>
    <c:forEach items="${mealsList}" var="meals">
        <jsp:useBean id="meals" type="ru.javawebinar.topjava.model.MealWithExceed"/>
        <tr class="${meals.exceed?'exceed':'notexceed'}">
            <td>${meals.id}</td>
            <td><%=TimeUtil.dtToString(meals.getDateTime())%></td>
            <td>${meals.description}</td>
            <td>${meals.calories}</td>
            <td><a href="/meals?id=${meals.id}&action=edit">ред.</a> </td>
            <td><a href="/meals?id=${meals.id}&action=delete">del</a> </td>
        </tr>


    </c:forEach>

</table>
</body>
</html>
