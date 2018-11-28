package org.rodrigez.controller;

import org.apache.log4j.Logger;
import org.rodrigez.controller.handlers.*;
import org.rodrigez.util.HandlerMapping;
import org.rodrigez.util.Request;

public class DispatcherController {

    private final static Logger logger = Logger.getLogger(DispatcherController.class);

    public void execute(Request request){
        String path = request.getAttribute("handler");
        Handler handler = HandlerMapping.getInstance().get(path);
        handler.execute(request);
    }

    public void run(){
        Request request = new Request();
        request.setAttribute("handler", "menu");
        logger.info("Dispatcher controller started");
        while(true){
            this.execute(request);
        }
    }
}
