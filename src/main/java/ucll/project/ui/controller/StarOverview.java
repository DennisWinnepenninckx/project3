package ucll.project.ui.controller;

import ucll.project.domain.star.Star;
import ucll.project.domain.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StarOverview extends RequestHandler {
    public StarOverview(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Star> stars= getUserService().getStars();
        request.setAttribute("starList",stars);

        try {
            request.getRequestDispatcher("starOverviewPage.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
