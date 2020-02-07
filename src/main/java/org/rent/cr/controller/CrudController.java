package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
public abstract class CrudController<E, T extends EntityService> {
    private T service;
    private String entityName;

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    public CrudController(T service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping("all")
    public Object findAll() {
        return service.findAll();
    }

//    @JsonView(View.Public.class)
    @GetMapping
    public Object getPage(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "per_page", defaultValue = "20") Integer size, @RequestParam(name = "sort", defaultValue = "") String field, @RequestParam(name = "filter", defaultValue = "") String filter) {
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

    @GetMapping("{id}")
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        E entity = (E) service.findById(id);
        return entity;
    }

//    @JsonView(View.Public.class)
    @PostMapping
    public Object save(@RequestBody E entity) throws NotSavedException {
        entity = (E) service.save(entity);
        logger.info(entityName + " added");
        return entity;
    }

    @PutMapping("{id}")
    public Object update(@PathVariable("id") E entityFromDb, @RequestBody E entity) {
        service.copyNonNullProperties(entity, entityFromDb);
        entity = (E) service.update(entityFromDb);
        logger.info(entityName + " updated");
        return entity;
    }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        service.deleteAll();
        logger.info(entityName + " all records deleted");
    }

    @DeleteMapping("{id}")
    public Object deleteById(@PathVariable("id") int id) throws NoEntityException {
        service.deleteById(id);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", entityName + " was deleted");
        logger.info(entityName + " deleted");
        return responseMap;
    }
}
