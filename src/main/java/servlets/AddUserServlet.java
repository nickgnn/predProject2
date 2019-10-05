package servlets;

import exception.DBException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();

        String name = req.getParameter("name");
        String age = req.getParameter("age");

        req.getRequestDispatcher("/users").forward(req, resp);

        try {
            service.addUser(name, Integer.valueOf(age));
        } catch (DBException e) {
            e.getMessage();
        }
    }
}
