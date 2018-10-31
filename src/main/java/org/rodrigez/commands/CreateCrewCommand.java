package org.rodrigez.commands;

import org.rodrigez.model.Designer;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.service.DesignerService;
import org.rodrigez.view.View;

public class CreateCrewCommand extends Command {
    @Override
    public void execute(Request request) throws RequestException {
        View view = (View) request.getAttribute("view");
        Designer designer = (Designer) request.getAttribute("designer");
        view.print("Enter number of designers:\n");
        view.print("Number of designers: ");
        int numberOfDesigners = view.scanInt();
        Specification specification = (Specification) request.getAttribute("specification");
        DesignerService designerService = new DesignerService();
        designerService.createCrew(designer,numberOfDesigners,specification);
        String message = designer.getName() + " created new crew, consists " + numberOfDesigners + " designers";
        request.setAttribute("message", message);
        executeNext(request);
    }
}