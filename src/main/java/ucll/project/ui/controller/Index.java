package ucll.project.ui.controller;

import ucll.project.domain.star.StarDB;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserRepositoryDb;
import ucll.project.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Index extends RequestHandler {
    public Index(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String sender = readCookie(request, "loginCookie"); // have to get logged in user from this

        request.setAttribute("tags", new StarDB().getTags());
        //String sender = readCookie(request, "loginCookie"); /// have to get logged in user from this
        loggedIn(request,response);

        List<String> tags = new ArrayList<>();
        tags.add("Excel");
        tags.add("HardWork");
        tags.add("LateNights");
        tags.add("Wow!");
        request.setAttribute("tags", tags);

        request.setAttribute("receivers", new UserRepositoryDb().getAll());

        request.setAttribute("stars", new StarDB().getAll());

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

    private void loggedIn(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null) request.setAttribute("user",user);
    }
}
