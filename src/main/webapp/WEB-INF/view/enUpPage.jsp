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



<table>
    <tr>
        <td>
            ${clientRequest.firm}
        </td>
        <td>
            ${typeMachine.nameType}
        </td>
        <td>
            ${machine.modelMachine}
            ${employee.name}
        </td>
        <td>
                ${clientRequest.nameClient}
        </td>
        <td>
                ${clientRequest.phoneClient}
        </td>
    </tr>
    <tr>
        <td>${clientRequest.descProblem}</td>
    </tr>
<tr>

</table>

<br>
<form action="/typograf_base_war/engineer/updateWork/update">
    <input name="id_Complete" value="${id_completedOrder}">
    <br>
    Оценка инженера<textarea name="jadgmentCompany"></textarea>
    <br>
    Сложность по факту:<input name="factDifficilty"/>
    <br>
    Рейтинг фирмы:<input name="ratingFirm"/>
    <br>
    Заключение эксперта:<textarea name="expertOpinion"></textarea>
    <br>
    <input type="submit" value="Обновить" />

</form>

</body>
</html>