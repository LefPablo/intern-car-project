package org.rent.cr.service.impl.car;

import org.rent.cr.dao.repo.car.ModelRepository;
import org.rent.cr.entity.car.Model;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.ModelService;
import org.rent.cr.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class ModelServiceImpl extends CrudServiceImpl<Model, ModelRepository> implements ModelService {

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        super(modelRepository);
    }

    @Secured(value = {"EMPLOYEE"})
    @Override
    public Model save(@RequestBody Model entity) throws NotSavedException {
        return super.save(entity);
    }
}
