package org.rodrigez.controller.handlers.menu;

import org.rodrigez.controller.handlers.Handler;
import org.rodrigez.util.Request;
import org.rodrigez.view.form.MenuCustomerForm;
import org.rodrigez.view.page.MessagePage;

public class MenuCustomerHandler extends Handler {

    @Override
    public void execute(Request request) {

        new MenuCustomerForm().execute(request);

        int c = Integer.parseInt(request.getAttribute("menu-choice"));

        switch (c) {
            case 1: {
                request.setAttribute("handler", "get-customer-specifications"); break;
            }
            case 2: {
                request.setAttribute("handler", "add-specification"); break;
            }
            case 3: {
                request.setAttribute("handler", "save-specification"); break;
            }
            case 4: {
                request.setAttribute("handler", "logout"); break;
            }
            default: {
                String message = "Unsupported operation";
                new MessagePage().show(message);
            }
        }
    }
}