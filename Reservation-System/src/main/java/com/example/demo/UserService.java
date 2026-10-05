package com.example.demo;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	//Userの新規作成
	public User createNewUser(User newUser) {
		String newUsername = newUser.getUsername();
		String rawPassword = newUser.getPassword();

		//Usernameが未記入、空または既に使用されている場合はnullを返す
		if (newUsername == null || newUsername.isEmpty()) {
			return null;
		} else if (userRepository.findByUsername(newUsername).isPresent()) {
			return null;
		}

		//Passwordが未記入または空の場合はnullを返す
		if (rawPassword == null || rawPassword.isEmpty()) {
			return null;
		}
		newUser.setPassword(passwordEncoder.encode(rawPassword));
		return userRepository.save(newUser);
	}

}
