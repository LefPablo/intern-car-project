package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Option;
import org.rent.cr.dao.repo.car.OptionRepository;
import org.rent.cr.service.OptionService;
import org.rent.cr.service.impl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OptionServiceImpl extends EntityServiceImpl<Option, OptionRepository> implements OptionService {
    private OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        super(optionRepository, "Option");
        this.optionRepository = optionRepository;
    }
}
