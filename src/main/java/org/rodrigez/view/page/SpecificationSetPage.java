package org.rodrigez.view.page;

import org.rodrigez.model.DesignersCrew;
import org.rodrigez.model.Employee;
import org.rodrigez.model.Specification;
import org.rodrigez.view.Page;

import java.util.Set;

public class SpecificationSetPage implements Page {
    @Override
    public void show(Object object) {
        Set<Specification> specificationSet = (Set<Specification>) object;
        if(specificationSet.size()==0){
            System.out.println("Specification set is empty");
        }else{
            System.out.println(header());
            for(Specification specification: specificationSet){
                System.out.println(content(specification));
            }
        }
    }

    private static String header(){
        return String.format("|%-10s|", "Id") +
                String.format("|%-80s|", "Description") +
                String.format("|%-20s|", "Customer") +
                String.format("|%-20s|", "Manager") +
                String.format("|%-20s|", "Designer") +
                String.format("|%-10s|", "Cost") +
                String.format("|%-10s|", "Crew");
    }


    private String content(Specification specification) {

        Employee customer = specification.getCustomer();
        Employee manager = specification.getManager();
        Employee designer = specification.getDesigner();
        DesignersCrew crew = specification.getDesignersCrew();

        return String.format("|%-10d|", specification.getId()) +
                String.format("|%-80s|", specification.getProject().getDescription()) +
                String.format("|%-20s|", customer==null?"":customer.getName()) +
                String.format("|%-20s|", manager==null?"":manager.getName()) +
                String.format("|%-20s|", designer==null?"":designer.getName()) +
                String.format("|%-10d|", specification.getCost()) +
                String.format("|%-10s|", crew==null?"":crew.getCrewSize());
    }
}
