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



<form:form modelAttribute="сlientOrderDTO" action="/typograf_base_war/saveАFullOrder">

<%--    <form:hidden path="id"/>--%>
    <form:hidden path="innFirm"/>
    <form:hidden path="firm"/>
    <form:hidden path="nameClient"/>
    <form:hidden path="phoneClient"/>
    <form:hidden path="adress"/>



    type_machine: <form:input size="7" path="idTypeMachine" title="${typeMachine.nameType}"/>
    machine: <form:input size="7" path="idMachine" title="${machine.modelMachine}"/> serial: <form:input size="7" path="idSerialNumber"/>
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
    <c:forEach var="emp" items="${Employee}" >
        <table>
            <tr>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td> [ ${emp.phone} ] </td>
            </tr>
        </table>
        <table>

            <c:forEach var="tr" items="${WorkingCoverage.next().workSession}" >

                <c:url var="TabelButton" value="/admin/adminorder/updateinfo/tableinfo">
                    <c:param name="id_empl" value="${emp.id}"/>
                    <c:param name="data_work" value="${tr.key}"/>
                    <c:param name="arrayHours" value="${tr.value.returnArrayString()}"/>
                    <c:param name="id_clientOrder" value="${сlientOrderDTO.id}"/>
                    <c:param name="time_forecast" value="${сlientOrderDTO.timeForecast}"/>

                </c:url>

                <td>${tr.value.index}</td>
                <td>${tr.value.ReturnDayForWorkStatus(сlientOrderDTO.timeForecast)}</td>
                <td><td><input type="button" value="go" onclick="window.location.href='${TabelButton}'"/></td></td>
            </c:forEach>
        </table>

    </c:forEach>

    </table>
    <form:errors path="timeForecast"/>
    <form:errors path="difficilty"/>f

</form:form>

<br>



</body>
</html>