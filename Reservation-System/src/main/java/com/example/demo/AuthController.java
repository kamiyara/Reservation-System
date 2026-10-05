package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;

	}

	@PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody User newUser) {
		User createdUser = userService.createNewUser(newUser);
		if (createdUser == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok("登録できました。");
	}
	
}
