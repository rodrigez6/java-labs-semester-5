package org.rodrigez.service;

import org.rodrigez.model.*;
import org.rodrigez.repository.SpecificationRepository;
import org.rodrigez.routing.BeanStorage;

public class SpecificationService {
    private SpecificationRepository specificationRepository = BeanStorage.INSTANCE.get(SpecificationRepository.class);
    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);


    public Specification create(Project project){
        Specification specification = new Specification();
        specification.setProject(project);
        return specificationRepository.save(specification);
    }

    private Specification findById(Integer specificationId){
        return specificationRepository.findById(specificationId);
    }

    public void updateDesigner(Integer specificationId, Integer designerId){
        Specification specification = findById(specificationId);
        Designer designer = (Designer) employeeService.findById(designerId);
        specification.setDesigner(designer);
        specificationRepository.save(specification);
    }

    public void updateCost(Integer specificationId){
        Specification specification = findById(specificationId);
        int cost = EmployeeService.DesignerCalculator.constructionCost();
        specification.setCost(cost);
        specificationRepository.save(specification);
    }

    public void updateCrew(Integer specificationId){
        Specification specification = findById(specificationId);
        int crewSize = EmployeeService.DesignerCalculator.crewSize();
        DesignersCrew crew= new DesignersCrew(crewSize);
        specification.setDesignersCrew(crew);
        specificationRepository.save(specification);
    }

    public void updateManager(Integer specificationId, int managerId){
        Specification specification = findById(specificationId);
        Manager manager = (Manager) employeeService.findById(managerId);
        specification.setManager(manager);
        specificationRepository.save(specification);
    }

    public void updateProvided(int specificationId){
        Specification specification = findById(specificationId);
        specification.setProvided(true);
        specificationRepository.save(specification);
    }

    public void updateRegistered(int specificationId) {
        Specification specification = findById(specificationId);
        specification.setRegistered(true);
        specificationRepository.save(specification);
    }
}