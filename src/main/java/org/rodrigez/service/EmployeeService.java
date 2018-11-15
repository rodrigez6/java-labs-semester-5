package org.rodrigez.service;

import org.rodrigez.model.Employee;
import org.rodrigez.model.dao.EmployeeDao;
import org.rodrigez.util.BeanStorage;

public class EmployeeService {
    private EmployeeDao employeeDao = BeanStorage.INSTANCE.get(EmployeeDao.class);

    public Employee findById(int employeeId){
        return employeeDao.findById(employeeId);
    }

    public boolean login(int loginId){
        Employee employee = findById(loginId);
        return (employee!=null);
    }
}
