package ma.mycompany.ms2.clients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import feign.Headers;
import feign.Param;


@FeignClient(name = "ms1", fallback = Ms1ClientFallback.class)
@RibbonClient("ms1")
public interface Ms1Client {

	@GetMapping("/")
	@Headers("X-Auth-Token: {access_token}")
	String index(@Param("access_token") String accessToken);
}
