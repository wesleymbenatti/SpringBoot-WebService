package com.example.webService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webService.entities.Category;

//JpaRepository <nome da classe, tipo da chave primária>
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
