package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.view.form.RegisterSpecificationForm;

public class RegisterSpecificationHandler extends Handler {

    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request){

        new RegisterSpecificationForm().execute(request);

        int designerId = Integer.parseInt(request.getAttribute("designer-id"));
        int managerId = Integer.parseInt(request.getAttribute("authorized-id"));

        specificationService.registerAll(managerId, designerId);

        request.setAttribute("handler", "menu");
    }
}