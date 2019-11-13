package ma.ompic.autoconfigtraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.ompic.autoconfigtraining.dto.Company;

@Controller
public class MyController {

	@Autowired
	private Company company;
	
	@RequestMapping("/")
	@ResponseBody String index() {
		return this.company.toString();
	}
}
