package ma.mycompany.ms2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ma.mycompany.ms2.clients.Ms1Client;

@EnableFeignClients(basePackages = {"ma.mycompany.ms2.clients","ma.mycompany.ms2.controllers"})
@RestController
public class MyController {

	@Autowired
    private Ms1Client ms1Client;
	
	@GetMapping("/") String index(@RequestHeader(value="Authorization") String token) {
		return "I just called " + ms1Client.index(token);
	}
}
