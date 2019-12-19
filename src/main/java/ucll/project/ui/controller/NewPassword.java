package ucll.project.ui.controller;

import ucll.project.db.DBController;
import ucll.project.domain.user.InvalidLogin;
import ucll.project.domain.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewPassword extends RequestHandler {
    public NewPassword(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        String error = "";
        String p1=request.getParameter("p1");
        String p2=request.getParameter("p2");

        if(p1!=null && p1.equals(p2)){
            try{
                User user = (User) request.getSession().getAttribute("user");
                user.setNewPassword(p1);
                getUserService().resetPassword(user);
                response.sendRedirect("Controller");
            }catch(Exception e){
                error="passwords empty";
                request.setAttribute("error",error);
                request.getRequestDispatcher("profile.jsp").forward(request,response);
            }
        }else{
            error="passwords not identical";
            request.setAttribute("error",error);
            request.getRequestDispatcher("profile.jsp").forward(request,response);
        }

    }
}
