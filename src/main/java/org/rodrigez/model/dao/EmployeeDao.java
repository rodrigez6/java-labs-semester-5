package org.rodrigez.model.dao;

import org.rodrigez.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDao {
    private Map<Integer,Employee> map = new HashMap<>();

    public Employee findById(int id) {
        return map.get(id);
    }

    public Employee save(Employee employee) {
        int id = map.size()+1;
        employee.setId(id);
        map.put(id,employee);
        return employee;
    }
}