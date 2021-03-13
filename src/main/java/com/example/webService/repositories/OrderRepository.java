package com.example.webService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webService.entities.Order;

//JpaRepository <nome da classe, tipo da chave primária>
public interface OrderRepository extends JpaRepository<Order, Long> {

}
