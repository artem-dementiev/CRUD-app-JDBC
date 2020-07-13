<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edit Form</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<c:forEach var="emps" items="${dataEmp}" >
<form action="ManagerEdit.jsp" method="post" class="form-horizontal" accept-charset="UTF-8">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm">
                <h1>Изменить данные сотрудника</h1>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-sm">
                <p id="message" >Пожалуйста, заполните все поля формы!</p>
            </div>
        </div>

        <input type="hidden" name = "currentID" value="${emps.id_emp}">

        <div class="row justify-content-center" >
            <div class="col-sm-2">
                <label for="inputName" class="col-xs-2 control-label">Фамилия сотрудника:</label>
            </div>
            <div class="col-sm-8 form-group">
                <input type="text" id="inputName" name="name" value="${emps.name_emp}">
            </div>
        </div>

        <div class="row justify-content-center" >
            <div class="col-sm-2">
                <label for="inputSurname" class="col-xs-2 control-label">Фамилия сотрудника:</label>
            </div>
            <div class="col-sm-8">
                <input type="text" id="inputSurname" name="surname" value="${emps.surname_emp}">
            </div>
        </div>

        <div class="row justify-content-center" >
            <div class="col-sm-2">
                <label for="inputRole" class="col-xs-2 control-label">Роль:</label>
            </div>
            <div class="col-sm-8">
                <input type="number" id="inputRole" name="role" value="${emps.id_e_role}">
            </div>
        </div>

        <div class="row justify-content-center" >
            <div class="col-sm-2">
                <label for="inputDate" class="col-xs-2 control-label">Дата трудоустройства:</label>
            </div>
            <div class="col-sm-8">
                <input type="date" id="inputDate" name="date" value="${emps.employment_date}">
            </div>
        </div>

        <div class="row justify-content-center" >
            <div class="col-sm-2">
                <label for="inputTel" class="col-xs-2 control-label">Телефон:</label>
            </div>
            <div class="col-sm-8">
                <input type="text" id="inputTel" name="tel" value="${emps.phone_number_emp}">
            </div>
        </div>

        <div class="row justify-content-center" >
            <div class="col-sm-2">
                <label for="inputDep" class="col-xs-2 control-label">Отдел:</label>
            </div>
            <div class="col-sm-8">
                <input type="number"  id="inputDep" name="dep" value="${emps.id_e_department}">
            </div>
        </div>
        <div class="row justify-content-center" >
            <div class="col-sm-6">
                <button class="btn btn-dark btn-lg"><a href="./index.jsp">Back to menu</a></button>
            </div>
            <div class="col-sm-4">
                <button type="submit" class="btn btn-info" onClick="Validation();">Обновить</button>
            </div>
        </div>
    </div>


</form>
</c:forEach>

</body>
<script>
    function Validation() {
        var valid= false;
        var output = "";
        var name = document.getElementById('inputName').value;
        if(name==null||name==""){output+=' Введите имя.\n'; return false;}
        var surname = document.getElementById('inputSurname').value;
        if(surname==null||surname == ""){output+=' Введите фамилию.\n'; return false;}

        var re = /^\+380\d{3}\d{2}\d{2}\d{2}$/;
        var myPhone = document.getElementById('inputTel').value;
        valid = re.test(myPhone);

        if (!(valid && myPhone.length == 13)) output += ' Номер телефона введен неправильно.\n';

        document.getElementById('message').innerHTML = output;
        return valid;
    }
</script>
</html>
