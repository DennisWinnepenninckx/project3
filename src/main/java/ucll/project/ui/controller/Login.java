package ucll.project.ui.controller;

//import org.omg.CORBA.DynAnyPackage.Invalid;
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

public class Login extends RequestHandler{

    public Login(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> errors = new ArrayList<>();
        User user=null;

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        request.setAttribute("email",email);
        try{
            user=getUserService().getUserRepo().loginUser(email,password);
        }catch (InvalidLogin e){
            errors.add(e.getMessage());
        }

        if(errors.size()==0 && user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("Controller");
        }else{
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
