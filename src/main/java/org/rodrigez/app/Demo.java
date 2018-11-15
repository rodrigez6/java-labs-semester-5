package org.rodrigez.app;

import org.rodrigez.controller.Controller;
import org.rodrigez.model.Employee;
import org.rodrigez.model.Employee.EmployeePosition;
import org.rodrigez.repository.EmployeeRepository;
import org.rodrigez.repository.SpecificationRepository;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.service.EmployeeService;
import org.rodrigez.service.SpecificationService;

public class Demo {

    private static Controller controller;

    public static void main(String args[]) {
        configure();
        addTestEmployees();
        controller.runMenu();
    }

    private static void addTestEmployees() {
        EmployeeRepository employeeRepository = BeanStorage.INSTANCE.get(EmployeeRepository.class);
        Employee[] employees = new Employee[]{
                new Employee("Mykola", EmployeePosition.CUSTOMER),
                new Employee("Petro", EmployeePosition.MANAGER),
                new Employee("Pavlo", EmployeePosition.DESIGNER)};
        for(Employee employee: employees){
            employeeRepository.save(employee);
        }
    }

    private static void configure(){
        BeanStorage beanStorage = BeanStorage.INSTANCE;
        beanStorage.add(EmployeeRepository.class,new EmployeeRepository());
        beanStorage.add(SpecificationRepository.class, new SpecificationRepository());
        beanStorage.add(EmployeeService.class, new EmployeeService());
        beanStorage.add(SpecificationService.class, new SpecificationService());
        controller = new Controller();
    }
}