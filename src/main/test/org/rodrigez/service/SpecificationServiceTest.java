package org.rodrigez.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.rodrigez.model.Employee;
import org.rodrigez.model.Project;
import org.rodrigez.model.Role;
import org.rodrigez.model.Specification;
import org.rodrigez.model.dao.SpecificationDao;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SpecificationServiceTest {

    private SpecificationDao specificationDao;
    private SpecificationService specificationService;
    private EmployeeService employeeService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Specification specification;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @Before
    public void setUp() {
        specificationDao = mock(SpecificationDao.class);
        employeeService = mock(EmployeeService.class);
        specificationService = new SpecificationService(specificationDao,employeeService);

        employee1 = new Employee();
        employee1.setRole(Role.CUSTOMER);
        employee1.setId(1);

        employee2 = new Employee();
        employee2.setRole(Role.MANAGER);
        employee2.setId(2);

        employee3 = new Employee();
        employee3.setRole(Role.DESIGNER);
        employee3.setId(3);

        specification = new Specification();
        specification.setCustomer(employee1);
        specification.setManager(employee2);
        specification.setDesigner(employee3);
    }


    @Test
    public void create() throws NotFoundException {
        when(employeeService.findById(1)).thenReturn(employee1);
        when(specificationDao.save(any())).thenReturn(specification);
        specificationService.create(mock(Project.class),1);
    }

    @Test
    public void updateCost() throws NotFoundException, NotAllowedException {
        when(specificationDao.findById(1)).thenReturn(specification);
        specificationService.updateCost(3,1,600);
        assertEquals(specification.getCost(),600);
    }

    @Test(expected = NotAllowedException.class)
    public void updateCrew_ERROR() throws NotFoundException, NotAllowedException {
        when(specificationDao.findById(1)).thenReturn(specification);
        specificationService.updateCrew(2,1,600);
        expectedException.expectMessage("Authorized is not designer of specification with id 1");
    }
}