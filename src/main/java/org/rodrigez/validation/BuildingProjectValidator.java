package org.rodrigez.validation;

import org.rodrigez.model.BuildingProject;
import org.rodrigez.model.BuildingProjectException;

public class BuildingProjectValidator implements Validator{
    @Override
    public void validate(Object o) throws BuildingProjectException {
        BuildingProject project = (BuildingProject) o;
        if(project.getFloorsNumber()<=0){
            throw new BuildingProjectException("Floors number must be more than 0");
        }
        if(project.getHousingClass()<=0||project.getHousingClass()>3){
            throw new BuildingProjectException("Housing class must be from 1 to 3");
        }
    }
}
