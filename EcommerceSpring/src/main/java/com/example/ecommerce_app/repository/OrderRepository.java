

package com.example.ecommerce_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_app.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
