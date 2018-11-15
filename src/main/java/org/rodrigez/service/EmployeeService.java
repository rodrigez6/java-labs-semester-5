package org.rodrigez.service;

import org.rodrigez.model.Employee;
import org.rodrigez.repository.EmployeeRepository;
import org.rodrigez.util.BeanStorage;

public class EmployeeService {
    private EmployeeRepository employeeRepository = BeanStorage.INSTANCE.get(EmployeeRepository.class);

    public Employee findById(Integer employeeId){
        return employeeRepository.findById(employeeId);
    }

    public boolean login(int loginId){
        Employee employee = findById(loginId);
        return (employee!=null);
    }
}
