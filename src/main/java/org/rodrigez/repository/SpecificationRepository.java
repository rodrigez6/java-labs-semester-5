package org.rodrigez.repository;

import org.rodrigez.model.Specification;

import java.util.HashMap;
import java.util.Map;

public class SpecificationRepository implements Repository<Specification> {
    Map<Integer,Specification> specificationMap = new HashMap<>();

    @Override
    public Specification findById(int id) {
        return specificationMap.get(id);
    }

    @Override
    public Specification save(Specification specification) {
        int id = specificationMap.size()+1;
        specification.setId(id);
        specificationMap.put(id,specification);
        return specification;
    }
}
