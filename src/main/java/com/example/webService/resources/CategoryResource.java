package com.example.webService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webService.entities.Category;
import com.example.webService.services.CategoryService;

//essa classe é um recurso web,
//que é implementado por um controlador Rest

//Definindo controlador Rest
@RestController

//Requisição de usuários via localhost:8080/users
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	//método que é EndPoint para acessar os usuários
	//Método que responde a requisição do tipo get do http
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Requisição que aceita um id dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
