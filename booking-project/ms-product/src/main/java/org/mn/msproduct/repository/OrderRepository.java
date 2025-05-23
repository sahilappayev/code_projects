package org.mn.msproduct.repository;

import java.util.List;
import org.mn.msproduct.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserId(Long userId);

}
