<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Client Order</title>
</head>
<body>


<form:form action="saveorder" modelAttribute="ClientRequestId">
    <br>
    Название фирмы:
    <form:input path="firm"/>
    <br>
    ИНН:
    <form:input path="innFirm"/>
    <br>
    Тип станка:
    <form:select path="idTypeMachine">
        <form:options items="${typeMachine}"/>
    </form:select>
    <br>
    Модель станка:
    <form:select path="idMachine">
        <form:options items="${modelMachine}"/>
    </form:select>
    <br>
    Серийный номер:
    <form:select path="idSerialNumber">
        <form:options items="${SerialNumberMachine}"/>
    </form:select>
    <br>
    ФИО:
    <form:input path="nameClient"/>
    <br>
    Номер телефона:
    <form:input path="phoneClient"/>
    <br>
    Описание проблемы:
    <form:input path="descProblem"/>
    <input type="submit" value="Отправить">

</form:form>



<%--<table>--%>
<%--    <tr>--%>
<%--        <th>Имя</th>--%>
<%--        <th>Фамилия</th>--%>
<%--        <th>Почта</th>--%>
<%--        <th>Телефон</th>--%>
<%--    </tr>--%>


<%--    <c:forEach var="emp" items="${allEmps}">--%>
<%--        <tr>--%>
<%--            <td>${emp.name}</td>--%>
<%--            <td>${emp.surname}</td>--%>
<%--            <td>${emp.email}</td>--%>
<%--            <td>${emp.phone}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

<%--</table>--%>

</body>
</html>