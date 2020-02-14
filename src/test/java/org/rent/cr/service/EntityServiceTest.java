package org.rent.cr.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.entity.Equipment;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource("/application-test.properties")
public class EntityServiceTest {

    @Autowired
    private EquipmentService entityService;

    @Autowired
    Environment environment;

    @Autowired
    private ServletContext servletContext;

    @Test
    public void localTest() {
        System.out.println(servletContext.getContextPath());
        System.out.println(environment.getProperty("server.port"));
    }

    @Test
    public void findById() throws NoEntityException {
        Equipment equipment = entityService.findById(1);
//        Assert.assertEquals("GPS", equipment.getName());
    }

    @Test
    public void save() throws NotSavedException, IllegalActionException {
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