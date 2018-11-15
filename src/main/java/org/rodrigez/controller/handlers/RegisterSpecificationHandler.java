package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;

import java.util.Scanner;

public class RegisterSpecificationHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void execute(Request request){
        System.out.print("Type designer id: ");
        int designerId = scanner.nextInt();
        int managerId = Integer.parseInt(request.getAttribute("authorized-id"));
        System.out.print("Registering all specifications and redirecting them to designer\n");
        specificationService.registerAll(managerId, designerId);

        request.setAttribute("handler", "menu");
    }
}
