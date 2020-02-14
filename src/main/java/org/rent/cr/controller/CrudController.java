package org.rent.cr.controller;

import com.google.common.reflect.TypeToken;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EntityService;
import org.rent.cr.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@CrossOrigin
public abstract class CrudController<E, S extends EntityService> {
    protected S service;
    private String entityName;

    @Autowired
    Validator validator;

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    public CrudController(S service) {
        this.service = service;
        TypeToken<E> type = new TypeToken<E>(getClass()) {};
        this.entityName = type.getType().getTypeName();
    }

    @GetMapping("all")
    public Object findAll() {
        return service.findAll();
    }

    @GetMapping
    public Object getPage(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "per_page", defaultValue = "20") Integer size, @RequestParam(name = "sort", required = false) String field, @RequestParam(name = "filter", required = false) String filter) {
        String order = null;
        if (field != null) {
            String[] params = field.split("\\|");
            if (params.length == 2) {
                order = params[1];
                field = params[0];
            }
        }
        Page<E> result = service.getPage(page, size, field, order, filter);
        return result;
    }

    @GetMapping("{id}")
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        E entity = (E) service.findById(id);
        return entity;
    }

    @PostMapping
    public Object save(@RequestBody E entity) throws NotSavedException, IllegalActionException, NoEntityException {
        entity = (E) service.save(entity);
        logger.info(entityName + " added");
        return entity;
    }

    @PutMapping("{id}")
    public Object update(@PathVariable("id") E entityFromDb, @RequestBody E entity) {
        EntityUtils.copyNonNullProperties(entity, entityFromDb);

        Set<ConstraintViolation<E>> constraintViolations = validator.validate(entityFromDb);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

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
    public Object delete(@PathVariable("id") E entity) throws NoEntityException {
        service.delete(entity);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", entityName + " was deleted");
        logger.info(entityName + " deleted");
        return responseMap;
    }
}
