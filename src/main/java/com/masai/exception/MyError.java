package com.masai.exception;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class MyError {
	private String message;
	private LocalDateTime localDateTime;
	private String details;

}
