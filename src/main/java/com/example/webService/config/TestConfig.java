package com.example.webService.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.webService.entities.User;
import com.example.webService.repositories.UserRepository;

//definindo como arquivo de configuração
@Configuration
//nome do perfil de teste do arquivo application.properties
@Profile("test")

//implementação CommandLineRunner para rodar os testes 
public class TestConfig implements CommandLineRunner{
	
	//anotação que faz a injeção de dependência
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Jéssica Aline", "jscmoura@gmail.com", "998500267", "123456");
		User u2 = new User(null, "Wesley Benatti", "wesleymbenatti@gmail.com", "993322164", "123456");
		
		//salva no banco todos os objetos de teste
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	

}
