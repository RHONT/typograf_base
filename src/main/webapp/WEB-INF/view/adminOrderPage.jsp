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

    <c:forEach var="admin_atr" items="${admin_object}">

        <c:url var="UpdateButton" value="/updateinfo">
            <c:param name="ClientOrderID" value="${admin_atr.id}"/>
        </c:url>
        <tr align="left" valign="top">

            <td>${admin_atr.idTypeMachine.nameType}<br>${admin_atr.idMachine.modelMachine}
                <br>${admin_atr.idSerialNumber.id}</td>

            <td>${admin_atr.id}<br>${admin_atr.firm}<br>${admin_atr.innFirm}<br>${admin_atr.nameClient}<br>
                    ${admin_atr.phoneClient}<br>${admin_atr.adress}<br>${admin_atr.dataWish}</td>

            <td>${admin_atr.descProblem}</td>
            <td align="center" valign="middle">${admin_atr.difficilty}</td>
            <td align="center" valign="middle">${admin_atr.timeForecast}</td>

            <td align="center" valign="middle"><input type="button" value="Render" onclick="window.location.href='${UpdateButton}'"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>