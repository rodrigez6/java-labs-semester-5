package org.rodrigez.service;

import org.rodrigez.model.*;

public class DesignerService {

    public void bill(Designer designer,Specification specification){
        double cost = calculateCost(specification);
        specification.setCost(cost);
    }

    private double calculateCost(Specification specification){
        return CostCalculator.calculateConstructionCost(specification) +
                CostCalculator.calculateDesignCost(specification);
    }

    public void createCrew(Designer designer,Specification specification){
        int numberOfDesigners = (int) (specification.getCost());
        DesignersCrew designersCrew = new DesignersCrew(numberOfDesigners);
        specification.setDesignersCrew(designersCrew);
    }

    static class CostCalculator {
        static double calculateDesignCost(Specification spec){
            Project project = spec.getProject();
            if(project instanceof BuildingProject){
                return ((BuildingProject) project).getFloorsNumber()*((BuildingProject) project).getHousingClass();
            } else {
                throw new ClassCastException();
            }
        }

        static double calculateConstructionCost(Specification spec){
            Project project = spec.getProject();
            if(project instanceof BuildingProject){
                return ((BuildingProject) project).getFloorsNumber()*((BuildingProject) project).getHousingClass()*10;
            } else {
                throw new ClassCastException();
            }
        }
    }

}
