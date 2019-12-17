package ucll.project.ui.controller;

import ucll.project.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class toCreateUser extends RequestHandler {


    public toCreateUser(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher view = request.getRequestDispatcher("createUser.jsp");
        view.forward(request, response);
    }
}
