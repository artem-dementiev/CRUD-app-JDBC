import entity.Emp;
import service.EmployerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditServlet extends HttpServlet {
    //Update
    protected void	doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        EmployerService employerService = new EmployerService();
        List<Emp> empList = new ArrayList<>();
        try {
            empList = employerService.getEmpByID(id, false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Emp emp = empList.get(0);
        emp.setName_emp(req.getParameter("name"));
        emp.setSurname_emp(req.getParameter("surname"));
        emp.setId_e_role(Integer.parseInt(req.getParameter("role")));
        emp.setEmployment_date(req.getParameter("date"));
        emp.setPhone_number_emp(req.getParameter("tel"));
        emp.setId_e_department(Integer.parseInt(req.getParameter("dep")));
        try {
            employerService.update(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        EmployerService employerService = new EmployerService();
        try {
            request.setAttribute("dataEmp", employerService.getEmpByID(id, false));
            RequestDispatcher rd = request.getRequestDispatcher("/edit");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Task 'get' in EditServlet failed!!");
        }
    }

}
