package org.rent.cr.controller;

import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CrudController<E, T extends EntityService> {
    private T service;
    private String entityName;

    public CrudController(T service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    public List<E> findAll() {
        return service.findAll();
    }

    @GetMapping("page/{p}")
    public Page<E> getPage(@PathVariable("p") int p, @RequestParam(name = "size", defaultValue = "30") int size) {
        Page<E> page = service.getPage(p, size);
        return page;
    }

    @GetMapping("{id}")
    public E findById(@PathVariable("id") int id) throws NoEntityException {
        E entity = (E) service.findById(id);
        return entity;
    }

    @PostMapping
    public E save(@RequestBody E entity) {
        entity = (E) service.save(entity);
        return entity;
    }

    @PutMapping("{id}")
    public E update(@PathVariable("id") E entityFromDb, @RequestBody E entity) {
        service.copyNonNullProperties(entity, entityFromDb);
        entity = (E) service.update(entityFromDb);
        return entity;
    }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

    @DeleteMapping("{id}")
    public Map deleteById(@PathVariable("id") int id) throws NoEntityException {
        service.deleteById(id);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", entityName + " was deleted");
        return responseMap;
    }
}
