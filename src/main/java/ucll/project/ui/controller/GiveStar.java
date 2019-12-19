package ucll.project.ui.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import extra.SimpleMail;
import ucll.project.db.DBController;
import ucll.project.domain.star.Star;
import ucll.project.domain.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;

public class GiveStar extends RequestHandler {


    public GiveStar(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> errors = new ArrayList<>();
        try {
            User user = (User) request.getSession().getAttribute("user");
            String sender_email = user.getEmail();
            if (sender_email.isEmpty()) {
                errors.add("No sender");
            }

            if (getUserService().usersSendStarsThisMonth(user) >= 3 && !user.getSuperUser()) {
                errors.add("no superuser and more then 3 stars send this month");
            }


            String receiver_string = request.getParameter("receiver");
            ObjectMapper receiverMapper = new ObjectMapper();
            receiverMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<Tag> receivers = receiverMapper.readValue(receiver_string, new TypeReference<ArrayList<Tag>>() {
            });
            if (receivers.size() != 1) {
                errors.add("Must have 1 receiver");
            }
            String receiver_email = receivers.get(0).getValue();
            String description = request.getParameter("description");
            if (description.isEmpty()) {
                errors.add("No description added");
            }
            if (receiver_email.equals(sender_email)) {
                errors.add("Can't send star to yourself");
            }
            String jsonString = request.getParameter("tags");
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                List<Tag> tags = mapper.readValue(jsonString,
                        new TypeReference<ArrayList<Tag>>() {
                        });
                if (tags.size() > 4) {
                    errors.add("Can't have more than 4 tags");
                }
                List<String> tagStrings = new ArrayList<>();
                for (Tag tag :
                        tags) {
                    tagStrings.add(tag.getValue());
                }

                Star star = new Star(tagStrings, description, sender_email, receiver_email);
                getUserService().createStar(star);
                String message = "Beste, " + star.getUserReceiver().getFirstName() + "\nYou just received a star with tags:" + star.getTagsInString() + "\nWith description: " + star.getDescription() + "\nFrom" + star.getUserSender().getFirstName();
                try {
                    SimpleMail.send(receiver_email, message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                List<User> superUsers = getUserService().getAllManagers();
                String managerMessage = receiver_email + "just received a star with tags:" + star.getTagsInString() + "\nWith description: " + star.getDescription() + "\nFrom" + star.getUserSender().getFirstName();
                for (User manager : superUsers) {
                    try {
                        SimpleMail.send(manager.getEmail(), managerMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                errors.add("no tags added");
            }
            if(errors.size()!=0){
                try {
                    request.setAttribute("errors", errors);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }
            else {
                response.sendRedirect("Controller");
            }
        } catch (Exception ex) {
            errors.add("No receiver given");
            try {
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}

class Tag {
    private String value;
    private String style;

    public String getValue() {
        return value;
    }
}
