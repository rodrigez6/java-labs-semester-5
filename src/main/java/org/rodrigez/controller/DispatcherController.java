package org.rodrigez.controller;

import org.apache.log4j.Logger;
import org.rodrigez.controller.handlers.Handler;
import org.rodrigez.util.HandlerMapping;
import org.rodrigez.util.Request;

public class DispatcherController {

    private final static Logger logger = Logger.getLogger(DispatcherController.class);

    synchronized public void execute(Request request){
        String path = request.getAttribute("handler");
        String session = request.getAttribute("session");
        Handler handler = HandlerMapping.getInstance().get(path);
        //logger.info("new request, session = " + session + ", path = " + path);
        handler.execute(request);
    }
}
