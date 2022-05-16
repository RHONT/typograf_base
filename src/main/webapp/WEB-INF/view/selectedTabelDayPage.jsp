<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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
<table border="1" cellspacing="0" bgcolor="#fff8dc">
    <tr align="left" valign="middle" bgcolor="#add8e6">
        <th>Фирма</th>
        <th>Имя</th>
        <th>Дата визита</th>
        <th>Старт работы</th>
        <th>Время работы</th>
    </tr>


    <c:forEach var="listTabel" items="${listWork}">
        <tr align="left">
            <td>${listTabel.idClientRequest.firm}</td>
            <td>${listTabel.idEmployee.name}</td>
            <td>${listTabel.dateVisit}</td>
            <td>${listTabel.timeStart}</td>
            <td>${listTabel.laidDownTime}</td>
        </tr>
    </c:forEach>
</table>

<br>
    <form:form modelAttribute="newWorkDay" action="updateWorkDay">
        <form:hidden path="id"/>
        Time for start:
        <form:select path="timeStart">
            <form:options items="${hours}"/>
        </form:select>

          LaidDownTime: ${newWorkDay.laidDownTime}
        <br>
        <input type="submit" value="Update">
    </form:form>

    <c:forEach var="elementMaps" items="${hours}">
        <${elementMaps.key}>
        <br>
        <${elementMaps.value}>
    </c:forEach>

<br>
${newWorkDay.idEmployee.id}

</body>
</html>