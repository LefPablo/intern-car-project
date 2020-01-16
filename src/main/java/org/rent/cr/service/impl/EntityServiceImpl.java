package org.rent.cr.service.impl;

import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class EntityServiceImpl<T,R extends JpaRepository<T,Integer>> implements EntityService<T> {
    private R repository;
    private String entityName;

    public EntityServiceImpl(R repository, String entityName) {
        this.repository = repository;
        this.entityName = entityName;
    }

    @Override
    public T findById(int id) throws NoEntityException {
        return repository.findById(id).orElseThrow(() -> new NoEntityException(id, entityName));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void deleteById(int id) throws NoEntityException {
        repository.delete(this.findById(id));
    }
}
