package org.rodrigez.service;

import org.rodrigez.model.Manager;
import org.rodrigez.model.Specification;

public class ManagerService {
    public void registerSpecification(Manager manager,Specification specification){
        specification.setManager(manager);
    }
}
