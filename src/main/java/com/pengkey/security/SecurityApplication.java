package com.pengkey.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
//@ComponentScan(basePackages = {"com.pengkey.security.config","com.pengkey.security.controller","com.pengkey.security.handler"})
@MapperScan(basePackages = {"com.pengkey.security.dao"})
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
