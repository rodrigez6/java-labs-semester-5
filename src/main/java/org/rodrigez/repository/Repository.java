package org.rodrigez.repository;


public interface Repository<E> {
    E findById(int id);
    E save(E e);
}
