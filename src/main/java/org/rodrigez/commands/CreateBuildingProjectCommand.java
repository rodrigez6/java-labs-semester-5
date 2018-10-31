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
    public void execute(Request request) throws RequestException {
        Project project;
        do {
            View view = (View) request.getAttribute("view");
            int floorsNumber = Integer.parseInt((String) view.read("Floors number: "));
            int housingClass = Integer.parseInt((String) view.read("Housing class(1,2,3): "));
            String address = (String) view.read("Address: ");
            project = new BuildingProject(floorsNumber,housingClass,address);
            Validator validator = new BuildingProjectValidator();
            try {
                validator.validate(project);
                break;
            }
            catch (BuildingProjectException e) {
                e.printStackTrace();
                view.print("Create again. Wrong params!\n");
            }
        } while (true);
        request.setAttribute("project", project);
        request.setAttribute("message", "Project created successfully\n");
        executeNext(request);
    }
}