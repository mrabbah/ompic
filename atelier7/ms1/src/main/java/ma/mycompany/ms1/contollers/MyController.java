package ma.mycompany.ms1.contollers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class MyController {

	private static Logger log = LoggerFactory.getLogger(MyController.class);
			
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;
	
	@Value("${spring.application.name}")
    private String appName;
	
	@GetMapping("/") String index() {
		log.info("appel a MSA to get his name");
		return appName;
	}
}
