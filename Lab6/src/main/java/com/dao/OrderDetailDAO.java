package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
}
