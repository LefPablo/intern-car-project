package org.rent.cr.service.impl;

import org.rent.cr.dao.JpaRepositoryAndJpaSpecificationExecutor;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.reflect.TypeToken;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
public abstract class CrudServiceImpl<T extends GeneralEntity,R extends JpaRepositoryAndJpaSpecificationExecutor<T,Integer>> implements EntityService<T> {
    protected R repository;
    private String entityName;

    public CrudServiceImpl(R repository) {
        this.repository = repository;
        TypeToken<T> type = new TypeToken<T>(getClass()) {};
        entityName = type.getType().getTypeName();
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
        emptyNames.add("id"); //always ignore id
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
    public Page<T> getPage(int page, int size, String field, String order) {
        page--; // -1 from page because pages starts from 0 but for users more comfortable start from 1
        Sort sort = null;
        if (field != null) {
            if (order != null && order.equals("desc")) {
                sort = Sort.by(field).descending();
            } else if (order != null && order.equals("asc")) {
                sort = Sort.by(field).ascending();
            } else {
                sort = Sort.unsorted();
            }
        } else {
            sort = Sort.unsorted();
        }
        Pageable pageable = PageRequest.of(page,size, sort);
        Page<T> result = repository.findAll(pageable);
        return result;
    }

    public Page<T> getPage(int p, int size) {
        return getPage(p, size, null, null);
    }


    @Override
    public T save(T entity) throws NotSavedException {
        T result = repository.save(entity);
        if (repository.existsById(result.getId())) {
            return result;
        } else {
            throw new NotSavedException(entityName);
        }
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
