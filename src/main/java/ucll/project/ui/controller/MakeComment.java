package ucll.project.ui.controller;

import ucll.project.db.DBController;
import ucll.project.domain.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeComment extends RequestHandler {
    public MakeComment(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String comment = request.getParameter("comment");
        String star = request.getParameter("star");
        User user = (User) request.getSession().getAttribute("user");



        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
