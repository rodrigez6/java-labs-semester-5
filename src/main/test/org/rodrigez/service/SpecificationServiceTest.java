package org.rodrigez.service;

import org.junit.Before;
import org.junit.Test;
import org.rodrigez.model.Employee;
import org.rodrigez.model.Project;
import org.rodrigez.model.Role;
import org.rodrigez.model.Specification;
import org.rodrigez.model.dao.SpecificationDao;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SpecificationServiceTest {

    private SpecificationDao specificationDao;
    private SpecificationService specificationService;
    private EmployeeService employeeService;
    private Specification specification;

    @Before
    public void setUp() {
        specificationDao = mock(SpecificationDao.class);
        employeeService = mock(EmployeeService.class);
        specificationService = new SpecificationService(specificationDao,employeeService);

        specification = new Specification();

        Employee customer = new Employee();
        customer.setRole(Role.CUSTOMER);
        customer.setId(1);
        specification.setCustomer(customer);

        Employee manager = new Employee();
        manager.setRole(Role.MANAGER);
        manager.setId(2);
        specification.setManager(manager);

        Employee designer = new Employee();
        designer.setRole(Role.DESIGNER);
        designer.setId(3);
        specification.setDesigner(designer);
    }

    @Test
    public void create() throws NotFoundException {
        Project project = mock(Project.class);
        Employee customer = mock(Employee.class);
        Specification specification = mock(Specification.class);

        when(employeeService.findById(1)).thenReturn(customer);
        when(specificationDao.save(any())).thenReturn(specification);

        specificationService.create(project,1);
    }

    @Test
    public void updateCost_OK() {

        when(specificationDao.findById(1)).thenReturn(specification);

        Exception e = null;

        try {
            specificationService.updateCost(3,1,600);
        } catch (Exception e1) {
            e = e1;
        }

        assertNull(e);

        assertEquals(specification.getCost(),600);
    }

    @Test
    public void updateCrew_ERROR() {

        when(specificationDao.findById(1)).thenReturn(specification);

        Exception e = null;

        try {
            specificationService.updateCrew(2,1,600);
        } catch (Exception e1) {
            e = e1;
        }

        assertNotNull(e);
        assertTrue(e instanceof NotAllowedException);
        assertEquals(e.getMessage(),"Authorized is not designer of specification with id 1");
    }

    @Test
    public void registerAll_OK() throws NotFoundException {

        Set<Specification> specificationSet = Collections.singleton(specification);
        when(specificationDao.findNotRegistered()).thenReturn(specificationSet);
        when(employeeService.findById(2)).thenReturn(specification.getManager());
        when(employeeService.findById(3)).thenReturn(specification.getDesigner());

        Exception e = null;

        try {
            specificationService.registerAll(2,3);
        } catch (Exception e1){
            e = e1;
        }

        assertNull(e);
    }

    @Test
    public void registerAll_ERROR() throws NotFoundException {

        Set<Specification> specificationSet = Collections.singleton(specification);
        when(specificationDao.findNotRegistered()).thenReturn(specificationSet);
        when(employeeService.findById(1)).thenReturn(specification.getCustomer());
        when(employeeService.findById(3)).thenReturn(specification.getDesigner());

        Exception e = null;

        try {
            specificationService.registerAll(1,3);
        } catch (Exception e1){
            e = e1;
        }

        assertNotNull(e);
        assertTrue(e instanceof NotAllowedException);
        assertEquals(e.getMessage(), "Employee with id 1 is not manager");
    }
}