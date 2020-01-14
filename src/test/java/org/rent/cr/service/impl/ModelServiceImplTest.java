package org.rent.cr.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.entity.car.Model;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelServiceImplTest {
    @Autowired
    private ModelService modelService;

    @Test
    @Transactional
    public void findAll() throws NoEntityException {

    }
}