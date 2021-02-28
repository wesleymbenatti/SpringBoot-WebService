package com.example.webService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webService.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
