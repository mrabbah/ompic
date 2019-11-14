package ma.ompic.admindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class AdmindemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmindemoApplication.class, args);
	}

}
