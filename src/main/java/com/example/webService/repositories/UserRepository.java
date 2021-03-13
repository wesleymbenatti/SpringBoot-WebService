package com.example.webService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webService.entities.User;

//JpaRepository <nome da classe, tipo da chave primária>
public interface UserRepository extends JpaRepository<User, Long> {

}
