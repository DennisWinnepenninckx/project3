package ucll.project.ui.controller;

import ucll.project.db.DBController;
import ucll.project.domain.star.Star;
import ucll.project.domain.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonController extends RequestHandler {
    public JsonController(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User loggedInUser = (User) request.getSession().getAttribute("user");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        switch (request.getParameter("op")) {
            case "emails":
                List<User> users = getUserService().getAllUsers();
                List<User> notMeUsers = new ArrayList<>();
                for (User user :
                        users) {
                    if (!user.getEmail().equals(loggedInUser.getEmail())) {
                        notMeUsers.add(user);
                    }
                }
                StringBuilder emails = new StringBuilder("[");
                for (int i = 0; i < notMeUsers.size(); i++) {
                    User user = notMeUsers.get(i);
                    emails.append("\"" + user.getEmail() + "\"");
                    if (i != notMeUsers.size() - 1) {
                        emails.append(",");
                    }
                }
                emails.append("]");
                out.print(emails);
                break;
            case "stars":
                String sender = request.getParameter("sender");
                String receiver = request.getParameter("receiver");
                List<Star> stars;
                if (sender!=null) {
                    stars = getUserService().getStarsUserGaveAway(getUserService().getUser(sender));
                }
                else if (receiver!=null) {
                    stars = getUserService().getStarsUserReceived(getUserService().getUser(receiver));
                }
                else {
                    stars = getUserService().getAllStars();
                }

                String start = request.getParameter("start");
                String stop = request.getParameter("stop");

                if (start != null) {
                    stars = stars.subList(Integer.parseInt(start), Integer.parseInt(stop));
                }
                out.print(stars.toString().replaceAll("'", "\""));
                break;
            case "whoami":
                out.print(((User)request.getSession().getAttribute("user")).getEmail());
                break;
        }
    }
}
