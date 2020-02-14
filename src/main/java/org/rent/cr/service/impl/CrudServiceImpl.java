package org.rent.cr.service.impl;

import com.google.common.reflect.TypeToken;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.RSQLParserException;
import cz.jirutka.rsql.parser.ast.Node;
import org.rent.cr.dao.rsql.CustomRsqlVisitor;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Transactional
public abstract class CrudServiceImpl<E,R extends JpaRepository<E,Integer> & JpaSpecificationExecutor<E>> implements EntityService<E> {
    protected R repository;
    private String entityName;

    public CrudServiceImpl(R repository) {
        this.repository = repository;
        TypeToken<E> type = new TypeToken<E>(getClass()) {};
        entityName = type.getType().getTypeName();
    }

    @Override
    public E findById(int id) throws NoEntityException {
        return repository.findById(id).orElseThrow(() -> new NoEntityException(id, entityName));
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<E> getPage(int page, int size, String field, String order, String filter) {
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
        Page<E> result = null;
        if (filter != null) {
            try {
                Node rootNode = new RSQLParser().parse(filter);
                Specification<E> spec = rootNode.accept(new CustomRsqlVisitor<E>());
                result = repository.findAll(spec ,pageable);
            } catch (RSQLParserException e) {
                e.printStackTrace();
            }
        } else {
            result = repository.findAll(pageable);
//            Page page1 = new PageImpl(repository.findAll(), pageable, repository.findAll().size());
        }
        return result;
    }

    public Page<E> getPage(int p, int size) {
        return getPage(p, size, null, null, null);
    }

    @Override
    public E save(@Validated E entity) throws NotSavedException {
        E result = repository.save(entity);
        if (result == null) {
            throw new NotSavedException(entityName);
        }
        return result;
    }

    @Override
    public E update(E entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(E entity) {
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
