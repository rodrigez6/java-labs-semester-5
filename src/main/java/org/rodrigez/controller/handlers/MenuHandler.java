package org.rodrigez.controller.handlers;

import org.rodrigez.model.Employee;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.EmployeeService;

import java.util.Scanner;

public class MenuHandler extends Handler {
    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.println("-----------------------------------------------------------------------------------------");
        boolean authorized = Boolean.parseBoolean(request.getAttribute("authorized"));
        if(authorized){
            int authorizedId = Integer.parseInt(request.getAttribute("authorized-id"));
            Employee.EmployeePosition position = employeeService.findById(authorizedId).getPosition();
            switch (position) {
                case CUSTOMER:{
                    System.out.print("1.My specifications 2.Add specification 3. Save specification 4.Log out\n");
                    System.out.print("Type number: ");
                    int c = scanner.nextInt();
                    switch (c){
                        case 1: {
                            request.setAttribute("handler","get-customer-specifications");
                            break;
                        }
                        case 2: {
                            request.setAttribute("handler","add-specification");
                            break;
                        }
                        case 3: {
                            request.setAttribute("handler","save-specification");
                            break;
                        }
                        case 4: {
                            request.setAttribute("handler","logout");
                            break;
                        }
                    }
                    break;
                }
                case MANAGER:{
                    System.out.print("1.My specifications 2.Register specifications 3.Save specification 4.Log out\n");
                    System.out.print("Type number: ");
                    int c = scanner.nextInt();
                    switch (c){
                        case 1: {
                            request.setAttribute("handler","get-manager-specifications");
                            break;
                        }
                        case 2: {
                            request.setAttribute("handler","register-specifications");
                            break;
                        }
                        case 3: {
                            request.setAttribute("handler","save-specification");
                            break;
                        }
                        case 4: {
                            request.setAttribute("handler","logout");
                            break;
                        }
                    }
                    break;
                }
                case DESIGNER:{
                    System.out.print("1.My specifications 2.Bill cost 3.Save specification 3.Set crew size 4.Log out\n");
                    System.out.print("Type number: ");
                    int c = scanner.nextInt();
                    switch (c){
                        case 1: {
                            request.setAttribute("handler","get-designer-specifications");
                            break;
                        }
                        case 2: {
                            request.setAttribute("handler","bill-cost");
                            break;
                        }
                        case 3: {
                            request.setAttribute("handler","create-crew");
                            break;
                        }
                        case 4: {
                            request.setAttribute("handler","save-specification");
                            break;
                        }
                        case 5: {
                            request.setAttribute("handler","logout");
                            break;
                        }
                    }
                    break;
                }
            }
        } else {
            request.setAttribute("handler","login");
        }
    }
}