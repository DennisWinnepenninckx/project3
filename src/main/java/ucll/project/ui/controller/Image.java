package ucll.project.ui.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ucll.project.db.DBController;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

//@MultipartConfig
public class Image extends RequestHandler {

    public Image(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        System.out.println("imagehandler");
        try {
            ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> images = sf.parseRequest(request);
            for (FileItem item : images) {
                item.write(new File(item.getName()));
            }
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
        System.out.println("eind imagehandler");
        /*Part filePart = request.getPart("file");
        String fileName = getSubmittedFileName(filePart);
        InputStream fileContent = filePart.getInputStream();

        //uploadToDatabase(fileName,fileContent);
        request.getRequestDispatcher("index.jsp").forward(request,response);*/
    }

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }


}


