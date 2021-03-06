package ucll.project.ui.controller;

import ucll.project.db.DBController;
import ucll.project.domain.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Profile extends RequestHandler {
    public Profile(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        setGivenStars(request, response);
        setReceivedStars(request, response);
        setAmountOfStarsLeft(request,response);
        RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
        view.forward(request, response);
    }
    public void setAmountOfStarsLeft(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");

        int amount_of_stars = getUserService().usersSendStarsThisMonth(user);
        if (user.getSuperUser()){
            request.setAttribute("amountOfStars", null);

        }else{
            request.setAttribute("amountOfStars", 3 - amount_of_stars);

        }
    }
    public void setGivenStars(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("givenStars", getUserService().getStarsUserGaveAway(user));
    }

    public void setReceivedStars(HttpServletRequest request, HttpServletResponse response) {
        // Dit is voor jou Dennis
        User u = (User) request.getSession().getAttribute("user");
        request.setAttribute("receivedStars", getUserService().getStarsUserReceived(u));
    }
}
