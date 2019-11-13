package ma.ompic.autoconfigtraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.ompic.autoconfigtraining.dto.Company;

@SpringBootApplication
public class BeansresourcedemoApplication {

	@Autowired
	private Company company;
	
	public static void main(String[] args) {
		SpringApplication.run(BeansresourcedemoApplication.class, args);
		
	}

}
