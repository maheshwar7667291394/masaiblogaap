package com.masai.service;

import java.util.List;

import com.masai.exception.CommentException;
import com.masai.model.Comment;

public interface CommentService {
	public Comment AddComment(Comment comment)throws CommentException;
	public List<Comment> GetAllComent()throws CommentException;
	public String DelateComent(Integer id)throws CommentException;
	
	public Comment UpdateComent(Comment comments,Integer id) throws CommentException;

}
