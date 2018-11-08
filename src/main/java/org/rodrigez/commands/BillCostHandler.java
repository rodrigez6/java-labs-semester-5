package org.rodrigez.commands;

import org.rodrigez.routing.BeanStorage;
import org.rodrigez.routing.Request;
import org.rodrigez.service.SpecificationService;

public class BillCostHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request) {
        int designerId = Integer.parseInt(request.getAttribute("designer-id"));
        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));
        specificationService.updateDesigner(specificationId,designerId);
        specificationService.updateCost(specificationId);
        String alert = "Designer bill cost for specification";
        request.setAttribute("alert",alert);
    }
}