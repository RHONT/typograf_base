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
<form:form modelAttribute="completedOrder" action="/typograf_base_war/engineer/updateWork/update">
    <form:hidden path="id"/>
    <form:hidden path="idClientRequest"/>
    <form:hidden path="idEmployee"/>
    <form:hidden path="idMachine"/>
    <form:hidden path="idTypeMachine"/>
    <form:hidden path="idSerialNumber"/>
<%--    <form:hidden path="innFirm"/>--%>
<%--    <form:hidden path="firm"/>--%>
<%--    <form:hidden path="nameClient"/>--%>
<%--    <form:hidden path="descProblem"/>--%>
<%--    <form:hidden path="engineerAssessment"/>--%>

    <p th:each="phone,stat:${person.getPhoneNumbers()}">
        <input type="text" th:name="phoneNumbers[__${stat.index}__].type" th:value="${phone.getType()}">
        <input type="text" th:name="phoneNumbers[__${stat.index}__].number" th:value="${phone.getNumber()}">
    </p>

<table>

    <tr>
        <td>
            ${completedOrder.firm}
        </td>
        <td>
            ${completedOrder.idTypeMachine.nameType}
        </td>
        <td>
            ${completedOrder.idMachine.modelMachine}
            ${completedOrder.idEmployee.name}
        </td>
        <td>
                ${completedOrder.nameClient}
        </td>
        <td>
                ${completedOrder.phoneClient}
        </td>
    </tr>
    <tr>
        <td>${completedOrder.descProblem}</td>
    </tr>
    <tr>
        <td>Оценка инженера<form:textarea path="jadgmentCompany" rows="20" cols="40"/></td>

        <td>Сложность по факту:<form:input path="factDifficilty"/></td>
        <td>Рейтинг фирмы:<form:input path="ratingFirm"/></td>
        <td>Заключение эксперта:<form:textarea path="expertOpinion"/></td>
        <td></td>
        <td></td>

    </tr>
</table>
    <input type="submit" value="Update">
</form:form>

</body>
</html>