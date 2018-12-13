package org.rodrigez.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.rodrigez.model.Employee;
import org.rodrigez.model.Role;
import org.rodrigez.model.Specification;
import org.rodrigez.model.dao.SpecificationDao;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class SpecificationServiceRegisterAllTest {

    @Parameterized.Parameter()
    public int managerId;
    @Parameterized.Parameter(1)
    public int designerId;
    @Parameterized.Parameter(2)
    public Class<? extends Exception> expectedException;
    @Parameterized.Parameter(3)
    public String expectedExceptionMessage;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2,3,null,null},
                {1,3,NotAllowedException.class,"Employee with id 1 is not manager"}
        });
    }

    private SpecificationDao specificationDao;
    private SpecificationService specificationService;
    private EmployeeService employeeService;
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
    public void registerAll() throws NotFoundException {
        when(specificationDao.findNotRegistered()).thenReturn(Collections.singleton(specification));
        when(employeeService.findById(1)).thenReturn(employee1);
        when(employeeService.findById(2)).thenReturn(employee2);
        when(employeeService.findById(3)).thenReturn(employee3);

        try {
            specificationService.registerAll(managerId,designerId);
        } catch (NotAllowedException e) {
            assertEquals(e.getClass(), expectedException);
            assertEquals(e.getMessage(), expectedExceptionMessage);
        }
    }
}