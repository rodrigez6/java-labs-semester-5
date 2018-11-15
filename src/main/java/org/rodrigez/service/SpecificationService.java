package org.rodrigez.service;

import org.rodrigez.model.*;
import org.rodrigez.model.dao.SpecificationDao;
import org.rodrigez.util.BeanStorage;

import java.util.Set;

public class SpecificationService {
    private SpecificationDao specificationDao = BeanStorage.INSTANCE.get(SpecificationDao.class);
    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);


    public void create(Project project, Integer customerId){
        Specification specification = new Specification();
        Employee customer = employeeService.findById(customerId);
        specification.setCustomer(customer);
        specification.setProject(project);
        specificationDao.save(specification);
    }

    public Specification findById(Integer specificationId){
        return specificationDao.findById(specificationId);
    }

    public Set<Specification> findAllByCustomerId(Integer customerId){
        return specificationDao.findByCustomerId(customerId);
    }

    public Set<Specification> findAllByManagerId(Integer managerId){
        return specificationDao.findByManagerId(managerId);
    }

    public Set<Specification> findAllByDesignerId(int designerId) {
        return specificationDao.findByDesignerId(designerId);
    }

    private Set<Specification> findNotRegistered(){
        return specificationDao.findNotRegistered();
    }


    public boolean updateCost(int designerId, Integer specificationId, int cost){
        Specification specification = findById(specificationId);
        if(specification!=null&&specification.getDesigner()!=null&&specification.getDesigner().getId()==designerId){
            specification.setCost(cost);
            specificationDao.save(specification);
            return true;
        }
        return false;
    }

    public boolean updateCrew(int designerId, Integer specificationId, int size){
        Specification specification = findById(specificationId);
        if(specification!=null&&specification.getDesigner()!=null&&specification.getDesigner().getId()==designerId){
            DesignersCrew crew = new DesignersCrew(size);
            specification.setDesignersCrew(crew);
            specificationDao.save(specification);
            return true;
        }
        return false;
    }

    public void registerAll(int managerId, int designerId) {
        Set<Specification> specificationSet = findNotRegistered();
        Employee designer = employeeService.findById(designerId);
        Employee manager = employeeService.findById(managerId);
        for(Specification specification: specificationSet){
            specification.setManager(manager);
            specification.setRegistered(true);
            specification.setDesigner(designer);
            specificationDao.save(specification);
        }
    }

}