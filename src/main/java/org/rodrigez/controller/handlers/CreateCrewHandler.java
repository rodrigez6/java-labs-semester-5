package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;

import java.util.Scanner;

public class CreateCrewHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request){
        System.out.print("Type specification id: ");
        int specificationId = scanner.nextInt();
        System.out.print("Type new crew size: ");
        int size = scanner.nextInt();
        int designerId = Integer.parseInt(request.getAttribute("authorized-id"));
        if(specificationService.updateCrew(designerId, specificationId, size)){
            System.out.println("Crew size updated");
        } else {
            System.out.println("Invalid specification Id");
        }

        request.setAttribute("handler", "menu");
    }
}