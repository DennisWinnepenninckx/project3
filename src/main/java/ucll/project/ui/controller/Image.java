package ucll.project.ui.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ucll.project.db.DBController;
import ucll.project.domain.user.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;

public class Image extends RequestHandler {

    public Image(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        try {
            ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> images = sf.parseRequest(request);

            String path = System.getProperty("catalina.home") + "\\";
            String fileName = "";

            for (FileItem item : images) {
                fileName = item.getName();
                item.write(new File(path + item.getName()));
            }

            User user = (User) request.getSession().getAttribute("user");
            user.setProfilepic(fileName);
            getUserService().updatePic(user);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        response.sendRedirect("Controller?command=Profile");
    }
}


