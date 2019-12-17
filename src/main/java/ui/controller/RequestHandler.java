package ui.controller;

import domain.Service.ShopService;
import domain.db.PersonDb;
import domain.db.PersonSQL;
import domain.db.ProductSQL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler {
    ShopService shopService;
    public ShopService getService() {
        return shopService;
    }

    public void setService(ShopService service) {
        this.shopService = service;
    }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}