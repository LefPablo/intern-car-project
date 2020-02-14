package org.rent.cr.dao.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.dao.repo.car.CarRepository;
import org.rent.cr.entity.car.Brand;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.impl.car.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandRepositoryTest {
    @Autowired
    private BrandServiceImpl brandServiceImpl;

    @Autowired
    private CarRepository carRepository;

    @Test
    @Transactional
    public void whenFindByName_thenReturnEmployee() throws NoEntityException, NotSavedException, IllegalActionException {
        Brand entity = new Brand();
        entity.setName("Qwert");
        Brand brand = brandServiceImpl.save(entity);
        List<Brand> brands = brandServiceImpl.findAll();

        System.out.println(brand.getName());
        System.out.println(brands.size());
    }
}