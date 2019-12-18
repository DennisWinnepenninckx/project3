package ucll.project.ui.controller;

import ucll.project.db.DBController;
import ucll.project.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToCreateUser extends RequestHandler {

    public ToCreateUser(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher view = request.getRequestDispatcher("createUser.jsp");
        view.forward(request, response);
    }
}
