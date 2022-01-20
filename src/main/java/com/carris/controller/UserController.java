package com.carris.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carris.reqpayload.UserLoginPayload;
import com.carris.service.UserService;

import cpm.carris.model.User;

	

@RestController
@RequestMapping("api/user/")

public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("userLogin")
	public HashMap<Object,Object> userLogin(@RequestBody UserLoginPayload userLoginPayload)
	{
		HashMap<Object,Object> hashMap = new HashMap<>();
		
		boolean userResponse = userService.userLogin(userLoginPayload);
		
		if(userResponse) {
			hashMap.put("status", 200);
			hashMap.put("message", "User login successfully");
		}
		
		return hashMap;
	}
	
	
	@PostMapping("signup")
	public HashMap<Object,Object> signup(@RequestBody User user)
	{
		HashMap<Object,Object> hashMap = new HashMap<>();
		
		User userResponse = userService.addUser(user);
		
		if(userResponse != null) {
			hashMap.put("status", 200);
			hashMap.put("message", "User added");
			hashMap.put("user", userResponse);
		}
		
		return hashMap;
	}
	
	
	@PostMapping("updateUser")
	public HashMap<Object,Object> updateUSer(@RequestBody User user)
	{
		HashMap<Object,Object> hashMap = new HashMap<>();
		
		User userResponse = userService.updateUser(user);
		
		if(userResponse != null) {
			hashMap.put("status", 200);
			hashMap.put("message", "User added");
			hashMap.put("user", userResponse);
		}
		
		return hashMap;
	}

}
