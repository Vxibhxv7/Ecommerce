package com.website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.services.RegistrationRequest;
import com.website.services.RegistrationService;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {	
	
	public RegistrationController(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}

	private RegistrationService registrationService;
	@PostMapping
	public String registration(@RequestBody RegistrationRequest request) {
		return registrationService.register(request);
		
	}

	@GetMapping(path = "confirm")
	public String confirm(@RequestParam("token")String token) {
		return registrationService.confirmToken(token);
	}
}
