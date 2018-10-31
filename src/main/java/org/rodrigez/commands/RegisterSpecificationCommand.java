package org.rodrigez.commands;

import org.rodrigez.model.Manager;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.service.ManagerService;

public class RegisterSpecificationCommand extends Command {
    @Override
    public void execute(Request request) throws RequestException{
        Manager manager = (Manager) request.getAttribute("manager");
        Specification specification = (Specification) request.getAttribute("specification");
        ManagerService managerService = new ManagerService();
        managerService.registerSpecification(manager,specification);
        String message = manager.getName() + " registered new specification for project :\n   " + specification.getProject().getDescription() + "\n";
        request.setAttribute("message", message);
        executeNext(request);
    }
}
