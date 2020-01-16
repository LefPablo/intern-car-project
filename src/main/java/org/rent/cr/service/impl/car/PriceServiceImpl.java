package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Price;
import org.rent.cr.repo.car.PriceRepository;
import org.rent.cr.service.PriceService;
import org.rent.cr.service.impl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PriceServiceImpl extends EntityServiceImpl<Price, PriceRepository> implements PriceService {
    private PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        super(priceRepository, "Price");
        this.priceRepository = priceRepository;
    }
}
