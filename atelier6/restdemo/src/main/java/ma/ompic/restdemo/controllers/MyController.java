package ma.ompic.restdemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ma.ompic.restdemo.dto.*;

@RestController
public class MyController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody String hello() {
		return "test";
	}
	
	@GetMapping("/foos")
	@ResponseBody String getFoos() {
		return "Foos";
	}
	
	@GetMapping("/personne/list")
	@ResponseBody List<Personne> listPersonnes() {
		List<Personne> personnes = new ArrayList<Personne>();
		personnes.add(new Personne(1, "RABBAH", "Mahmoud"));
		personnes.add(new Personne(2, "Ahmad", "Nabib"));
		return personnes;
	}
	
	@GetMapping("/personne/{id}")
	@ResponseBody Personne getPersonne(@PathVariable("id") int id) {
		return new Personne(id, "RABBAH", "Mahmoud");
	}
	
	@GetMapping("/personne")
	@ResponseBody Personne getPersonne(@RequestParam("id") int id, @RequestParam("nom") String nom) {
		return new Personne(id, nom, "YYYY");
	}
	
	@PostMapping("/personne/add")
	@ResponseBody Personne addPersonne(@RequestBody Personne personne) {
		return new Personne(19, personne.getNom(), personne.getPrenom());
	}
}

