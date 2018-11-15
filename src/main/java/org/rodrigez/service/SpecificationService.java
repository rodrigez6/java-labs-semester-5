package org.rodrigez.service;

import org.rodrigez.model.*;
import org.rodrigez.repository.SpecificationRepository;
import org.rodrigez.util.BeanStorage;

import java.util.Set;

public class SpecificationService {
    private SpecificationRepository specificationRepository = BeanStorage.INSTANCE.get(SpecificationRepository.class);
    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);


    public void create(Project project, Integer customerId){
        Specification specification = new Specification();
        Employee customer = employeeService.findById(customerId);
        specification.setCustomer(customer);
        specification.setProject(project);
        specificationRepository.save(specification);
    }

    public Specification findById(Integer specificationId){
        return specificationRepository.findById(specificationId);
    }

    public Set<Specification> findAllByCustomerId(Integer customerId){
        return specificationRepository.findByCustomerId(customerId);
    }

    public Set<Specification> findAllByManagerId(Integer managerId){
        return specificationRepository.findByManagerId(managerId);
    }

    public Set<Specification> findAllByDesignerId(int designerId) {
        return specificationRepository.findByDesignerId(designerId);
    }

    private Set<Specification> findNotRegistered(){
        return specificationRepository.findNotRegistered();
    }


    public void updateCost(int designerId, Integer specificationId, int cost){
        Specification specification = findById(specificationId);
        if(specification.getDesigner()!=null&&specification.getDesigner().getId()==designerId){
            specification.setCost(cost);
            specificationRepository.save(specification);
        }
    }

    public void updateCrew(int designerId, Integer specificationId, int size){
        Specification specification = findById(specificationId);
        if(specification.getDesigner()!=null&&specification.getDesigner().getId()==designerId){
            DesignersCrew crew = new DesignersCrew(size);
            specification.setDesignersCrew(crew);
            specificationRepository.save(specification);
        }
    }

    public void registerAll(int managerId, int designerId) {
        Set<Specification> specificationSet = findNotRegistered();
        Employee designer = employeeService.findById(designerId);
        Employee manager = employeeService.findById(managerId);
        for(Specification specification: specificationSet){
            specification.setManager(manager);
            specification.setRegistered(true);
            specification.setDesigner(designer);
            specificationRepository.save(specification);
        }
    }

}