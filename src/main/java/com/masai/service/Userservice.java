package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.UserDao;
import com.masai.Repository.SessonDao;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSesson;
import com.masai.model.User;


@Service
public class Userservice implements UserServiceImpl{
	@Autowired
	public UserDao cdao;
	
	@Autowired
	public SessonDao sdao;

	@Override
	public User CreateCustomer(User customer) throws UserException {
		
		User ExistingCustomer=cdao.findBymobileNo(customer.getMobileNo());
		
		if(ExistingCustomer!=null) {
			throw new UserException("Customer already register with mobile number");
		}
		
		return cdao.save(customer);
	
	
	}

	@Override
	public User UpdateCustomer(User customer, String key) throws UserException {
		
		CurrentUserSesson logedincustomer=sdao.findByuuid(key);
		if(logedincustomer!=null) {
			throw new UserException("plese provide customer key");
		}
		
		if(customer.getCustomerId()==logedincustomer.getUserId()) {
			return cdao.save(customer);
		}
		else {
			throw new UserException("invalid customer details plese login first");
		}
		
	
	}

}
