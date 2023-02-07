package com.masai.service;

import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserServiceImpl {
	
	public User CreateCustomer(User customer)throws UserException;
	public User UpdateCustomer(User customer,String key)throws UserException;

}
