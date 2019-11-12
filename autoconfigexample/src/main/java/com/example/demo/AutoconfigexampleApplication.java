package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.services.MyService;

@Controller
@SpringBootApplication
public class AutoconfigexampleApplication {

	@Autowired
	MyService myService;
	
	@RequestMapping("/")
	@ResponseBody String home() {
		return myService.getMessage();
	}
	
	@RequestMapping("/hellofrom")
	@ResponseBody String hellofrom() {
		return myService.helloFrom(1);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AutoconfigexampleApplication.class, args);
	}

}
