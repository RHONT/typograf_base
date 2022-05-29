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
        <th>id_completed_orders</th>
        <th>id_client_request</th>
        <th>id_employee</th>
        <th>firm</th>
        <th>inn_firm</th>
        <th>id_type_machine</th>
        <th>id_machine</th>
        <th>id_serial_number</th>
        <th>name_client</th>
        <th>phone_client</th>
        <th>desc_problem</th>
        <th>difficilty</th>
        <th>fact_difficilty</th>
        <th>expert_opinion</th>
        <th>jadgment_company</th>
        <th>rating_firm</th>
        <th>engineer_assessment</th>
    </tr>

    <c:forEach var="complet_attr" items="${complete}">
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>