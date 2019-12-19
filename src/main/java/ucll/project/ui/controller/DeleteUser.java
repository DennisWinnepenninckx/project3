package ucll.project.ui.controller;

import ucll.project.db.DBController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUser extends RequestHandler{

    public DeleteUser(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        String emailToBeDeleted = request.getParameter("email");
        getUserService().deleteUsingEmail(emailToBeDeleted);
        response.sendRedirect("Controller?command=Users");
    }
}
