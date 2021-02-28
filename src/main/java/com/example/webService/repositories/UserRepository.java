package com.example.webService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webService.entities.User;

//JpaRepository <nome da classe, tipo do Id>
public interface UserRepository extends JpaRepository<User, Long> {

}
