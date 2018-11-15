package org.rodrigez.controller.handlers;

import org.rodrigez.model.Specification;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;

import java.util.Set;

public class GetManagerSpecificationsHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request) {
        int managerId = Integer.parseInt(request.getAttribute("authorized-id"));
        System.out.println("Specifications of employee#" + managerId);
        Set<Specification> specificationSet = specificationService.findAllByManagerId(managerId);
        System.out.println(Specification.header());
        for(Specification specification: specificationSet){
            System.out.println(specification.toString());
        }

        request.setAttribute("handler","menu");
    }
}
