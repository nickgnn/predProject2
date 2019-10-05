package servlets;

import exception.DBException;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();

//        String newId = req.getParameter("newId");
        String newName = req.getParameter("newName");
        String newAge = req.getParameter("newAge");

//        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.valueOf(req.getParameter("age"));

//        System.out.println("----------------------");
//
////        System.out.println("newId is: " + newId);
//
//        System.out.println("newAge is: " + newAge);
//        System.out.println("newName is: " + newName);
//
////        System.out.println("id is: " + id);
//
//        System.out.println("name is: " + name);
//        System.out.println("age is: " + age);
//        System.out.println("----------------------");

        req.getRequestDispatcher("/users").forward(req, resp);

        User user;

        try {
            user = service.getUserByName(name);

//            System.out.println(user.getName() + " is NAME of user");
//            System.out.println(user.getId() + " is ID of user");
//            System.out.println(user.getAge() + " is AGE os user");


            if (!newName.equals("")) {
                service.updateUser(user, newName);
            }

            if (!newAge.equals("")) {
                service.updateUser(user, Integer.valueOf(newAge));
            }

//            if (!newId.equals("") | !newId.equals(id)) {
//                service.updateUser(user, Long.valueOf(newId));
//            }
        } catch (DBException e) {
                e.getMessage();
            }
    }
}
