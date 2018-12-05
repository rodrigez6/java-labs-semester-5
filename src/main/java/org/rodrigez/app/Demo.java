package org.rodrigez.app;

import org.rodrigez.controller.DispatcherController;
import org.rodrigez.controller.Session;
import org.rodrigez.model.Employee;
import org.rodrigez.model.Role;
import org.rodrigez.model.dao.EmployeeDao;
import org.rodrigez.model.dao.SpecificationDao;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.service.EmployeeService;
import org.rodrigez.service.SpecificationService;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {
        configure();
        addTestEmployees();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        DispatcherController controller = new DispatcherController();
        for(int i=0;i<1;i++){
            executorService.execute(new Session(i,controller));
        }
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

        EmployeeDao employeeDao = new EmployeeDao();
        SpecificationDao specificationDao = new SpecificationDao();
        EmployeeService employeeService = new EmployeeService(employeeDao);
        SpecificationService specificationService = new SpecificationService(specificationDao,employeeService);

        beanStorage.add(EmployeeDao.class,employeeDao);
        beanStorage.add(SpecificationDao.class, specificationDao);
        beanStorage.add(EmployeeService.class, employeeService);
        beanStorage.add(SpecificationService.class, specificationService);
    }

}