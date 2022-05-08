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

    <form:hidden path="id"/>

    type_machine:<form:input size="7" path="idTypeMachine.id"/>

    machine: <form:input size="7" path="idMachine.id"/> serial: <form:input size="7" path="idSerialNumber.id"/>
    <br>
    problem:
    <br>
    <form:textarea path="descProblem"/>
    <br>
    difficilty
    <br>
    <form:input path="difficilty"/>
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
    </tr>

</form:form>

<br>

    <c:forEach var="emp" items="${Employee}" >
        <table>
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td> [ ${emp.phone} ] </td>
        </tr>
        </table>
        <table>

            <c:forEach var="tr" items="${linked_list.next().workSession}" >

                <c:url var="TabelButton" value="/tableinfo">
                    <c:param name="id_empl" value="${emp.id}"/>
                    <c:param name="data_work" value="${tr.key}"/>
                </c:url>

                <td>${tr.value.index}</td>
                <td>${tr.value.ReturnDayForWorkStatus(ClientOrderUpdate.timeForecast)}</td>
                <td><td><input type="button" value="go" onclick="window.location.href='${TabelButton}'"/></td></td>
            </c:forEach>
        </table>

    </c:forEach>

</table>

</body>
</html>