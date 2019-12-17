package ucll.project.ui.controller;

import extra.SimpleMail;
import ucll.project.domain.star.Star;
import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class mail extends RequestHandler {
    private Star star;
    public mail(String command, UserService userService, Star star) {
        super(command, userService);
        this.star = star;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String receiver = request.getParameter("receiver");
        try {
            String message = "Dear " + star.getUserReceiver().getFirstName() +
                    ", \n You just received a star with the following tags: " +
                    star.getTagsInString() + "\n from " + star.getUserSender().getEmail() +
                    "\nDescription:\n" + "\nGood job!";
            SimpleMail.send(star,message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
