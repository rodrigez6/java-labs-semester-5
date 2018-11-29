package org.rodrigez.controller;

import org.apache.log4j.Logger;
import org.rodrigez.util.Request;

public class Session implements Runnable {

    private final static Logger logger = Logger.getLogger(Session.class);
    private DispatcherController dispatcherController;
    private Request request;

    public Session(int session, DispatcherController controller) {
        request = new Request();
        request.setAttribute("session", String.valueOf(session));
        request.setAttribute("handler", "menu");
        logger.info("dispatcher controller started , session = " + session);
        dispatcherController = controller;
    }

    public void run(){
        while(true){
            dispatcherController.execute(request);
        }
    }



}
