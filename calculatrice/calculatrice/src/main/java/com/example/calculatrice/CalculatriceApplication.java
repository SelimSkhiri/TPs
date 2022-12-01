package com.example.calculatrice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatriceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CalculatriceApplication.class, args);
		Operation o=new Operation();
		double r=o.apply(10,20,'/');
		System.out.println(r);
	}
}
