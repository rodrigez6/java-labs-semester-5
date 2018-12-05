package org.rodrigez.controller.handlers;

import org.rodrigez.model.Specification;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.view.page.SpecificationSetPage;

import java.util.Set;

public class GetManagerSpecificationsHandler implements Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request) {

        int authorizedId = Integer.parseInt(request.getAttribute("authorized-id"));

        Set<Specification> specificationSet = specificationService.findAllByManagerId(authorizedId);

        new SpecificationSetPage().show(specificationSet);

        request.setAttribute("handler","menu");
    }

}
