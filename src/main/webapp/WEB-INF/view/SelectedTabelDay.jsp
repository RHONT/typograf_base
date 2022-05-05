<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table>
    <tr>
        <th>Номер заказа</th>
        <th>Имя</th>
        <th>Дата визита</th>
        <th>Старт работы</th>
        <th>Время работы</th>
    </tr>


    <c:forEach var="listTabel" items="${listWork}">
        <tr>
            <td>${listTabel.idClientRequest.firm}</td>
            <td>${listTabel.idEmployee.name}</td>
            <td>${listTabel.dateVisit}</td>
            <td>${listTabel.timeStart}</td>
            <td>${listTabel.laidDownTime}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>