package org.rent.cr.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.entity.Equipment;
import org.rent.cr.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource("/application-test.properties")
public class EntityServiceTest {

    @Autowired
    private EquipmentService entityService;

    @Test
    public void findById() throws NoEntityException {
        Equipment equipment = entityService.findById(1);
//        Assert.assertEquals("GPS", equipment.getName());
    }

    @Test
    public void save() {
        Equipment equipment = new Equipment();
        equipment.setName("Baby chair");
        equipment.setPrice(10.20F);
        Equipment result = entityService.save(equipment);
        Assert.assertEquals(equipment.getName(), result.getName());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void findAll() {
    }
}