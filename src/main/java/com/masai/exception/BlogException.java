package com.masai.exception;

import com.masai.model.Blog;

public class BlogException extends Exception{
	
	public  BlogException() {}
	
	public BlogException(String message) {
		super(message);
	}

}
