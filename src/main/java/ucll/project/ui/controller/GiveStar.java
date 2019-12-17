package ucll.project.ui.controller;

import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GiveStar extends RequestHandler {

    public GiveStar(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return null;
    }
}
