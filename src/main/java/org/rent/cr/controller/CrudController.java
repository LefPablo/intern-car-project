package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EntityService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
public abstract class CrudController<E, T extends EntityService> {
    private T service;
    private String entityName;

    public CrudController(T service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }


    @GetMapping("all")
    public List<E> findAll() {
        return service.findAll();
    }

    @JsonView(View.Public.class)
    @GetMapping
    public Page<E> getPage(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "per_page", defaultValue = "20") Integer size, @RequestParam(name = "sort", defaultValue = "") String field, @RequestParam(name = "filter", defaultValue = "") String filter) {
        String order = null;
        if (field != "") {
            String[] params = field.split("\\|");
            if (params.length == 2) {
                order = params[1];
                field = params[0];
            }
        } else {
            field = null;
        }
        Page<E> result = service.getPage(page, size, field, order);
        return result;
    }

    @JsonView(View.Private.class)
    @GetMapping("{id}")
    public E findById(@PathVariable("id") int id) throws NoEntityException {
        E entity = (E) service.findById(id);
        return entity;
    }

    @PostMapping
    public E save(@RequestBody E entity) throws NotSavedException {
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
