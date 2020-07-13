import entity.Emp;
import service.EmployerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteEmpServlet extends HttpServlet {
    protected void	doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            delete(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            delete(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        EmployerService employerService = new EmployerService();
        employerService.remove(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/projectStudio_war_exploded/index.jsp");
    }
}
