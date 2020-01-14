package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Brand;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.repo.BrandRepository;
import org.rent.cr.service.BrandService;
import org.rent.cr.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService, EntityService<Brand> {

    private BrandRepository brandRepository;

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand findById(int id) throws NoEntityException {
        return brandRepository.findById(id).
                orElseThrow(() -> new NoEntityException(id, "Brand"));
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public void deleteAll() {
        brandRepository.deleteAll();
    }
}
