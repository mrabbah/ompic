package ma.ompic.autoconfigtraining.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:my.properties", "classpath:config.properties"})
public class Company {

	@Value("${company.name}")
	private String name;
	
	@Autowired
	private Address address;

	public Company(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Company(Address address) {
		this.name = "DEFAULT";
		this.address = address;
	}
	
	public Company() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Company name: " + this.name + " address : " + this.address;
	}
	
}
