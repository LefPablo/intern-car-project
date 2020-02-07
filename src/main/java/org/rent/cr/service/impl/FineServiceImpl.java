package org.rent.cr.service.impl;

import org.rent.cr.entity.Fine;
import org.rent.cr.dao.repo.FineRepository;
import org.rent.cr.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FineServiceImpl extends CrudServiceImpl<Fine, FineRepository> implements FineService {

    @Autowired
    public FineServiceImpl(FineRepository fineRepository) {
        super(fineRepository);
    }
}
