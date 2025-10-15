package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
}
