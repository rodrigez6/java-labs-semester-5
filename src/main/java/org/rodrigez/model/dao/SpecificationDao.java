package org.rodrigez.model.dao;

import org.rodrigez.model.Specification;

import java.util.*;

public class SpecificationDao {
    private Map<Integer,Specification> map = new HashMap<>();

    public Specification findById(int id) {
        return map.get(id);
    }

    public Set<Specification> findByCustomerId(int customerId){
        Set<Specification> selected = new LinkedHashSet<>();
        for(Specification specification: map.values()){
            if(specification.getCustomer().getId()==customerId){
                selected.add(specification);
            }
        }
        return selected;
    }

    public Specification save(Specification specification) {
        Specification oldSpecification = findById(specification.getId());
        int id;
        if(oldSpecification==null){
            id = map.size()+1;
            specification.setId(id);
        } else {
            id = oldSpecification.getId();
        }
        map.put(id,specification);
        return specification;
    }

    public Set<Specification> findByManagerId(Integer managerId) {
        Set<Specification> selected = new LinkedHashSet<>();
        for(Specification specification: map.values()){
            if(specification.getManager()!=null&&specification.getManager().getId()==managerId){
                selected.add(specification);
            }
        }
        return selected;
    }

    public Set<Specification> findByDesignerId(Integer designerId) {
        Set<Specification> selected = new LinkedHashSet<>();
        for(Specification specification: map.values()){
            if(specification.getDesigner()!=null&&specification.getDesigner().getId()==designerId){
                selected.add(specification);
            }
        }
        return selected;
    }

    public Set<Specification> findNotRegistered(){
        Set<Specification> selected = new LinkedHashSet<>();
        for(Specification specification: map.values()){
            if(!specification.isRegistered()){
                selected.add(specification);
            }
        }
        return selected;
    }
}