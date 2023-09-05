package com.sanjeev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sanjeev.feign.GreetFeignClient;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private GreetFeignClient greetClient;
	
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		
		String greetRepo = greetClient.invokeGreetApi();
		
		return greetRepo +", Welcome To AshokIT";
		
		/*
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = 
				rt.getForEntity("http://localhost:1122/greet", String.class);
		
		String greetResp = forEntity.getBody();
		
		return greetResp + " Welcome To SanjeevIT";
		*/
		
		
	}

}
