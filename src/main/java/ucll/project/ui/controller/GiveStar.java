package ucll.project.ui.controller;

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
        List<String> tags = new ArrayList<>();
        try {

        } catch (Exception ex) {

        }
    }
}
