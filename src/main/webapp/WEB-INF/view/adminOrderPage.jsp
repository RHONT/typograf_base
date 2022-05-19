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

<table border="1" cellspacing="0" bgcolor="#fff8dc">
    <tr align="left" valign="middle" bgcolor="#add8e6">
        <th width=10%>Machine</th>
        <th width=20%>Client</th>
        <th width=58%>Description of the problem</th>
        <th width=4%>Dfclt</th>
        <th width=4%>TFST</th>
        <th width=4%></th>
    </tr>

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

            <td align="center" valign="middle"><input type="button" value="Render" onclick="window.location.href='${UpdateButton}'"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>