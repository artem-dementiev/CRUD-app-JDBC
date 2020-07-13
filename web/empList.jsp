<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>Employer List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
</head>
<style>
    body{padding: 0; margin: 0;}
</style>
<body>

<div class="container">
<div class="row justify-content-center" >
    <div class="col-sm-12">
        <button class="btn btn-dark btn-lg"><a href="./index.jsp">Back to menu</a></button>
    </div>
</div>
</div>
<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>ID Роли</th>
        <th>Дата трудоустройства</th>
        <th>Номер телефона</th>
        <th>ID Департамента</th>
        <th>Дейстие</th>
    </tr>
    </thead>
    <tbody class="table-striped ">
    <c:forEach var="emps" items="${emps}">
        <tr>
            <td>${emps.getId_emp()}</td>
            <td>${emps.getName_emp()}</td>
            <td>${emps.getSurname_emp()}</td>
            <td>${emps.getId_e_role()}</td>
            <td>${emps.getEmployment_date()}</td>
            <td>${emps.getPhone_number_emp()}</td>
            <td>${emps.getId_e_department()}</td>
            <td>
                <a href="infoEmp?id=${emps.getId_emp()}" class="btn btn-info">Просмотреть</a>
                <a href="editEmp?id=${emps.getId_emp()}" class="btn btn-info">Изменить</a>
                <form action="delete" method="post">
                    <input type="hidden" name="id" value="${emps.getId_emp()}">
                    <input type="submit" value="Удалить" style="float:left" class="btn btn-info">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>

</html>
