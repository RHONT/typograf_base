<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http:/thymeleaf.org">
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
<header>
    <div class="bg-dark collapse show" id="navbarHeader" style="">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-9">
                    <h4 class="text-white">О проекте</h4>
                    <p class="text-muted">Сервис создан для поддержки типографий. Оборудование нередко выходит из строя.
                        На этот случай есть мастера, готовые устранить проблему за короткий срок.
                        Заполните заявку и ждите звонка от администратора. </p>
                </div>

                <div class="col-sm-4 offset-md-1 py-4">
                    <p>
                        <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                            Администратор
                        </button>
                        <button class="btn btn-secondary" type="button" onclick="window.location.href='engineer'" >
                            Инженер
                        </button>
                        <button class="btn btn-secondary" type="button" onclick="window.location.href='logout'" >
                            LogOut
                        </button>
                    </p>

                    <div class="collapse" id="collapseExample">
                        <div class="col-7">
                            <button class="btn btn-primary col-7" onclick="window.location.href='admin/emp'">Сотрудники</button>
                            <button class="btn btn-primary col-7" onclick="window.location.href='admin/typemachine'">Тип машины</button>
                            <button class="btn btn-primary col-7" onclick="window.location.href='admin/quality'">Квалификация</button>
                            <button class="btn btn-primary col-7" onclick="window.location.href='admin/adminorder'">Список работ</button>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</header>

<br>

<form:form action="saveorder" modelAttribute="orderDTO">
    <table align="center" width="70%">
        <tr><h4 class="mb-3" align="center">Заполните заявку</h4></tr>
        <tr>
            <td width="15%">Организация:</td>
            <td><form:input path="firm" title="Введите название" class="form-control"/></td>
            <td width="15%"><form:errors path="firm"/> </td>
        </tr>

        <tr>
            <td> ИНН:</td>
            <td><form:input path="innFirm" class="form-control"/></td>
            <td><form:errors path="innFirm"/></td>
        </tr>

        <tr>
            <td>Тип станка:</td>
            <td>
                <form:select path="idTypeMachine"  class="form-select">
                    <form:option value="1" label="--Please Select"/>
                    <form:options items="${typeMachine}"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Модель станка:</td>
            <td>
                <form:select path="idMachine" class="form-select">
                    <form:option value="1" label="--Please Select"/>
                    <form:options items="${modelMachine}"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Серийный номер:</td>
            <td>
                <form:select path="idSerialNumber" class="form-select">
                    <form:option value="1" label="--Please Select"/>
                    <form:options items="${SerialNumberMachine}"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td> Имя Фамилия:</td>
            <td><form:input path="nameClient" class="form-control"/></td>
            <td><form:errors path="nameClient"/></td>
        </tr>

        <tr>
            <td>Номер телефона:</td>
            <td><form:input path="phoneClient" class="form-control"/></td>
            <td><form:errors path="phoneClient"/></td>
        </tr>

        <tr>
            <td>Желаемая дата:</td>
            <td><form:input path="dataWish" class="form-control"/></td>
        </tr>

        <tr>
            <td>Адрес:</td>
            <td><form:input path="adress" class="form-control"/></td>
            <td><form:errors path="adress"/></td>
        </tr>

        <tr>
            <td>Описание проблемы:</td>
            <td><form:textarea path="descProblem" class="form-control" rows="5"/></td>
            <td><form:errors path="descProblem"/></td>
        </tr>

        <tr><td></td></tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="Отправить" class="btn btn-success"></td>
            <td></td>
        </tr>
    </table>

</form:form>
<br>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
