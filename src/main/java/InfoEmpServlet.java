import service.EmployerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class InfoEmpServlet extends HttpServlet {
    protected void	doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        EmployerService employerService = new EmployerService();
        try {
            request.setAttribute("fullDataEmp", employerService.getEmpByID(id, true));
            RequestDispatcher rd = request.getRequestDispatcher("/infoEmp.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Task 'get' in EditServlet failed!!");
        }
    }
}
