package com.api.loginApi.apiRestLoginMentoria.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.loginApi.apiRestLoginMentoria.models.UserModel ;
import com.api.loginApi.apiRestLoginMentoria.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private	UserService	userService;
	
	@GetMapping
	public ArrayList<UserModel> getUsers(){
		return this.userService.getUsers();
	}
	
	@PostMapping
	public UserModel saveUser(@RequestBody UserModel user) {
		return this.userService.saveUser(user);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UserModel> getUserById(@PathVariable Long id){
		return this.userService.getById(id);
		
	}
	
	@PutMapping(path = "/{id}")
	public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id) {
		return this.updateUserById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		boolean ok = this.userService.deleteUser(id);
		if(ok) {
			return "Usuario eliminado";
		}else {
			return "Error al eliminar usuario";
		}
	}
	
	
}
