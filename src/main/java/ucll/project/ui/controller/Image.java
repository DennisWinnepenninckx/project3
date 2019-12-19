package ucll.project.ui.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ucll.project.db.DBController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

public class Image extends RequestHandler{

    public Image(String command, DBController userService) {
        super(command, userService);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> images = sf.parseRequest(request);
        for(FileItem item : images){
            item.write(new File(item.getName()));
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
