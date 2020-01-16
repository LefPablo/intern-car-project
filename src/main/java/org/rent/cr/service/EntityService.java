package org.rent.cr.service;

import org.rent.cr.exception.NoEntityException;

import java.util.List;

public interface EntityService<T> {
    T findById(int id) throws NoEntityException;
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void deleteById(int id) throws NoEntityException;
    void deleteAll();
    List<T> findAll();
}
