package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Brand;
import org.rent.cr.repo.car.BrandRepository;
import org.rent.cr.service.BrandService;
import org.rent.cr.service.impl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends EntityServiceImpl<Brand, BrandRepository> implements BrandService {
    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        super(brandRepository, "Brand");
        this.brandRepository = brandRepository;
    }
}
