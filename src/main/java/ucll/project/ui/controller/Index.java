package ucll.project.ui.controller;

import ucll.project.domain.user.User;
import ucll.project.domain.user.UserRepositoryDb;
import ucll.project.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Index extends RequestHandler {
    public Index(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String sender = readCookie(request, "loginCookie"); /// have to get logged in user from this


        List<String> tags = new ArrayList<>();
        tags.add("Excel");
        tags.add("HardWork");
        tags.add("LateNights");
        tags.add("Wow!");
        request.setAttribute("tags", tags);

        request.setAttribute("receivers", new UserRepositoryDb().getAll());

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
