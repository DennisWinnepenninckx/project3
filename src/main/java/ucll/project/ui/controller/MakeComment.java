package ucll.project.ui.controller;

import ucll.project.db.DBController;
import ucll.project.domain.star.Comment;
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
        String commentSt = request.getParameter("comment");
        String star = request.getParameter("star");
        String user = ((User)request.getSession().getAttribute("user")).getEmail();
        Comment comment = new Comment(user, commentSt, Integer.parseInt(star));
        getUserService().makeComment(comment);
        response.sendRedirect("Controller");
    }
}
