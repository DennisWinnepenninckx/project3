package ucll.project.ui.controller;

import extra.SimpleMail;
import ucll.project.db.DBController;
import ucll.project.domain.user.User;
import ucll.project.db.UserRepositoryDb;
import ucll.project.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddUser extends RequestHandler {

    public AddUser(String command, DBController userService) {
        super(command, userService);
    }
    //yeet
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String FirstName = request.getParameter("firstName");
        String LastName  = request.getParameter("lastName");
        String Email  = request.getParameter("email");

        boolean isSuperuser = request.getParameter("superuser") !=null && request.getParameter("superuser").equals("superuser");
        boolean isAdmin = request.getParameter("admin") !=null &&request.getParameter("admin").equals("admin");
        boolean isManager = request.getParameter("manager") !=null && request.getParameter("manager").equals("manager");

        User user = new User(Email,FirstName,LastName,"t",isSuperuser);
        user.setAdmin(isAdmin);
        user.setManager(isManager);

        try{
            getUserService().createUser(user);
            String message = "Beste " + FirstName + " " + LastName +"\n" + "U hebt een account op de sterren-awards website";
            try {
                //SimpleMail.send(Email);
                SimpleMail.send(Email, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            HandlerFactory h = new HandlerFactory();
            RequestHandler rhIndex = h.getHandler("Index",this.getUserService());
            rhIndex.handleRequest(request,response);
        } catch (RuntimeException e){
            request.setAttribute("useralreadyexists","User already exists.");
            HandlerFactory h = new HandlerFactory();
            RequestHandler rh = h.getHandler("ToCreateUser",this.getUserService());
            rh.handleRequest(request,response);
        }


    }
}
