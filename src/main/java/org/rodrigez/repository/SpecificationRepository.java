package org.rodrigez.repository;

import org.rodrigez.model.Specification;

import java.util.*;

public class SpecificationRepository implements Repository<Specification> {
    Map<Integer,Specification> specificationMap = new HashMap<>();

    @Override
    public Specification findById(int id) {
        return specificationMap.get(id);
    }

    public Set<Specification> findByCustomerId(int customerId){
        Set<Specification> selected = new LinkedHashSet<>();
        for(Specification specification: specificationMap.values()){
            if(specification.getCustomer().getId()==customerId){
                selected.add(specification);
            }
        }
        return selected;
    }

    @Override
    public Specification save(Specification specification) {
        Specification oldSpecification = findById(specification.getId());
        int id;
        if(oldSpecification==null){
            id = specificationMap.size()+1;
            specification.setId(id);
        } else {
            id = oldSpecification.getId();
        }
        specificationMap.put(id,specification);
        return specification;
    }

    public Set<Specification> findByManagerId(Integer managerId) {
        Set<Specification> selected = new LinkedHashSet<>();
        for(Specification specification: specificationMap.values()){
            if(specification.getManager()!=null&&specification.getManager().getId()==managerId){
                selected.add(specification);
            }
        }
        return selected;
    }

    public Set<Specification> findByDesignerId(Integer designerId) {
        Set<Specification> selected = new LinkedHashSet<>();
        for(Specification specification: specificationMap.values()){
            if(specification.getDesigner()!=null&&specification.getDesigner().getId()==designerId){
                selected.add(specification);
            }
        }
        return selected;
    }

    public Set<Specification> findNotRegistered(){
        Set<Specification> selected = new LinkedHashSet<>();
        for(Specification specification: specificationMap.values()){
            if(!specification.isRegistered()){
                selected.add(specification);
            }
        }
        return selected;
    }
}
