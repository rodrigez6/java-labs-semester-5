package org.rodrigez.service;

import org.rodrigez.model.Employee;
import org.rodrigez.repository.EmployeeRepository;
import org.rodrigez.routing.BeanStorage;

import java.util.Random;

public class EmployeeService {
    private EmployeeRepository employeeRepository = BeanStorage.INSTANCE.get(EmployeeRepository.class);

    Employee findById(Integer employeeId){
        return employeeRepository.findById(employeeId);
    }

    static class DesignerCalculator {
        static int constructionCost(){
            Random random = new Random();
            return random.nextInt(400) + 100;
        }

        static int crewSize(){
            Random random = new Random();
            return random.nextInt(8) + 2;
        }
    }
}
