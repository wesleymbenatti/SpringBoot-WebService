package com.example.webService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webService.entities.Product;

//JpaRepository <nome da classe, tipo da chave primária>
public interface ProductRepository extends JpaRepository<Product, Long> {

}
