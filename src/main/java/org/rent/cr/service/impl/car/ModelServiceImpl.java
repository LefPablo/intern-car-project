package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Model;
import org.rent.cr.dao.repo.car.ModelRepository;
import org.rent.cr.service.ModelService;
import org.rent.cr.service.impl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModelServiceImpl extends EntityServiceImpl<Model, ModelRepository> implements ModelService {
    private ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        super(modelRepository, "Model");
        this.modelRepository = modelRepository;
    }
}
