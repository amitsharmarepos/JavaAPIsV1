package com.carris.service;

import com.carris.reqpayload.*;

import cpm.carris.model.User;


public interface UserService {

	boolean userLogin(UserLoginPayload userLoginPayload);

	User addUser(User user);

	User updateUser(User user);

}
