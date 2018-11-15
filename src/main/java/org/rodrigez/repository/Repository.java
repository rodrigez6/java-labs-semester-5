package org.rodrigez.repository;


import org.rodrigez.model.Specification;

import java.util.Set;

public interface Repository<E> {
    E findById(int id);


    E save(E e);
}
