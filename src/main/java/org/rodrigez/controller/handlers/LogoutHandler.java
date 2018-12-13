package org.rodrigez.controller.handlers;

import org.apache.log4j.Logger;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.view.page.MessagePage;

public class LogoutHandler implements Handler {

    private final static Logger logger = Logger.getLogger(LogoutHandler.class);
    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);

    @Override
    public void execute(Request request) {

        request.setAttribute("authorized","false");
        request.setAttribute("authorized-id",null);

        String message = resourceManager.getString("Log_Out_OK");

        logger.info(message);

        new MessagePage().show(message);

        request.setAttribute("handler","menu");
    }

}
