package ui.controller;
import domain.Service.ShopService;
import java.lang.reflect.InvocationTargetException;
public class HandlerFactory {
        public RequestHandler getController(String key,ShopService service) {
            return createHandler(key,service);
        }


        private RequestHandler createHandler(String handlerName, ShopService service) {
            System.out.println("handelname: " + handlerName);
            RequestHandler handler = null;
            try {
                Class<?> handlerClass = Class.forName("ui.controller." + handlerName);
                Object handlerObject = handlerClass.getConstructor().newInstance();
                handler = (RequestHandler) handlerObject;
                handler.setService(service);
            } catch (Exception e) {
                throw new RuntimeException("The requested page doesn’t exist");
            }
            return handler;
        }
}