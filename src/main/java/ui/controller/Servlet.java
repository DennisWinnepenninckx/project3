package ui.controller;

import domain.Service.ShopService;
import domain.model.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    public ShopService shopService;
    HandlerFactory handlerFactory;

    public Servlet() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        Properties properties = new Properties();
        Enumeration<String> parameterNames = context.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String propertyName = parameterNames.nextElement();
            properties.setProperty(propertyName, context.getInitParameter(propertyName));
        }
        shopService = new ShopService(properties);
        handlerFactory = new HandlerFactory();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("command");
        System.out.println(request.getParameter("command"));
        if (action == null || action.isEmpty()) {
            action = "Home";
        }
        RequestHandler handler = handlerFactory.getController(action,shopService);
        System.out.println("in processrequest: " + handler.toString());
        try {
            handler.handleRequest(request, response);

        } catch (Exception e) {
            System.out.println(e);
            request.setAttribute("notAuthorized", "You have insufficient rights to have a look at the requested page.");
            handlerFactory.getController("Home",shopService).handleRequest(request, response);
        }
    }
}
