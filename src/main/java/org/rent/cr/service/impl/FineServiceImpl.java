package org.rent.cr.service.impl;

import org.rent.cr.entity.Fine;
import org.rent.cr.repo.FineRepository;
import org.rent.cr.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FineServiceImpl extends EntityServiceImpl<Fine, FineRepository> implements FineService {
    private FineRepository fineRepository;

    @Autowired
    public FineServiceImpl(FineRepository fineRepository) {
        super(fineRepository, "Fine");
        this.fineRepository = fineRepository;
    }
}
