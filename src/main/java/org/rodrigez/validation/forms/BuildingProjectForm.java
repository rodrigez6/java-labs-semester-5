package org.rodrigez.validation.forms;

import org.rodrigez.model.BuildingProject;
import org.rodrigez.model.BuildingProjectException;

public class BuildingProjectForm {
    private String floorsNumber;
    private String housingClass;
    private String address;

    public BuildingProjectForm(String floorsNumber, String housingClass, String address) {
        this.floorsNumber = floorsNumber;
        this.housingClass = housingClass;
        this.address = address;
    }

    public BuildingProject parseForm(){
        BuildingProject buildingProject = new BuildingProject();
        buildingProject.setFloorsNumber(Integer.parseInt(floorsNumber));
        buildingProject.setHousingClass(Integer.parseInt(housingClass));
        buildingProject.setAddress(address);
        return buildingProject;
    }

    boolean isValid(BuildingProject project) throws BuildingProjectException {
        if(project.getFloorsNumber()<=0){
            return false;
            //throw new BuildingProjectException("Floors number must be more than 0");

        }
        if(project.getHousingClass()<=0||project.getHousingClass()>3){
            return false;
            //throw new BuildingProjectException("Housing class must be from 1 to 3");
        }
        return true;
    }
}
