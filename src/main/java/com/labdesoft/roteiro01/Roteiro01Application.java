package com.labdesoft.roteiro01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.labdesoft.roteiro01.entity") 
@ComponentScan({"com.labdesoft.roteiro01.repository", "com.labdesoft.roteiro01.service"}) 
public class Roteiro01Application {

	public static void main(String[] args) {
		SpringApplication.run(Roteiro01Application.class, args);
	}

}
