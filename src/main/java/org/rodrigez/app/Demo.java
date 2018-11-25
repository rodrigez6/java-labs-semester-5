package org.rodrigez.app;

import org.rodrigez.controller.DispatcherController;
import org.rodrigez.model.Employee;
import org.rodrigez.model.Role;
import org.rodrigez.model.dao.EmployeeDao;
import org.rodrigez.model.dao.SpecificationDao;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.service.EmployeeService;
import org.rodrigez.service.SpecificationService;

public class Demo {

    private static DispatcherController controller;

    public static void main(String[] args) {
        configure();
        addTestEmployees();
        controller.runMenu();
    }

    private static void addTestEmployees() {
        EmployeeDao employeeDao = BeanStorage.INSTANCE.get(EmployeeDao.class);
        Employee[] employees = new Employee[]{
                new Employee("Mykola", Role.CUSTOMER),
                new Employee("Petro", Role.MANAGER),
                new Employee("Pavlo", Role.DESIGNER)};
        for(Employee employee: employees){
            employeeDao.save(employee);
        }
    }

    private static void configure(){
        BeanStorage beanStorage = BeanStorage.INSTANCE;
        beanStorage.add(EmployeeDao.class,new EmployeeDao());
        beanStorage.add(SpecificationDao.class, new SpecificationDao());
        beanStorage.add(EmployeeService.class, new EmployeeService());
        beanStorage.add(SpecificationService.class, new SpecificationService());
        controller = new DispatcherController();
    }


}