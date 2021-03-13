package com.example.webService.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.webService.entities.Order;
import com.example.webService.entities.User;
import com.example.webService.entities.enums.OrderStatus;
import com.example.webService.repositories.OrderRepository;
import com.example.webService.repositories.UserRepository;

//Classe de configuração específica para perfil de teste
@Configuration
//nome do perfil de teste do arquivo application.properties
@Profile("test")

//implementação CommandLineRunner para rodar os testes 
public class TestConfig implements CommandLineRunner{
	
	//anotação que faz a injeção de dependência
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Jéssica Aline", "jscmoura@gmail.com", "998500267", "123456");
		User u2 = new User(null, "Wesley Benatti", "wesleymbenatti@gmail.com", "993322164", "123456");
		
		Order o1 = new Order(1, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(2, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(3, Instant.parse("2019-06-20T16:44:22Z"),OrderStatus.WAITING_PAYMENT, u1);

		
		//salva no banco todos os objetos de teste
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	

}
