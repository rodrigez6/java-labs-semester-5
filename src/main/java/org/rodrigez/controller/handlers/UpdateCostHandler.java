package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.view.form.UpdateCostForm;

public class UpdateCostHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request) {

        new UpdateCostForm().execute(request);

        int cost = Integer.parseInt(request.getAttribute("cost"));
        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));
        int designerId = Integer.parseInt(request.getAttribute("authorized-id"));

        if(specificationService.updateCost(designerId, specificationId, cost)){
            System.out.println("Cost updated");
        } else {
            System.out.println("Invalid specification Id");
        }

        request.setAttribute("handler", "menu");
    }
}