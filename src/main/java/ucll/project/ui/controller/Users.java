package ucll.project.ui.controller;

import ucll.project.db.DBController;
import ucll.project.domain.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Users extends RequestHandler {

    public Users(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", this.getUserService().getAllUsers());
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
