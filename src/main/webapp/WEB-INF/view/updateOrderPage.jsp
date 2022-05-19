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
<form:form modelAttribute="сlientOrderUpdate" action="updateOrder">
    <form:hidden path="id"/>
    <form:hidden path="innFirm"/>
    <form:hidden path="firm"/>
    <form:hidden path="nameClient"/>
    <form:hidden path="phoneClient"/>
    <form:hidden path="adress"/>

    type_machine: <form:input size="7" path="idTypeMachine.id"/>
    machine: <form:input size="7" path="idMachine.id"/> serial: <form:input size="7" path="idSerialNumber.id"/>
    <br>
    problem:
    <br>
    <form:textarea path="descProblem" cols="60" rows="10"/>
    <br>
    difficulty: <form:input path="difficilty" size="2"/> time_forecast: <form:input path="timeForecast" size="2"/>
    data_wish: <form:input path="dataWish" size="11"/>
    <br>
    <input type="submit" value="Update">
    </tr>

</form:form>
</body>

</html>
