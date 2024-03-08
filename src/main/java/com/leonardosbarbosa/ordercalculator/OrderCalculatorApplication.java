package com.leonardosbarbosa.ordercalculator;

import com.leonardosbarbosa.ordercalculator.entities.Order;
import com.leonardosbarbosa.ordercalculator.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class OrderCalculatorApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(OrderCalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Codigo do produto: ");
		int code = sc.nextInt();
		System.out.print("Preco: ");
		double basic = sc.nextDouble();
		System.out.print("Desconto: ");
		double discount = sc.nextDouble();
		Order order = new Order(code, basic, discount);

		double total = orderService.total(order);

		System.out.println("Código do pedido: " + order.code());
		System.out.printf("Valor total: R$ %.2f", total);
		System.exit(0);
	}
}
