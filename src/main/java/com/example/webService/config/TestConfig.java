package com.example.webService.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.webService.entities.Category;
import com.example.webService.entities.Order;
import com.example.webService.entities.OrderItem;
import com.example.webService.entities.Payment;
import com.example.webService.entities.Product;
import com.example.webService.entities.User;
import com.example.webService.entities.enums.OrderStatus;
import com.example.webService.repositories.CategoryRepository;
import com.example.webService.repositories.OrderItemRepository;
import com.example.webService.repositories.OrderRepository;
import com.example.webService.repositories.ProductRepository;
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
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Jéssica Aline", "jscmoura@gmail.com", "998500267", "123456");
		User u2 = new User(null, "Wesley Benatti", "wesleymbenatti@gmail.com", "993322164", "123456");
		
		Order o1 = new Order(1, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(2, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(3, Instant.parse("2019-06-20T16:44:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "senhor dos anéis", 25.00, "");
		Product p2 = new Product(null, "Smart TV", "Qualidade de televisão", 2500.00, "");
		Product p3 = new Product(null, "MacBookPro", "Apple", 5000.00, "");
		Product p4 = new Product(null, "PC Gamer", "I9 9400", 6000.00, "");
		Product p5 = new Product(null, "Rails for Dumnies", "livro", 25.00, "");
		
		//salva no banco todos os objetos de teste
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null , Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
		
	}
	
	

}
