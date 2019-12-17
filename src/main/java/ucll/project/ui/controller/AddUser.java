package ucll.project.ui.controller;

import extra.SimpleMail;
import ucll.project.db.DBController;
import ucll.project.domain.user.User;
import ucll.project.db.UserRepositoryDb;
import ucll.project.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser extends RequestHandler {

    public AddUser(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String FirstName = request.getParameter("firstName");
        String LastName  = request.getParameter("lastName");
        String Email  = request.getParameter("email");
        User user = new User(Email,FirstName,LastName,"t",false);

        getUserService().createUser(user);
        String message = "Beste " + LastName +"\n" + "U hebt een account op de sterren-awards website";
        try {
            //SimpleMail.send(Email);
            SimpleMail.send(Email, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
