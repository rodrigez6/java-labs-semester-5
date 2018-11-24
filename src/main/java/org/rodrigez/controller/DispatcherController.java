package org.rodrigez.controller;

import org.rodrigez.controller.handlers.*;
import org.rodrigez.util.HandlerMapping;
import org.rodrigez.util.Request;

public class DispatcherController {

    public void execute(Request request){
        String path = request.getAttribute("handler");
        Handler handler = HandlerMapping.getInstance().get(path);
        handler.execute(request);
        //String message = request.getAttribute("message");
        //System.out.println(message);
    }

    public void runMenu(){
        Request request = new Request();
        request.setAttribute("handler", "menu");
        while(true){
            this.execute(request);
        }
    }
}
