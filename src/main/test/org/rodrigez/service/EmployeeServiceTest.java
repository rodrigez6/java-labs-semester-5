package org.rodrigez.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.Mockito;
import org.rodrigez.model.Employee;
import org.rodrigez.model.dao.EmployeeDao;
import org.rodrigez.validation.NotFoundException;

import static org.mockito.Mockito.*;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class EmployeeServiceTest {

    private EmployeeDao employeeDao;
    private EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {
        employeeDao = mock(EmployeeDao.class);
        employeeService = new EmployeeService(employeeDao);
    }

    @Test
    public void findById_OK() throws NotFoundException {
        Employee employee = mock(Employee.class);
        Mockito.when(employeeDao.findById(1)).thenReturn(employee);
        Assert.assertEquals(employeeService.findById(1), employee);
    }

    @Test
    public void findById_ERROR(){
        Exception e = null;
        Mockito.when(employeeDao.findById(1)).thenReturn(null);
        try {
            employeeService.findById(1);
        } catch (Exception e1){
            e = e1;
        }
        Assert.assertTrue(e instanceof NotFoundException);
    }
}