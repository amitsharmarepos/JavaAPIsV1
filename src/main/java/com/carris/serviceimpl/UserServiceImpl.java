package com.carris.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carris.reqpayload.UserLoginPayload;

import com.carris.repository.UserRepository;
import com.carris.service.UserService;

import cpm.carris.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository; 	

	@Override
	public boolean userLogin(UserLoginPayload userLoginPayload) {

		boolean response = false;
		try {

			User user = userRepository.findByUsernameAndPassword(userLoginPayload.getUsername(), userLoginPayload.getPassword());

			if(user != null) {
				response = true;
			}
		} catch (Exception e) {
			return response;
		}

		return response;
	}

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {

		Optional<User> userData = userRepository.findById(user.getId());
		User userP = new User();
		if(userData.isPresent()) {
			userP = userData.get();
			userP.setAddress(user.getAddress());
			userP.setFullName(user.getFullName());
	
		}
		return userRepository.save(userP);
	}


}
