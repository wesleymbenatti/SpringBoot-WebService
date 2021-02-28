package com.example.webService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webService.entities.User;
import com.example.webService.services.UserService;

//Definindo controlador Rest
@RestController

//Requisição de usuários via localhost:8080/users
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	//Requisição tipo GET
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Requisição que aceita um id dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
