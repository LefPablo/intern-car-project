package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Model;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("models")
public class ModelController {

    @Autowired
    ModelService service;

    @JsonView(View.Public.class)
    @GetMapping("all")
    public Object findAll() {
        return service.findAll();
    }

    @JsonView(View.Public.class)
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
        Page<Model> result = service.getPage(page, size, field, order, filter);
        return result;
    }

    @JsonView(View.Private.class)
    @GetMapping("{id}")
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        Model entity =  service.findById(id);
        return entity;
    }

    @JsonView(View.Private.class)
    @PostMapping
    public Object save(@RequestBody Model entity) throws NotSavedException, IllegalActionException, NoEntityException {
        entity =  service.save(entity);
        log.info("Model added {id=" + entity.getId() + "}");
        return entity;
    }

    @JsonView(View.Private.class)
    @PutMapping("{id}")
    public Object update(@PathVariable("id") Model entityFromDb, @RequestBody Model entity) {
        entity =  service.update(entityFromDb, entity);
        log.info("Model updated {id=" + entity.getId() + "}");
        return entity;
    }

    @DeleteMapping("deleteAll")
    public Object deleteAll() {
        long count = service.deleteAll();
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Model all records deleted {count=" + count + "}");
        log.info("Model all records deleted {count=" + count + "}");
        return responseMap;
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable("id") Model entity) throws NoEntityException {
        service.delete(entity);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Model was deleted {id=" + entity.getId() + "}");
        log.info("Model deleted");
        return responseMap;
    }
}
