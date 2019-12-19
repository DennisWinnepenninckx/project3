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
                if(errors.size()==0){


                Star star = new Star(tagStrings, description, sender_email, receiver_email);
                getUserService().createStar(star);
                String message = "<!doctype html>\n" +
                        "<html>\n" +
                        "<header>\n" +
                        "    <style>\n" +
                        "        html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, font, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, caption {\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "            border: 0;\n" +
                        "            outline: 0;\n" +
                        "            font-size: 100%;\n" +
                        "            vertical-align: baseline;\n" +
                        "            background: transparent;\n" +
                        "        }\n" +
                        "\n" +
                        "        h1 {\n" +
                        "            font-size: 2.5em;\n" +
                        "            background-color: #144a91;\n" +
                        "            color: white;\n" +
                        "            text-align: center;\n" +
                        "            padding: 10px 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        body {\n" +
                        "        / / background-color: #144a91;\n" +
                        "        }\n" +
                        "\n" +
                        "\n" +
                        "        .star-class {\n" +
                        "            padding: 2rem;\n" +
                        "            box-shadow: 0 0 5px #AAAAAA;\n" +
                        "            display: flex;\n" +
                        "            flex-direction: row;\n" +
                        "            align-items: center;\n" +
                        "            background: #DDEEFF;\n" +
                        "            border-radius: 10px;\n" +
                        "            font-family: 'Libre Franklin', sans-serif;\n" +
                        "            font-size: 1.2rem;\n" +
                        "            color: #144a91;\n" +
                        "            width: 50%;\n" +
                        "            margin: auto;\n" +
                        "            margin-top: 1em;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class .description {\n" +
                        "            font-family: 'Permanent Marker', cursive;\n" +
                        "            font-size: 2rem;\n" +
                        "        }\n" +
                        "        .description{\n" +
                        "            padding-top: 15px;\n" +
                        "            padding-bottom: 15px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class > div:first-child {\n" +
                        "            display: flex;\n" +
                        "            flex-direction: column;\n" +
                        "            align-items: center;\n" +
                        "            text-align: center;\n" +
                        "            width: 10%;\n" +
                        "            margin: 5%;\n" +
                        "            line-height: 1.6rem;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class > div:nth-child(2) {\n" +
                        "            max-width: 75%;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class img {\n" +
                        "            margin-bottom: .5rem;\n" +
                        "            border-radius: 50%;\n" +
                        "            border: 1px solid #144a91;\n" +
                        "            width: 100%;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class ul {\n" +
                        "            display: flex;\n" +
                        "            list-style: none;\n" +
                        "            padding: 0;\n" +
                        "            margin: 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class .sender {\n" +
                        "            font-weight: bold;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class ul li {\n" +
                        "            display: flex;\n" +
                        "            align-items: center;\n" +
                        "            padding: .4rem;\n" +
                        "            background: #3595f6;\n" +
                        "            border-radius: 3px;\n" +
                        "            margin: .3rem;\n" +
                        "            color: white;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class .material-icons {\n" +
                        "            margin: 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class b {\n" +
                        "            margin-right: .2rem;\n" +
                        "        }\n" +
                        "\n" +
                        "        .star-class th {\n" +
                        "            padding-right: 2rem;\n" +
                        "        }\n" +
                        "\n" +
                        "    </style>\n" +
                        "</header>\n" +
                        "<body>\n" +
                        "<head>\n" +
                        "    <h1>Stars4everyone</h1>\n" +
                        "</head>\n" +
                        "<article>\n" +
                        "    <div class=\"star-class\">\n" +
                        "        <div>\n" +
                        "            <img src=\"https://behaviour-driven-design.projectweek.be/static/imgs/star-small.png\" width=100%>\n" +
                        "            <span class=\"receiver\"><b>"+ star.getUserReceiver().getFirstName()+ " " + star.getUserReceiver().getLastname()+"</b></span>\n" +
                        "        </div>\n" +
                        "        <div>\n" +
                        "            <span class=\"sender\">You got a star from <b>"+ star.getUserSender().getFirstName()+ " " + star.getUserSender().getLastname() +"</b>! </span>\n" +
                        "            <p class=\"description\">"+ star.getDescription()+"</p>\n" +
                        "            <ul class=\"tag-list\">\n" +
                        //getTagHTML()
                        //+
                        "            </ul>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</article>\n" +
                        "</body>\n" +
                        "</html>";                try {
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

            }} catch (Exception e) {
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
