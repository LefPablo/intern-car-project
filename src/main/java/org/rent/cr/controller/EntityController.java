package org.rent.cr.controller;

import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EntityController<E ,T extends EntityService> {
    private T service;
    private String entityName;

    public EntityController(T service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    @RequestMapping("/findAll")
    public List<E> findAll() {
        return service.findAll();
    }

    @GetMapping
    @RequestMapping("/findById")
    public E findById(@RequestParam("id") int id) throws NoEntityException {
        E entity = (E) service.findById(id);
        return entity;
    }

    @PostMapping
    @RequestMapping("/save")
    public E save(@RequestBody E entity) {
        entity = (E) service.save(entity);
        return entity;
    }

    @PutMapping
    @RequestMapping("/update")
    public E update(@RequestBody E entity) {
        entity = (E) service.update(entity);
        return entity;
    }

    @DeleteMapping
    @RequestMapping("/deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

    @DeleteMapping
    @RequestMapping("/deleteById")
    public Map deleteById(@RequestParam("id") int id) throws NoEntityException {
        service.deleteById(id);
        Map<String,String> responseMap = new HashMap<>();
        responseMap.put("message", entityName + " was deleted");
        return responseMap;
    }
}
