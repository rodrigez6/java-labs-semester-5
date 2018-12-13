package org.rodrigez.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.rodrigez.model.Employee;
import org.rodrigez.model.dao.EmployeeDao;
import org.rodrigez.service.exception.NotFoundException;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class EmployeeServiceTest {

    @Parameterized.Parameter()
    public int id;
    @Parameterized.Parameter(1)
    public Employee employee;
    @Parameterized.Parameter(2)
    public Class expectedException;
    @Parameterized.Parameter(3)
    public String expectedExceptionMessage;

    private static Employee mockEmployee = mock(Employee.class);

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {1,mockEmployee,null,null},
                {2,null,NotFoundException.class,"Employee not found with id 2"}
        });
    }

    private EmployeeDao employeeDao;
    private EmployeeService employeeService;

    @Before
    public void setUp() {
        employeeDao = mock(EmployeeDao.class);
        employeeService = new EmployeeService(employeeDao);
    }

    @Test
    public void findById(){
        when(employeeDao.findById(1)).thenReturn(mockEmployee);
        when(employeeDao.findById(2)).thenReturn(null);

        try {
            Employee foundEmployee = employeeService.findById(id);
            assertEquals(foundEmployee, employee);
        } catch (NotFoundException e) {
            assertEquals(e.getClass(),expectedException);
            assertEquals(e.getMessage(),expectedExceptionMessage);
        }
    }
}