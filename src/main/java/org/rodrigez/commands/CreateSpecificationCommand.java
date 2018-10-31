package org.rodrigez.commands;

import org.rodrigez.model.Project;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;

public class CreateSpecificationCommand extends Command {
    @Override
    public void execute(Request request){
        try {
            Project project = (Project) request.getAttribute("project");
            Specification specification = new Specification(project);
            request.setAttribute("specification", specification);
            String message = "Specification created successfully\n";
            request.setAttribute("message", message);
        } catch (RequestException e){
            request.setAttribute("message",e.getMessage());
        }
    }
}
