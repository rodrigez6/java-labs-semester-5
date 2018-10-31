package org.rodrigez.commands;

import org.rodrigez.model.Manager;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.service.ManagerService;

public class RegisterSpecificationCommand extends Command {
    @Override
    public String execute(Request request) throws RequestException {
        try {
            Manager manager = (Manager) request.getAttribute("manager");
            Specification specification = (Specification) request.getAttribute("specification");
            ManagerService managerService = new ManagerService();
            managerService.registerSpecification(manager,specification);
            String oldmsg = (String) request.getAttribute("message");
            String msg = manager.getName() + " registered new specification for project :\n   " + specification.getProject().getDescription();
            request.setAttribute("message", oldmsg + "\n" + msg);
        } catch (RequestException e){
            request.setAttribute("message",e.toString());
            return "error";
        }
        return executeNext(request);
    }
}
