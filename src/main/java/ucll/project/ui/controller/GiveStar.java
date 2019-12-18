package ucll.project.ui.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import extra.SimpleMail;
import ucll.project.db.DBController;
import ucll.project.domain.star.Star;
import ucll.project.domain.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GiveStar extends RequestHandler {


    public GiveStar(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String sender_email = user.getEmail();
        if(getUserService().usersSendStarsThisMonth(user)>=3 && !user.getSuperUser()){
            throw new IllegalStateException("geen superuser en meer dan 3 sterren gestuurd deze maand");
        }

        String receiver_string = request.getParameter("receiver");

        ObjectMapper receiverMapper = new ObjectMapper();
        receiverMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Tag> receivers = receiverMapper.readValue(receiver_string, new TypeReference<ArrayList<Tag>>() {});
        if (receivers.size() != 1) {
            throw new IllegalArgumentException("Must have 1 receiver!");
        }
        String receiver_email = receivers.get(0).getValue();
        String description = request.getParameter("description");
        String jsonString = request.getParameter("tags");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Tag> tags = mapper.readValue(jsonString,
                new TypeReference<ArrayList<Tag>>() {
                });
        if (tags.size() > 4) {
            throw new IllegalArgumentException("Can't have more than 4 tags");
        }
        if (receiver_email.equals(sender_email)) {
            throw new IllegalArgumentException("Can't send star to yourself");
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
        List<User> superUsers = getUserService().getAllSuperUser();
        String managerMessage = receiver_email + "just received a star with tags:" + star.getTagsInString() + "\nWith description: " + star.getDescription() + "\nFrom" + star.getUserSender().getFirstName();
        for (User manager : superUsers){
            try {
                SimpleMail.send(manager.getEmail(),managerMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("Controller");

    }
}

class Tag {
    private String value;
    private String style;

    public String getValue() {
        return value;
    }
}
