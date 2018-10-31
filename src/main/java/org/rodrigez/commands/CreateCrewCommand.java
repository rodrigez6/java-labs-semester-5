package org.rodrigez.commands;

import org.rodrigez.model.Designer;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.service.DesignerService;

public class CreateCrewCommand extends Command {
    @Override
    public void execute(Request request){
        try{
            Designer designer = (Designer) request.getAttribute("designer");
            Specification specification = (Specification) request.getAttribute("specification");
            DesignerService designerService = new DesignerService();
            designerService.createCrew(designer,specification);
            int crewSize = specification.getDesignersCrew().getDesigners().size();
            String message = designer.getName() + " created new crew, consists " + crewSize + " designers";
            request.setAttribute("message", message);
        } catch (RequestException e){
            request.setAttribute("message", e.getMessage());
        }

    }
}