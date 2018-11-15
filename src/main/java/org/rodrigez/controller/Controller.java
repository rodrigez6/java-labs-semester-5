package org.rodrigez.controller;

import org.rodrigez.controller.handlers.*;
import org.rodrigez.util.HandlerManager;
import org.rodrigez.util.Request;

public class Controller {

    public void execute(Request request){
        String path = request.getAttribute("handler");
        Handler handler = HandlerManager.getInstance().get(path);
        handler.execute(request);
    }

    public void runMenu(){
        Request request = new Request();
        request.setAttribute("handler", "menu");
        while(true){
            this.execute(request);
        }
    }
}
