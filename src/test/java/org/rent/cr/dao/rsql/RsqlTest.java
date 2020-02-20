package org.rent.cr.dao.rsql;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.dao.repo.OrderRepository;
import org.rent.cr.dao.repo.car.BrandRepository;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.car.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RsqlTest {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityManager entityManager;

    private Brand brand1;

    private Brand brand2;

    @Before
    public void init() {
        brand1 = new Brand();
        brand1.setName("Bmw");
        brandRepository.save(brand1);

        brand2 = new Brand();
        brand2.setName("Audi");
        brandRepository.save(brand2);
    }

    @Test
    public void name() throws NoSuchFieldException {
        Node rootNode = new RSQLParser().parse("price=='26.6'");
        Specification<Order> spec = rootNode.accept(new CustomRsqlVisitor<Order>());
        List<Order> results = orderRepository.findAll(spec);
    }
}
