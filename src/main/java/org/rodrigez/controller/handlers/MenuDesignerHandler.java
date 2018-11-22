package org.rodrigez.controller.handlers;

import org.rodrigez.util.Request;
import org.rodrigez.view.form.MenuDesignerForm;

public class MenuDesignerHandler extends Handler {

    @Override
    public void execute(Request request) {

        new MenuDesignerForm().execute(request);

        int c = Integer.parseInt(request.getAttribute("menu-choice"));
        switch (c){
            case 1: {
                request.setAttribute("handler","get-designer-specifications");
                break;
            }
            case 2: {
                request.setAttribute("handler","update-cost");
                break;
            }
            case 3: {
                request.setAttribute("handler","update-crew");
                break;
            }
            case 4: {
                request.setAttribute("handler","save-specification");
                break;
            }
            case 5: {
                request.setAttribute("handler","logout");
                break;
            }
        }
    }
}