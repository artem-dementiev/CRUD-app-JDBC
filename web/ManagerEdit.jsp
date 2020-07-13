<%@ page import="service.EmployerService" %>
<%@ page import="entity.Emp" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Manager edit</title>
    <meta charset="utf-8" />
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        Emp emp = new Emp();
        emp.setId_emp(Integer.parseInt(request.getParameter("currentID")));
        emp.setName_emp(request.getParameter("name"));
        emp.setSurname_emp(request.getParameter("surname"));
        emp.setId_e_role(Integer.parseInt(request.getParameter("role")));
        emp.setEmployment_date(request.getParameter("date"));
        emp.setPhone_number_emp(request.getParameter("tel"));
        emp.setId_e_department(Integer.parseInt(request.getParameter("dep")));
        EmployerService es = new EmployerService();
        try {
            es.update(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/projectStudio_war_exploded/index.jsp");
    %>
</body>
</html>
