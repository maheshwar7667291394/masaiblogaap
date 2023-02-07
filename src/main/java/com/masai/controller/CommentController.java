package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CommentException;
import com.masai.model.Comment;
import com.masai.service.CommentService;

import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CommentController {
	
	@Autowired
	public CommentService cservice;
	
	@PostMapping("/api/comment")
	public ResponseEntity<Comment> addComment(@RequestBody Comment comment) throws CommentException{
		
		Comment comments=cservice.AddComment(comment);
		
		return new ResponseEntity<Comment>(comments,HttpStatus.OK);
		
	}
	
	@GetMapping("/api/comments")
	public ResponseEntity<List<Comment>> GetAllComment() throws CommentException{
		List<Comment> comments=cservice.GetAllComent();
		return new ResponseEntity<List<Comment>>(comments,HttpStatus.OK);
	}
	
	@DeleteMapping("/api/comment/{id}")
	public ResponseEntity<String> DelateComments(@PathVariable Integer id) throws CommentException{
		
		String result=cservice.DelateComent(id);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	@PutMapping("/api/comment/{id}")
	public ResponseEntity<Comment> UpdateComment(@RequestBody Comment comment,@PathVariable Integer id) throws CommentException{
		
		Comment cmt=cservice.UpdateComent(comment, id);
		
		return new ResponseEntity<Comment>(cmt,HttpStatus.OK);
		
	}
		
	
	
	

}
