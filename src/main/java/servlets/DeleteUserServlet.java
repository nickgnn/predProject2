package servlets;

import exception.DBException;
import service.Service;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = UserService.getInstance();

        Long id = Long.valueOf(req.getParameter("id"));

        req.getRequestDispatcher("/users").forward(req, resp);

        try {
            service.deleteUserById(id);
        } catch (DBException e) {
            e.getMessage();
        }
//        System.out.println("User with id = " + id + " IS DELETED!");
    }
}
