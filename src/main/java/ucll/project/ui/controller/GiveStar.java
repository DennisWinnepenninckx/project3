package ucll.project.ui.controller;

import ucll.project.domain.star.Star;
import ucll.project.domain.star.StarDB;
import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GiveStar extends RequestHandler {

    public GiveStar(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sender_email = request.getParameter("sender");
        String receiver_email = request.getParameter("receiver");
        String description = request.getParameter("description");
        List<String> tags = new ArrayList<>();
        int tagNum = 1;
        try {
            tags.add(request.getParameter("tag"+tagNum++));
        } catch (Exception ex) {
            System.out.println("End of tag list");
        }
        if (tags.size() > 4) {
            throw new IllegalArgumentException("Can't have more than 4 tags");
        }
        Star star = new Star(tags,description, sender_email, receiver_email, getUserService());
        new StarDB().createStar(star);

        response.sendRedirect("Controller");
    }
}
