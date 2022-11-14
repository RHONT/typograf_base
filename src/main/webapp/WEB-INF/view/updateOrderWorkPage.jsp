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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
    <title>Document</title>
</head>
<body>

<div class="container-fluid col-6">
<table class="table table-striped">
    <form:form modelAttribute="сlientOrderDTO" action="/typograf_base_war/saveАFullOrder">
        <form:hidden path="innFirm"/>
        <form:hidden path="firm"/>
        <form:hidden path="nameClient"/>
        <form:hidden path="phoneClient"/>
        <form:hidden path="adress"/>
        <form:hidden path="idSerialNumber"/>

    <thead class="table-dark col-6">
    <tr align="center" valign="middle">
        <th>${typeMachine.nameType}</th>
        <th>${machine.modelMachine}</th>
        <th>${сlientOrderDTO.idSerialNumber}</th>
    </tr>
    </thead>
        <tbody>

            <tr>
                <td> <form:input path="idTypeMachine" cssClass="form-control"/></td>
                <td> <form:input path="idMachine" cssClass="form-control"/></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3">
                <form:textarea path="descProblem"  rows="5" cssClass="form-control"/>
                </td>
            </tr>

            <tr>
                    <td>Сложность: <form:input path="difficilty" cssClass="form-control"/><form:errors path="difficilty"/></td>
                    <td>Труд-Время: <form:input path="timeForecast" cssClass="form-control"/><form:errors path="timeForecast"/></td>
                    <td>Желаемая дата: <form:input path="dataWish" cssClass="form-control"/></td>
            </tr>
                <td>
                    <input type="submit" value="Update" class="btn btn-success">
                </td>
    </tbody>
    </form:form>
</table>


    <c:forEach var="emp" items="${Employee}" >
        <br>
        <table class="table table-secondary col-2">
            <tr>
                <td class="col-1">${emp.name} ${emp.surname} </td>
                <td align="right" class="col-2"> [ ${emp.phone} ] </td>
            </tr>
        </table>

        <div class="container">
            <div class="row row-cols-12 g-1">
            <c:forEach var="tr" items="${WorkingCoverage.next().workSession}" >

                <c:url var="TabelButton" value="/admin/adminorder/updateinfo/tableinfo">
                    <c:param name="id_empl" value="${emp.id}"/>
                    <c:param name="data_work" value="${tr.key}"/>
                    <c:param name="arrayHours" value="${tr.value.returnArrayString()}"/>
                    <c:param name="id_clientOrder" value="${сlientOrderDTO.id}"/>
                    <c:param name="time_forecast" value="${сlientOrderDTO.timeForecast}"/>
                </c:url>

                <div class="col-1">${tr.value.dayOfMonth}</div>
                <div class="col-1">${tr.value.ReturnDayForWorkStatus(сlientOrderDTO.timeForecast)}</div>
                <div class="col-1"><input type="button" class="btn btn-secondary" value="go" onclick="window.location.href='${TabelButton}'"/></div>

            </c:forEach>
            </div>
        </div>

    </c:forEach>

</div>
</body>
</html>