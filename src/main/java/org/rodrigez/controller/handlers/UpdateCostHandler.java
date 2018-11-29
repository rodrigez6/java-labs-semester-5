package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;
import org.rodrigez.view.form.UpdateCostForm;
import org.rodrigez.view.page.MessagePage;

public class UpdateCostHandler extends Handler {

    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request) {

        new UpdateCostForm().execute(request);

        int cost = Integer.parseInt(request.getAttribute("cost"));
        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));
        int designerId = Integer.parseInt(request.getAttribute("authorized-id"));

        String message;
        try {
            specificationService.updateCost(designerId, specificationId, cost);
            message = "Operation is successful";
        } catch (NotFoundException | NotAllowedException e) {
            message = e.getMessage();
        }

        new MessagePage().show(message);

        request.setAttribute("handler", "menu");
    }
}