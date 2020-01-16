package org.rent.cr.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.impl.car.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelServiceImplTest {
    @Autowired
    private ModelServiceImpl modelService;

    @Test
    @Transactional
    public void findAll() throws NoEntityException {

    }
}