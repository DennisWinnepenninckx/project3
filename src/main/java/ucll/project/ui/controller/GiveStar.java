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
                String message = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\n" +
                        " <head> \n" +
                        "  <meta charset=\"UTF-8\"> \n" +
                        "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
                        "  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
                        "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
                        "  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
                        "  <title>New email</title> \n" +
                        "  <!--[if (mso 16)]>\n" +
                        "    <style type=\"text/css\">\n" +
                        "    a {text-decoration: none;}\n" +
                        "    </style>\n" +
                        "    <![endif]--> \n" +
                        "  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> \n" +
                        "  <style type=\"text/css\">\n" +
                        "@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:16px!important; line-height:150%!important } h1 { font-size:30px!important; text-align:center; line-height:120%!important } h2 { font-size:26px!important; text-align:center; line-height:120%!important } h3 { font-size:20px!important; text-align:center; line-height:120%!important } h1 a { font-size:30px!important } h2 a { font-size:26px!important } h3 a { font-size:20px!important } .es-menu td a { font-size:16px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } a.es-button { font-size:20px!important; display:block!important; border-width:10px 0px 10px 0px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } .es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } }\n" +
                        "#outlook a {\n" +
                        "\tpadding:0;\n" +
                        "}\n" +
                        ".ExternalClass {\n" +
                        "\twidth:100%;\n" +
                        "}\n" +
                        ".ExternalClass,\n" +
                        ".ExternalClass p,\n" +
                        ".ExternalClass span,\n" +
                        ".ExternalClass font,\n" +
                        ".ExternalClass td,\n" +
                        ".ExternalClass div {\n" +
                        "\tline-height:100%;\n" +
                        "}\n" +
                        ".es-button {\n" +
                        "\tmso-style-priority:100!important;\n" +
                        "\ttext-decoration:none!important;\n" +
                        "}\n" +
                        "a[x-apple-data-detectors] {\n" +
                        "\tcolor:inherit!important;\n" +
                        "\ttext-decoration:none!important;\n" +
                        "\tfont-size:inherit!important;\n" +
                        "\tfont-family:inherit!important;\n" +
                        "\tfont-weight:inherit!important;\n" +
                        "\tline-height:inherit!important;\n" +
                        "}\n" +
                        ".es-desk-hidden {\n" +
                        "\tdisplay:none;\n" +
                        "\tfloat:left;\n" +
                        "\toverflow:hidden;\n" +
                        "\twidth:0;\n" +
                        "\tmax-height:0;\n" +
                        "\tline-height:0;\n" +
                        "\tmso-hide:all;\n" +
                        "}\n" +
                        "</style> \n" +
                        " </head> \n" +
                        " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\"> \n" +
                        "  <div class=\"es-wrapper-color\" style=\"background-color:#144a91;padding: 100px\">\n" +
                        "   <!--[if gte mso 9]>\n" +
                        "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                        "\t\t\t\t<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
                        "\t\t\t</v:background>\n" +
                        "\t\t<![endif]--> \n" +
                        "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\"> \n" +
                        "     <tr style=\"border-collapse:collapse;\"> \n" +
                        "      <td valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
                        "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
                        "         <tr style=\"border-collapse:collapse;\"> \n" +
                        "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
                        "           <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
                        "             <tr style=\"border-collapse:collapse;\"> \n" +
                        "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;\"> \n" +
                        "               <!--[if mso]><table width=\"560\" cellpadding=\"0\"\n" +
                        "                            cellspacing=\"0\"><tr><td width=\"180\" valign=\"top\"><![endif]--> \n" +
                        "               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
                        "                 <tr style=\"border-collapse:collapse;\"> \n" +
                        "                  <td class=\"es-m-p0r es-m-p20b\" width=\"180\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
                        "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                        "                     <tr style=\"border-collapse:collapse;\"> \n" +
                        "                      <td align=\"center\" style=\"padding:0;Margin:0;\"><img class=\"adapt-img\" src=\"https://behaviour-driven-design.projectweek.be/static/imgs/star.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\" width=\"180\"></td> \n" +
                        "                     </tr> \n" +
                        "                   </table></td> \n" +
                        "                 </tr> \n" +
                        "               </table> \n" +
                        "               <!--[if mso]></td><td width=\"20\"></td><td width=\"360\" valign=\"top\"><![endif]--> \n" +
                        "               <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                        "                 <tr style=\"border-collapse:collapse;\"> \n" +
                        "                  <td width=\"360\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
                        "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                        "                     <tr style=\"border-collapse:collapse;\"> \n" +
                        "                      <td align=\"left\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;\">You just received a star from <b>" + star.getUserSender().getFirstName() + " " + star.getUserSender().getLastname() + "</b><br></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;\"><br></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;\"><br></p>" +
                        generateTag(star) +
                        "                     </tr> \n" +
                        "                   </table></td> \n" +
                        "                 </tr> \n" +
                        "               </table> \n" +
                        "               <!--[if mso]></td></tr></table><![endif]--></td> \n" +
                        "             </tr> \n" +
                        "             <tr style=\"border-collapse:collapse;\"> \n" +
                        "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;\"> \n" +
                        "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                        "                 <tr style=\"border-collapse:collapse;\"> \n" +
                        "                  <td width=\"560\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
                        "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                        "                     <tr style=\"border-collapse:collapse;\"> \n" +
                        "                      <td align=\"left\" style=\"padding:0;Margin:0;\">" + star.getDescription() + "<br></td> \n" +
                        "                     </tr> \n" +
                        "                   </table></td> \n" +
                        "                 </tr> \n" +
                        "               </table></td> \n" +
                        "             </tr> \n" +
                        "             <tr style=\"border-collapse:collapse;\"> \n" +
                        "              <td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:20px;padding-right:20px;\"> \n" +
                        "               <!--[if mso]><table width=\"560\" cellpadding=\"0\" \n" +
                        "                        cellspacing=\"0\"><tr><td width=\"270\" valign=\"top\"><![endif]--> \n" +
                        "               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
                        "                 <tr style=\"border-collapse:collapse;\"> \n" +
                        "                  <td class=\"es-m-p20b\" width=\"270\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
                        "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                        "                     <tr style=\"border-collapse:collapse;\"> \n" +
                        "                      <td style=\"padding:0;Margin:0;display:none;\" align=\"center\"></td> \n" +
                        "                     </tr> \n" +
                        "                   </table></td> \n" +
                        "                 </tr> \n" +
                        "               </table> \n" +
                        "               <!--[if mso]></td><td width=\"20\"></td><td width=\"270\" valign=\"top\"><![endif]--> \n" +
                        "               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right;\"> \n" +
                        "                 <tr style=\"border-collapse:collapse;\"> \n" +
                        "                  <td width=\"270\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
                        "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                        "                     <tr style=\"border-collapse:collapse;\"> \n" +
                        "                      <td style=\"padding:0;Margin:0;display:none;\" align=\"center\"></td> \n" +
                        "                     </tr> \n" +
                        "                   </table></td> \n" +
                        "                 </tr> \n" +
                        "               </table> \n" +
                        "               <!--[if mso]></td></tr></table><![endif]--></td> \n" +
                        "             </tr> \n" +
                        "           </table></td> \n" +
                        "         </tr> \n" +
                        "       </table></td> \n" +
                        "     </tr> \n" +
                        "   </table> \n" +
                        "  </div>  \n" +
                        " </body>\n" +
                        "</html>";
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

            }} catch (Exception e) {
                errors.add("no tags added");
            }
            if (errors.size() != 0) {
                try {
                    request.setAttribute("errors", errors);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            } else {
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
    public String generateTag(Star star){
        String tags = "\n";
        for(String s:star.getTags()){
            tags += "<p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;\">-" + s + "</p></td> \n";
        }
        return tags;
    }
}

class Tag {
    private String value;
    private String style;

    public String getValue() {
        return value;
    }
}
