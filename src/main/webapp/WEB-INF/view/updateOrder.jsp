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
    <title>Document</title>
</head>
<body>

<form:form modelAttribute="ClientOrderUpdate" action="updateOrder">
    <br>
        id
    <br>
   <form:input path="id"/>
    <br>
       firm
    <br>
    <form:input path="firm"/>
    <br>
       type_machine
    <br>
    <form:input path="idTypeMachine.id"/>
    <br>
        machine
    <br>
    <form:input path="idMachine.id"/>
    <br>
        serial
    <br>
    <form:input path="idSerialNumber.id"/>
    <br>
        name
    <br>
    <form:input path="nameClient"/>
    <br>
        phone
    <br>
    <form:input path="phoneClient"/>
    <br>
        problem
    <br>
    <form:input path="descProblem"/>
    <br>
        difficilty
    <br>
    <form:input path="difficilty"/>
    <br>
        adress
    <br>
    <form:input path="adress"/>
    <br>
        data_wish
    <br>
    <form:input path="dataWish"/>
    <br>
      time_forecast
    <br>
    <form:input path="timeForecast"/>
    <br>
    <input type="submit" value="Обновить">



<%--            <td><button onclick="window.location.href='updateinfo'">Добавить</button></td>--%>
        </tr>

</form:form>>


</body>
</html>