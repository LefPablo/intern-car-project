package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Model;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.repo.ModelRepository;
import org.rent.cr.service.EntityService;
import org.rent.cr.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService, EntityService<Model> {
    private ModelRepository modelRepository;

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model findById(int id) throws NoEntityException {
        return modelRepository.findById(id).orElseThrow(() -> new NoEntityException(id, "Model"));
    }

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model update(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public void delete(Model model) {
        modelRepository.delete(model);
    }

    @Override
    public void deleteAll() {
        modelRepository.deleteAll();
    }

    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }
}
