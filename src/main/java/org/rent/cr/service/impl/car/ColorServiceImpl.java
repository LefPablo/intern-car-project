package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Color;
import org.rent.cr.dao.repo.car.ColorRepository;
import org.rent.cr.service.ColorService;
import org.rent.cr.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ColorServiceImpl extends CrudServiceImpl<Color, ColorRepository> implements ColorService {

    @Autowired
    public ColorServiceImpl(ColorRepository colorRepository) {
        super(colorRepository);
    }
}
