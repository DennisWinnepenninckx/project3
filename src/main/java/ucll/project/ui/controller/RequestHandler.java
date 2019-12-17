package ucll.project.ui.controller;

import ucll.project.domain.user.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler {
    private String command;
    private UserService userService;

    public RequestHandler(String command, UserService userService){
        setCommand(command);
        setUserService(userService);
    }

    private void setCommand(String command) {
        if (command == null || command.trim().isEmpty()){
            throw new ControllerException("Command is empty");
        }
        this.command = command;
    }

    private void setUserService(UserService userService){
        if (userService == null){
            throw new ControllerException("User service cannot be null.");
        }
        this.userService = userService;
    }

    public UserService getUserService(){ return userService; }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException;

    public String getCommand() {
        return command;
    }

    void forwardRequest(String destination, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }


}
