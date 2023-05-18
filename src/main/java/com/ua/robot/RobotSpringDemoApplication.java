package com.ua.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RobotSpringDemoApplication {

	public static void main(String[] args) {
	//Створити проєкт та контролер, який повертає тестову колекцію класу студент. Сервіс повинен
	// створити цю колекцію та повернути її. З контролеру буде викликатися тестовий сервіс

		SpringApplication.run(RobotSpringDemoApplication.class, args);
	}

}
