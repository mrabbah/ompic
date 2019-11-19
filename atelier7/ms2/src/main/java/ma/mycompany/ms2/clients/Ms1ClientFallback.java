package ma.mycompany.ms2.clients;

import org.springframework.stereotype.Component;

@Component
public class Ms1ClientFallback implements Ms1Client {
	
	@Override
	public String index(String token) {
		return "MS1 Fallback service";
	}	
}
