package org.rent.cr.service.impl;

import org.rent.cr.entity.Period;
import org.rent.cr.dao.repo.PeriodRepository;
import org.rent.cr.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PeriodServiceImpl extends CrudServiceImpl<Period, PeriodRepository> implements PeriodService {

    @Autowired
    public PeriodServiceImpl(PeriodRepository periodRepository) {
        super(periodRepository);
    }
}
