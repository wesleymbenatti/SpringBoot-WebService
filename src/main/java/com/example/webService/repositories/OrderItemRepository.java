package com.example.webService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webService.entities.OrderItem;

//JpaRepository <nome da classe, tipo da chave primária>
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
