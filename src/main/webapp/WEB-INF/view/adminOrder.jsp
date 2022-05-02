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
        <th>id</th>
        <th>firm</th>
        <th>inn</th>
        <th>type_machine</th>
        <th>machine</th>
        <th>serial</th>
        <th>name</th>
        <th>phone</th>
        <th>problem</th>
        <th>difficilty</th>
        <th>adress</th>
        <th>data_wish</th>
        <th>time_forecast</th>
    </tr>

    <c:forEach var="admin_atr" items="${admin_object}">

        <c:url var="UpdateButton" value="/updateinfo">
            <c:param name="ClientOrderPerem" value="${admin_atr.id}"/>
        </c:url>
        <tr>
            <td>${admin_atr.id}</td>
            <td>${admin_atr.firm}</td>
            <td>${admin_atr.innFirm}</td>
            <td>${admin_atr.idTypeMachine.id}</td>
            <td>${admin_atr.idMachine.id}</td>
            <td>${admin_atr.idSerialNumber.id}</td>
            <td>${admin_atr.nameClient}</td>
            <td>${admin_atr.phoneClient}</td>
            <td>${admin_atr.descProblem}</td>
            <td>${admin_atr.difficilty}</td>
            <td>${admin_atr.adress}</td>
            <td>${admin_atr.dataWish}</td>
            <td>${admin_atr.timeForecast}</td>
            <td><input type="button" value="Обработать" onclick="window.location.href='${UpdateButton}'"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>