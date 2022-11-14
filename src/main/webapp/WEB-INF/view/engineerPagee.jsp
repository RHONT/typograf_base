<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<div class="container" align="center">
    <form action="/typograf_base_war/engineer/updateWork">
        <div class="row col-md-2 justify-content-center">
            <table class="table table-secondary table-striped">
                <thead class="table-secondary">
                <tr>
                    <th>
                        Введите номер заявки:
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input name="numb_work" class="form-control col-12" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" class="btn btn-secondary col-12"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>