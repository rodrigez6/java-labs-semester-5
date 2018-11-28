package org.rodrigez.service;

import org.junit.Before;
import org.junit.Test;
import org.rodrigez.model.Employee;
import org.rodrigez.model.Specification;
import org.rodrigez.model.dao.SpecificationDao;
import org.rodrigez.validation.NotAllowedException;
import org.rodrigez.validation.NotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SpecificationServiceTest {

    private SpecificationDao specificationDao;
    private SpecificationService specificationService;
    private EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {
        specificationDao = mock(SpecificationDao.class);
        employeeService = mock(EmployeeService.class);
        specificationService = new SpecificationService(specificationDao,employeeService);
    }

    @Test
    public void create() {

    }

    @Test
    public void findAllByCustomerId() {
    }

    @Test
    public void updateCost() {
    }
}