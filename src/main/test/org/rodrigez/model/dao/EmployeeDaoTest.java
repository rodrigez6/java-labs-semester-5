package org.rodrigez.model.dao;

import org.junit.Before;
import org.junit.Test;
import org.rodrigez.model.Employee;

import static org.junit.Assert.assertEquals;

public class EmployeeDaoTest {

    private EmployeeDao employeeDao;

    @Before
    public void setUp() {
        employeeDao = new EmployeeDao();
    }

    @Test
    public void test_Find_Save() {
        Employee employee = new Employee();
        Employee employee1 = employeeDao.save(employee);
        assertEquals(employee1.getId(),1);
        Employee employee2 = employeeDao.findById(1);
        assertEquals(employee1, employee2);
    }
}