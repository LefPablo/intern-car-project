package org.rent.cr.service;

import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CrudService<E> {
    E findById(int id) throws NoEntityException;
    E save(E entity) throws NotSavedException;
    E update(E entity, E source);
    void delete(E entity);
    long deleteAll();
    List<E> findAll();
    Page<E> getPage(int p, int s, String field, String order, String filter);
}
