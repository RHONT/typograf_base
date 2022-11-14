<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>

<header>
    <div class="bg-dark collapse show" id="navbarHeader" style="">
        <div class="row col-md-12 justify-content-center pt-3 " align="center">
            <p>
                <button class="btn btn-secondary " type="button" onclick="window.location.href='/typograf_base_war/'" >
                    Main
                </button>
                <button class="btn btn-secondary" type="button" onclick="window.location.href='logout'" >
                    LogOut
                </button>
            </p>
        </div>
    </div>
</header>

<div class="container-fluid col-6">
    <table class="table table-striped">
        <thead class="table-dark">
            <tr align="left" valign="middle">
                <th>Фирма</th>
                <th>Имя</th>
                <th>Дата визита</th>
                <th>Старт работы</th>
                <th>Время работы</th>
            </tr>
        </thead>

        <tbody>
        <%--Выводим расипсание сотрудника--%>
            <c:forEach var="listTabel" items="${listWork}">
                <tr align="left">
                    <td>${listTabel.idClientRequest.firm}</td>
                    <td>${listTabel.idEmployee.name}</td>
                    <td>${listTabel.dateVisit}</td>
                    <td>${listTabel.timeStart}</td>
                    <td>${listTabel.laidDownTime}</td>
                </tr>
            </c:forEach>
        <%--Заполняем необходимые поля сущности Work, для внесения новой строки в таблицу--%>
        <form:form modelAttribute="newWorkDay" action="/typograf_base_war/admin/adminorder/updateinfo/tableinfo/updateWorkDay">
            <form:hidden path="id"/>
        <tr>
            <td>
                Time for start:
            </td>
            <td>
                <form:select path="timeStart" cssClass="form-select">
                    <form:options items="${hours}"/>
                </form:select>
            </td>
            <td>
                <input type="submit" value="Update" class="btn btn-secondary col-12">
            </td>
        </tr>
        </form:form>

<%--            ${clientOrderUpdate.timeForecast}--%>
        </tbody>
    </table>


</div>

</body>
</html>