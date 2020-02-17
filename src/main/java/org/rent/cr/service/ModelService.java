package org.rent.cr.service;

import org.rent.cr.entity.car.Model;
import org.rent.cr.exception.NotSavedException;

public interface ModelService extends CrudService<Model> {
    Model save(Model model) throws NotSavedException;
}
