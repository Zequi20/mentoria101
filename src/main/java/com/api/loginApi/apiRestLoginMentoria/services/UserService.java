package com.api.loginApi.apiRestLoginMentoria.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.api.loginApi.apiRestLoginMentoria.models.UserModel;
import com.api.loginApi.apiRestLoginMentoria.repositories.IUserRepository;

@Service
public class UserService {

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	
	public ArrayList<UserModel> getUsers(){
		return (ArrayList<UserModel>) userRepository.findAll();
	}
	
	
	public UserModel saveUser(UserModel user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	
	public Optional<UserModel> getById(Long id){
		return userRepository.findById(id);
	}
	
	public UserModel updateById(UserModel request ,Long id){
		UserModel user = userRepository.findById(id).get();
		
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
		
		return user;
	}
	
	public Boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
