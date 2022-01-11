package com.website.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.website.repository.AppUserRepository;
import com.website.user.AppUser;

@Service
public class AppUserService implements UserDetailsService{
	private final static String USER_NOT_FOUND="user not found";
	private final AppUserRepository appUserRepository;
	public AppUserService(AppUserRepository appUserRepository) {
		super();
		this.appUserRepository = appUserRepository;
	}
		@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return appUserRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(email, USER_NOT_FOUND)));
	}

		public String signUpUser(AppUser appUser) {
			return "";
		}
	
}
