package ucll.project.ui.controller;

import ucll.project.db.DBController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteConfirmationUser extends RequestHandler{

    public DeleteConfirmationUser(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        request.getRequestDispatcher("deleteConfirmationUser.jsp").forward(request,response);
    }
}
