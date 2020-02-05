package org.rent.cr.dao.rsql;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.dao.repo.car.BrandRepository;
import org.rent.cr.entity.car.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.oneOf;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RsqlTest {
    @Autowired
    private BrandRepository brandRepository;

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
    public void name() {
        Node rootNode = new RSQLParser().parse("name=in=(Suzuki,Skoda)");
        Specification<Brand> spec = rootNode.accept(new CustomRsqlVisitor<Brand>());
        List<Brand> results = brandRepository.findAll(spec);

        Assert.assertThat(brand1, oneOf(results));
    }
}
