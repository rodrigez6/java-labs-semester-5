package org.rodrigez.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.rodrigez.model.Employee;

@Setter @Getter
public class EmployeeDTO {
    private int employeeId;
    private String name;
    private String position;

    public EmployeeDTO(Employee e) {
        this.employeeId = e.getId();
        this.name = e.getName();
        this.position = e.getPosition().name();

    }
}
