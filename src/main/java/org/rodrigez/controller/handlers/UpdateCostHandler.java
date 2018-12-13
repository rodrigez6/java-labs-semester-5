package org.rodrigez.controller.handlers;

import org.rodrigez.service.SpecificationService;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.view.form.UpdateCostForm;
import org.rodrigez.view.page.MessagePage;

public class UpdateCostHandler implements Handler {

    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);

    @Override
    public void execute(Request request) {

        new UpdateCostForm().execute(request);

        int cost = Integer.parseInt(request.getAttribute("cost"));
        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));
        int designerId = Integer.parseInt(request.getAttribute("authorized-id"));

        String message;
        try {
            specificationService.updateCost(designerId, specificationId, cost);
            message = resourceManager.getString("OK");
        } catch (NotFoundException e) {
            message = resourceManager.getString("Not_Found");
        } catch (NotAllowedException e) {
            message = resourceManager.getString("Not_Allowed");
        }

        new MessagePage().show(message);

        request.setAttribute("handler", "menu");
    }

}