package org.rodrigez.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.rodrigez.model.Specification;

@Getter @Setter
public class SpecificationDTO {
    private int specificationId;
    private int customerId;
    private int managerId;
    private int designerId;
    private int cost;
    private int crewSize;

    public SpecificationDTO(Specification s) {
        this.specificationId = s.getId();
        this.customerId = s.getCustomer().getId();
        this.managerId = s.getManager().getId();
        this.designerId = s.getDesigner().getId();
        this.cost = s.getCost();
        this.crewSize = s.getDesignersCrew().getCrewSize();
    }
}
