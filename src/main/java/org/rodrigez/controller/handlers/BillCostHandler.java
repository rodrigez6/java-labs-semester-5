package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;

import java.util.Scanner;

public class BillCostHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.print("Type specification id: ");
        int specificationId = scanner.nextInt();
        System.out.print("Type new design cost: ");
        int cost = scanner.nextInt();
        int designerId = Integer.parseInt(request.getAttribute("authorized-id"));
        specificationService.updateCost(designerId, specificationId, cost);

        request.setAttribute("handler", "menu");
    }
}