package org.rodrigez.commands;

import org.rodrigez.model.Designer;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.service.DesignerService;

public class CreateCrewCommand extends Command {
    @Override
    public String execute(Request request) throws RequestException {
        try{
            Designer designer = (Designer) request.getAttribute("designer");
            Integer numberOfDesigners = (Integer) request.getAttribute("numberofdesigners");
            Specification specification = (Specification) request.getAttribute("specification");
            DesignerService designerService = new DesignerService();
            designerService.createCrew(designer,numberOfDesigners,specification);
            String oldmsg = (String) request.getAttribute("message");
            String msg = designer.getName() + " created new crew, consists " + numberOfDesigners + " designers";
            request.setAttribute("message", oldmsg + "\n" + msg);
        } catch (RequestException e){
            request.setAttribute("message",e.toString());
            return "error";
        }
        return executeNext(request);
    }
}
