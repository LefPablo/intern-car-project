package org.rent.cr.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.entity.car.Brand;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.impl.car.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandRepositoryTest {
    @Autowired
    private BrandServiceImpl brandServiceImpl;

    @Test
    @Transactional
    public void whenFindByName_thenReturnEmployee() throws NoEntityException {
        Brand brand = brandServiceImpl.findById(1);

        System.out.println(brand.getName());
        System.out.println(brand.getModels().size());

//        Assert.assertEquals("Toyota" ,found.getName());
    }
}