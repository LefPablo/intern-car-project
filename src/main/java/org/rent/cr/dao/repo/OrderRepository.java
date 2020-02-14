package org.rent.cr.dao.repo;

import org.rent.cr.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {
    @Query("SELECT o FROM Order o WHERE o.end > ?1")
    List<Order> getOrdersLater(LocalDateTime dateTime);
}
