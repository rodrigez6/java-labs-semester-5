package org.rodrigez.repository;

import org.rodrigez.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository implements Repository<Employee> {
    private Map<Integer,Employee> employeeMap = new HashMap<>();

    @Override
    public Employee findById(int id) {
        return employeeMap.get(id);
    }

    @Override
    public Employee save(Employee employee) {
        int id = employeeMap.size()+1;
        employee.setId(id);
        employeeMap.put(id,employee);
        return employee;
    }
}