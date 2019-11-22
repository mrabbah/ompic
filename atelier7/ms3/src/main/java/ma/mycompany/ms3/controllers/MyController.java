package ma.mycompany.ms3.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/")
	String open() {
		return "Hello open door for users";
	}
	
	@GetMapping("/restricted")
	//@PreAuthorize("hasRole('ADMIN')")
	String restricted() {
		return "You have access to restricted Resource you are ADMIN!";
	}
}
