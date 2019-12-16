package ucll.project.ui.controller;

import extra.SimpleMail;
import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class mail extends RequestHandler {
    public mail(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String receiver = request.getParameter("receiver");
        try{
            SimpleMail.test(receiver);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}
