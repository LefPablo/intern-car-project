package org.rent.cr.controller;

import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.CrudService;
import org.rent.cr.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@CrossOrigin
public abstract class CrudController<E extends GeneralEntity, S extends CrudService> {
    protected S service;
    private String entityName;

    @Autowired
    Validator validator;

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
        log.info(entityName + " added {id=" + entity.getId() + "}");
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
        log.info(entityName + " updated {id=" + entity.getId() + "}");
        return entity;
    }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        long count = service.deleteAll();
        log.info(entityName + " all records deleted {count=" + count + "}");
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable("id") E entity) throws NoEntityException {
        service.delete(entity);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", entityName + " was deleted {id=" + entity.getId() + "}");
        log.info(entityName + " deleted");
        return responseMap;
    }
}
