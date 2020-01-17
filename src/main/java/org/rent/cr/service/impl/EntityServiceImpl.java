package org.rent.cr.service.impl;

import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
public abstract class EntityServiceImpl<T,R extends JpaRepository<T,Integer>> implements EntityService<T> {
    private R repository;
    private String entityName;

    public EntityServiceImpl(R repository, String entityName) {
        this.repository = repository;
        this.entityName = entityName;
    }

    //Copies properties from one object to another
    @Override
    public void copyNonNullProperties(Object source, Object destination){
        BeanUtils.copyProperties(source, destination,
                getNullPropertyNames(source));
    }

    //Returns an array of null properties of an object
    private String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set emptyNames = new HashSet();
        for(java.beans.PropertyDescriptor pd : pds) {
            //check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
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
    public Page<T> getPage(int p, int size) {
        Pageable page = PageRequest.of(p,size);
        return repository.findAll(page);
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
