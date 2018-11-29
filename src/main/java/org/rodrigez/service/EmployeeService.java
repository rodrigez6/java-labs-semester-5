package org.rodrigez.service;

import org.rodrigez.model.Employee;
import org.rodrigez.model.dao.EmployeeDao;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.service.exception.NotFoundException;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee findById(int employeeId) throws NotFoundException {

        Employee employee = employeeDao.findById(employeeId);

        if(employee==null) throw new NotFoundException("Employee not found with id " + employeeId);

        return employee;
    }
}
