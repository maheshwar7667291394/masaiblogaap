package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.UserDao;
import com.masai.Repository.SessonDao;
import com.masai.exception.UserException;
import com.masai.exception.LogeinException;
import com.masai.model.CurrentUserSesson;
import com.masai.model.User;
import com.masai.model.loginDTO;

import net.bytebuddy.utility.RandomString;

@Service
public class loginServiceImpl implements logeinServises{
	@Autowired
	private UserDao cdao;
	
	@Autowired
	private SessonDao sdao;

	@Override
	public String logIntoAccount(loginDTO dato) throws LogeinException {
		
		User existingCustomer=cdao.findBymobileNo(dato.getMobileNo());
		
		if(existingCustomer==null) {
			throw new LogeinException("plese Enter the valid mobile numebr");
		}
		
	Optional<CurrentUserSesson> validCustomersesson=	sdao.findById(existingCustomer.getCustomerId());
	
	if(validCustomersesson.isPresent()) {
		throw new LogeinException("user alredy present by this number");
	}
	
	if(existingCustomer.getPassword().equals(dato.getPassword())) {
		String key=RandomString.make(6);
		CurrentUserSesson currentusersesson=new CurrentUserSesson(existingCustomer.getCustomerId(), key, LocalDateTime.now());
		sdao.save(currentusersesson);
		return currentusersesson.toString();
	}

	
	throw new LogeinException("Enter valid user password");
		
	
		
	
	}



	@Override
	public String logOutAccount(String key) throws  LogeinException {
		
		CurrentUserSesson customer =sdao.findByuuid(key);
		if(customer==null) {
			throw new LogeinException("customer not logedin with this number");
		}
		
			sdao.delete(customer);
	
		
		return "customer loged out sucessfully";
	}

}
