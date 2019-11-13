package ma.ompic.autoconfigtraining.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.ompic.autoconfigtraining.dto.Address;
import ma.ompic.autoconfigtraining.dto.Company;

@Configuration
public class MyConfig {

	@Bean
	public Address getAddress() {
		return new Address("Boulevard Almassira", 61);
	}
	
}
