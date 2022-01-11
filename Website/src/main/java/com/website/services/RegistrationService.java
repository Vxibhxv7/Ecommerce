package com.website.services;

import org.springframework.stereotype.Service;

import com.website.repository.AppUserRepository;
import com.website.repository.AppUserRole;
import com.website.user.AppUser;
@Service

public class RegistrationService {
	private AppUserService appUserService;
	private EmailValidator emailValidator;
	public RegistrationService(EmailValidator emailValidator) {
		super();
		this.emailValidator = emailValidator;
	}

	public String register(RegistrationRequest request) {
		// TODO Auto-generated method stub
		boolean isValidEmail =emailValidator.test(request.getEmail());
		if(!isValidEmail) {
			throw new IllegalStateException("email not vaild ");
		}
		return appUserService.signUpUser(
				new AppUser(
						request.getFirstName(),
						request.getLastName(),
						request.getEmail(),
						request.getPassword(),
						AppUserRole.USER	
						)
				);
	}

	public String confirmToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
