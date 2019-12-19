package extra;

public class mailtest {
    public static void main(String[] args) {

        String message = "" +
                "<!DOCTYPE html>\n" +
                "<html><head>\n" +
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\"></head><body><header>\n" +
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
                "\n" +
                "\n" +
                "    <h1>Stars4everyone</h1>\n" +
                "\n" +
                "<article>\n" +
                "    <div class=\"star-class\">\n" +
                "        <div>\n" +
                "            <img src=\"https://behaviour-driven-design.projectweek.be/static/imgs/star-small.png\">\n" +
                "            <span class=\"receiver\"><b>\"receiver\"</b></span>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <span class=\"sender\">You got a star from <b>\"sender\"</b>! </span>\n" +
                "            <p class=\"description\">\"Description\"</p>\n" +
                "            <ul class=\"tag-list\">\n" +
                "                <li>Tag</li>\n" +
                "                <li>Tag</li>\n" +
                "                <li>Tag</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</article>\n" +
                "\n" +
                "</body></html>";
        try {
            SimpleMail.send("dennisw@live.be",message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
