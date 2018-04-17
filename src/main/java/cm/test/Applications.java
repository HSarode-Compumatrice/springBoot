package cm.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cm.test.controller.*;
import cm.test.model.*;
import cm.test.repository.*;


//@SpringBootApplication
//@EnableJpaAuditing
//@ComponentScan("controller.OrdersController")
//@EntityScan("model.Orders")
//@EnableJpaRepositories("com.funky.classes.repository")



@SpringBootApplication

public class Applications {

	public static void main(String[] args) {
		SpringApplication.run(Applications.class, args);
	}
}
