package com.company.example.service.contracts;

import java.util.Optional;

public interface GenericDAO<E> {
    Optional<E> findById(Long id);
    E save(E entity);
    Iterable<E> findAll();
    void deleteById(Long id);
}
