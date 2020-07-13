import entity.Emp;
import service.EmployerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployerServlet extends HttpServlet {
//    Create
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int role = Integer.parseInt(request.getParameter("role"));
        String date = request.getParameter("date");
        String tel = request.getParameter("tel");
        int dep = Integer.parseInt(request.getParameter("dep"));
        Emp newEmp = new Emp(0, name, surname, role, date, tel, dep);
        System.out.println(newEmp);
        EmployerService employerService = new EmployerService();
        try {
            employerService.add(newEmp); System.out.println("Task 'add' success!!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Task 'add' failed!!");
        }
    }

    //getAll
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            EmployerService employerService = new EmployerService();

            List<Emp> emps = employerService.getAll();

            request.setAttribute("emps", emps);
            request.getRequestDispatcher("/empList.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }
    }


}
