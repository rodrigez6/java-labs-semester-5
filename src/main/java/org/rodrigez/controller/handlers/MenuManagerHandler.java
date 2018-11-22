package org.rodrigez.controller.handlers;

import org.rodrigez.util.Request;
import org.rodrigez.view.form.MenuManagerForm;

public class MenuManagerHandler extends Handler {

    @Override
    public void execute(Request request) {

        new MenuManagerForm().execute(request);

        int c = Integer.parseInt(request.getAttribute("menu-choice"));
        switch (c){
            case 1: {
                request.setAttribute("handler","get-manager-specifications");
                break;
            }
            case 2: {
                request.setAttribute("handler","register-specifications");
                break;
            }
            case 3: {
                request.setAttribute("handler","save-specification");
                break;
            }
            case 4: {
                request.setAttribute("handler","logout");
                break;
            }
            default: {
                break;
            }
        }
    }
}
