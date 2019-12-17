package ucll.project.ui.controller;

import extra.SimpleMail;
import io.cucumber.java.an.E;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserRepositoryDb;
import ucll.project.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addUser extends RequestHandler {
    private UserService userService;
    public addUser(String command, UserService userService) {
        super(command, userService);
        this.userService = userService;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserRepositoryDb userRepositoryDb = new UserRepositoryDb();
        String FirstName = request.getParameter("firstName");
        String LastName  = request.getParameter("lastName");
        String Email  = request.getParameter("email");
        System.out.println(Email);
        User user = new User(Email,FirstName,LastName,"t",false);

        userService.getUserRepo().createUser(user);

        String inhoud = "beste" + LastName + "\n" + "welkom bij BEDRIJF. Klik op volgende link om uw account in te stellen.";

        try {
            SimpleMail.test(Email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
