package com.au.neil;

import com.au.neil.service.ItemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AuceServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AuceServerApplication.class, args);
		context.getBean(ItemService.class).init();
	}

}
