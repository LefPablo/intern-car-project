package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Option;
import org.rent.cr.dao.repo.car.OptionRepository;
import org.rent.cr.service.OptionService;
import org.rent.cr.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OptionServiceImpl extends CrudServiceImpl<Option, OptionRepository> implements OptionService {

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        super(optionRepository);
    }
}
