package ucll.project.ui.controller;

import ucll.project.db.DBController;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Users extends RequestHandler {

    public Users(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null || !sessionUser.isAdmin()){
            request.setAttribute("notAuthorized","You don't have the rights to perform this action.");
            HandlerFactory h = new HandlerFactory();
            RequestHandler rh = h.getHandler("Index",this.getUserService());
            rh.handleRequest(request,response);
        }
        else{
            request.setAttribute("users", this.getUserService().getAllUsers());
            request.getRequestDispatcher("users.jsp").forward(request, response);
        }

    }
}
