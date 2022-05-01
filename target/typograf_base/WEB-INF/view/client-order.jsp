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
<body bgcolor="#d0d0d0">

<div style="text-align: center;"><h1>Оставьте заявку <br> Мы вас скоро наберем</h1></div>
<br>
<form:form action="saveorder" modelAttribute="ClientRequestId" acceptCharset="utf-8">
    <table>
        <tr><td>Ваша организация:</td><td><form:input path="firm" title="Введите название"/></td></tr>
        <tr><td> ИНН:</td><td><form:input path="innFirm"/></td></tr>

        <tr><td>Тип станка:</td><td>
    <form:select path="idTypeMachine"  >
        <form:options items="${typeMachine}"/>
    </form:select>
        </td></tr>

        <tr><td>Модель станка:</td><td>
            <form:select path="idMachine">
                <form:options items="${modelMachine}"/>
            </form:select>
        </td></tr>

        <tr><td>Серийный номер:</td><td>
            <form:select path="idSerialNumber">
                <form:options items="${SerialNumberMachine}"/>
            </form:select>
        </td></tr>
        <tr><td> Имя Фамилия:</td><td><form:input path="nameClient"/></td></tr>
        <tr><td>Номер телефона:</td><td><form:input path="phoneClient"/></td></tr>
        <tr><td>Желаема дата:</td><td><form:input path="dataWish"/></td></tr>
        <tr><td>Описание проблемы:</td><td><form:input path="descProblem"/></td></tr>
        <tr><td><td><input type="submit" value="Отправить"></td></tr>
    </table>
</form:form>



<footer>
    <div style="text-align: center;">Доступные инженеры</div>
</footer>



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