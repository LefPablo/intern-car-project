package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Brand;
import org.rent.cr.dao.repo.car.BrandRepository;
import org.rent.cr.service.BrandService;
import org.rent.cr.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends CrudServiceImpl<Brand, BrandRepository> implements BrandService {

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        super(brandRepository);
    }
}
