package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.exception.LogeinException;
import com.masai.model.loginDTO;

public interface logeinServises {
	
	public String logIntoAccount(loginDTO dato)throws  LogeinException;
	public String logOutAccount(String key) throws LogeinException;
	
	

}
