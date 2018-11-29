package org.rodrigez.service;

import org.rodrigez.model.*;
import org.rodrigez.model.dao.SpecificationDao;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;

import java.util.Set;

public class SpecificationService {

    private SpecificationDao specificationDao;
    private EmployeeService employeeService;

    public SpecificationService(SpecificationDao specificationDao, EmployeeService employeeService) {
        this.specificationDao = specificationDao;
        this.employeeService = employeeService;
    }

    public Specification findById(Integer specificationId) throws NotFoundException {

        Specification specification = specificationDao.findById(specificationId);

        if(specification==null)
            throw new NotFoundException("Specification not found with id " + specificationId);

        return specification;
    }
    public void create(Project project, Integer customerId) throws NotFoundException {
        Specification specification = new Specification();
        Employee customer = employeeService.findById(customerId);
        specification.setCustomer(customer);
        specification.setProject(project);
        specificationDao.save(specification);
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


    public void updateCost(int authorizedId, Integer specificationId, int cost)
            throws NotFoundException, NotAllowedException {

        Specification specification = findById(specificationId);

        if(specification.getDesigner().getId()!=authorizedId)
            throw new NotAllowedException("Authorized is not designer of specification with id " + specificationId);

        specification.setCost(cost);
        specificationDao.save(specification);
    }

    public void updateCrew(int authorizedId, Integer specificationId, int size)
            throws NotFoundException, NotAllowedException {

        Specification specification = findById(specificationId);

        if(specification.getDesigner().getId()!=authorizedId)
            throw new NotAllowedException("Authorized is not designer of specification with id " + specificationId);

        DesignersCrew crew = new DesignersCrew(size);
        specification.setDesignersCrew(crew);
        specificationDao.save(specification);
    }

    public void registerAll(int managerId, int designerId) throws NotFoundException, NotAllowedException {

        Set<Specification> specificationSet = findNotRegistered();

        Employee designer = employeeService.findById(designerId);
        if(designer.getRole()!=Role.DESIGNER)
            throw new NotAllowedException("Employee with id " + designerId + " is not designer");

        Employee manager = employeeService.findById(managerId);
        if(manager.getRole()!=Role.MANAGER)
            throw new NotAllowedException("Employee with id " + managerId + " is not manager");

        for(Specification specification: specificationSet) {
            registerSpecification(specification,manager,designer);
        }
    }

    private void registerSpecification(Specification specification, Employee manager, Employee designer){
        specification.setManager(manager);
        specification.setRegistered(true);
        specification.setDesigner(designer);
        specificationDao.save(specification);
    }
}