package org.rodrigez.commands;

import org.rodrigez.model.BuildingProject;
import org.rodrigez.model.BuildingProjectException;
import org.rodrigez.model.Project;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.validator.BuildingProjectValidator;
import org.rodrigez.validator.Validator;
import org.rodrigez.view.View;

public class CreateBuildingProjectCommand extends Command {

    @Override
    public void execute(Request request){
        Project project;
        try{
            do {
                View view = (View) request.getAttribute("view");
                project = (Project) view.read(BuildingProject.class);
                Validator validator = new BuildingProjectValidator();
                try {
                    validator.validate(project);
                    break;
                }
                catch (BuildingProjectException e) {
                    e.printStackTrace();
                    view.write("Create again. Wrong params!\n");
                }
            } while (true);
            request.setAttribute("project", project);
            request.setAttribute("message", "Project created successfully\n");
        } catch (RequestException e){
            request.setAttribute("message",e.getMessage());
        }

    }
}