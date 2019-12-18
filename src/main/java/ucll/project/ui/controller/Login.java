package ucll.project.ui.controller;

//import org.omg.CORBA.DynAnyPackage.Invalid;

import ucll.project.db.DBController;
import ucll.project.domain.user.InvalidLogin;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login extends RequestHandler {

    public Login(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String error = null;
        User user = null;

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        request.setAttribute("email", email);
        try {
            user = getUserService().loginUser(email,password);
        } catch (InvalidLogin e) {
            error=(e.getMessage());
        }

        if (error==null && user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("Controller");
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
