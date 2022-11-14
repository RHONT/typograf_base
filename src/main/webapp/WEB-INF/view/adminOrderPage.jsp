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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
    <title>Document</title>
</head>

<body>

<table class="table table-striped table-sm table-bordered border-secondary"  width="100%">
    <thead class="table-dark">
    <tr align="center" valign="middle">
        <th width=5%>Оборудование</th>
        <th width=20%>Инф. о клиенте</th>
        <th width=58%>Описание проблемы</th>
        <th width=6%>Сложность</th>
        <th width=6%>Время ремонта</th>
        <th width=6% align="center"></th>
    </tr>

    </thead>
    <tbody class="table-bordered border-secondary">
        <c:forEach var="allClentRequestPage" items="${allClientRequests}">

            <c:url var="UpdateButton" value="/interlayerlink">
                <c:param name="ClientOrderID" value="${allClentRequestPage.id}"/>
            </c:url>
            <tr align="left" valign="top">

                <td>${allClentRequestPage.idTypeMachine.nameType}<br>${allClentRequestPage.idMachine.modelMachine}
                    <br>${allClentRequestPage.idSerialNumber.id}</td>

                <td>${allClentRequestPage.id}<br>${allClentRequestPage.firm}<br>${allClentRequestPage.innFirm}<br>${allClentRequestPage.nameClient}<br>
                        ${allClentRequestPage.phoneClient}<br>${allClentRequestPage.adress}<br>${allClentRequestPage.dataWish}</td>

                <td>${allClentRequestPage.descProblem}</td>
                <td align="center" valign="middle">${allClentRequestPage.difficilty}</td>
                <td align="center" valign="middle">${allClentRequestPage.timeForecast}</td>

                <td align="center" valign="middle"><input type="button" value="Обработать" class="btn btn-secondary" onclick="window.location.href='${UpdateButton}'"/></td>
            </tr>
        </c:forEach>
    </tbody>

</table>

</body>
</html>