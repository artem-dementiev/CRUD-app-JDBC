
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Form</title>
</head>

<body>
<form class="form-horizontal" method="post" action="empList" accept-charset="UTF-8">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm">
                <h1>Добавить сотрудника</h1>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-sm">
                <p id="message" >Пожалуйста, заполните все поля формы!</p>
            </div>
        </div>


    <div class="row justify-content-center" >
        <div class="col-sm-2">
            <label for="inputName" class="col-xs-2 control-label">Фамилия сотрудника:</label>
        </div>
        <div class="col-sm-8 form-group">
            <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите Имя сотрудника">
        </div>
    </div>

        <div class="row justify-content-center" >
            <div class="col-sm-2">
                <label for="inputSurname" class="col-xs-2 control-label">Фамилия сотрудника:</label>
            </div>
            <div class="col-sm-8">
                <input type="text" name="surname" class="form-control" id="inputSurname" placeholder="Введите Фамилию сотрудника">
            </div>
        </div>

    <div class="row justify-content-center" >
        <div class="col-sm-2">
            <label for="inputRole" class="col-xs-2 control-label">Роль:</label>
        </div>
        <div class="col-sm-8">
            <input type="number" name="role" class="form-control" id="inputRole" placeholder="Введите ИД роли">
        </div>
    </div>

    <div class="row justify-content-center" >
        <div class="col-sm-2">
            <label for="inputDate" class="col-xs-2 control-label">Дата трудоустройства:</label>
        </div>
        <div class="col-sm-8">
            <input type="date" name="date" min="1980-01-01" required class="form-control" id="inputDate">
        </div>
    </div>

    <div class="row justify-content-center" >
        <div class="col-sm-2">
            <label for="inputTel" class="col-xs-2 control-label">Телефон:</label>
        </div>
        <div class="col-sm-8">
            <input type="text" name="tel" class="form-control" id="inputTel" placeholder="Введите телефон сотрудника">
        </div>
    </div>

    <div class="row justify-content-center" >
        <div class="col-sm-2">
            <label for="inputDep" class="col-xs-2 control-label">Отдел:</label>
        </div>
        <div class="col-sm-8">
            <input type="number" name="dep" class="form-control" id="inputDep" placeholder="Введите ИД департамента">
        </div>
    </div>

    <div class="row justify-content-center" >
        <div class="col-sm-6">
            <button class="btn btn-dark btn-lg"><a href="./index.jsp">Back to menu</a></button>
        </div>
        <div class="col-sm-4">
            <button type="submit" class="btn btn-info" onClick="Validation();">Добавить</button>
        </div>
    </div>
    </div>
</form>



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
