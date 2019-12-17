package ucll.project.ui.controller;

import extra.SimpleMail;
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
        // Should determine the sender here

        StarDB starDB = new StarDB();

        String sender_email = "arne.walschap@ucll.be";
        String receiver_email = request.getParameter("receiver");
        String description = request.getParameter("description");
        List<String> tags = new ArrayList<>();
        int tagNum = 1;
        try {
            tags.add(request.getParameter("tag" + tagNum++));
        } catch (Exception ex) {
            System.out.println("End of tag list");
        }
        if (tags.size() > 4) {
            throw new IllegalArgumentException("Can't have more than 4 tags");
        }
        if (receiver_email.equals(sender_email)) {
            throw new IllegalArgumentException("Can't send star to yourself");
        }
        Star star = new Star(tags, description, sender_email, receiver_email);
        new StarDB().createStar(star);

        String message = "Beste, "  + star.getUserReceiver().getFirstName() +"\nYou just received a star with tags:" + star.getTagsInString() + "\nWith description: " + star.getDescription() + "\nFrom" + star.getUserSender().getFirstName();
        try {
            SimpleMail.send(receiver_email,message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("Controller");
    }
}
