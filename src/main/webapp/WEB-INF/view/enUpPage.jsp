<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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

<body bgcolor="#d0d0d0">

<table border="1" cellspacing="0" bgcolor="#fff8dc" align="center" width=70%>

    <tr align="left" valign="middle">
        <td width=15%>Организация:</td>
        <td width=85%>${clientRequest.firm}</td>
    </tr>
    <tr>
        <td>Тип оборудования:</td>
        <td>${typeMachine.nameType}</td>
    </tr>
    <tr>
        <td>Модель:</td>
        <td>${machine.modelMachine}</td>
    </tr>
    <tr>
        <td>Имя сотрудника:</td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>Имя клиента:</td>
        <td>${clientRequest.nameClient}</td>
    </tr>
    <tr>
        <td>Телефон клиента:</td>
        <td>${clientRequest.phoneClient}</td>
    </tr>
    <tr>
        <td>Описание проблемы:</td>
        <td>${clientRequest.descProblem}</td>
    </tr>
<tr>
</table>

<br>
<form:form modelAttribute="completedOrderForExpertDTO" action="/typograf_base_war/engineer/updateWork/update">
    <form:hidden path="idCompletedOrder"/>
<table border="1" cellspacing="0" bgcolor="#fff8dc" align="center" width=70%>


        <security:authorize access="hasRole('ENGINEER')">
            <tr align="left" valign="middle">
            <td width=15%>Оценка инженера:</td>
            <td width=85%><form:textarea path="jadgmentCompany" rows="6" cols="70" cssStyle="background:#fff8dc"/><form:errors path="jadgmentCompany"/></td>
            </tr>
        </security:authorize>


    <security:authorize access="hasRole('FIRST')">
        <tr>
            <td>Фактическая сложность</td>
            <td><form:input path="factDifficilty" cssStyle="background: #fff8dc "/><form:errors path="factDifficilty"/></td>
        </tr>
        <tr>
            <td>Рейтинг фирмы:</td>
            <td><form:input path="ratingFirm" cssStyle="background:#fff8dc"/></td>
        </tr>
        <tr>
            <td>Заключение эксперта</td>
            <td><form:input path="expertOpinion" cssStyle="background:#fff8dc"/></td>
        </tr>
    </security:authorize>

    <tr>
        <td></td>
        <td><input type="submit" value="Отправить"></td>
    </tr>

</table>
</form:form>


<%--<form action="/typograf_base_war/engineer/updateWork/update">--%>
<%--    <input name="id_Complete" value="${id_completedOrder}">--%>
<%--    <br>--%>
<%--    Оценка инженера<textarea name="jadgmentCompany"></textarea>--%>
<%--    <br>--%>
<%--    Сложность по факту:<input name="factDifficilty"/>--%>
<%--    <br>--%>
<%--    Рейтинг фирмы:<input name="ratingFirm"/>--%>
<%--    <br>--%>
<%--    Заключение эксперта:<textarea name="expertOpinion"></textarea>--%>
<%--    <br>--%>
<%--    <input type="submit" value="Обновить" />--%>

<%--</form>--%>

<%--<security:authorize access="hasRole('ENGINEER')">--%>

<%--</security:authorize>--%>

<%--<security:authorize access="hasRole('FIRST')">--%>

<%--</security:authorize>--%>

</body>
</html>