package br.com.laurielcio.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Lau
 *
 */

@SpringBootApplication
@ComponentScan({"br.com.laurielcio.consumer"})
@EntityScan({"br.com.laurielcio.consumer"})
@EnableSwagger2
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
