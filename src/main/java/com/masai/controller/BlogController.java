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

import com.masai.exception.BlogException;
import com.masai.model.Blog;
import com.masai.service.BlogService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BlogController {
	
	@Autowired
	public BlogService bservice;
	
	@PostMapping("/api/posts")
	public ResponseEntity<Blog> PostBlog(@RequestBody Blog blog){
		
		Blog postedblog=bservice.SaveBlog(blog);
		
		return new ResponseEntity<>(postedblog,HttpStatus.OK);
		
	}
	
	@GetMapping("/api/gets")
	public ResponseEntity<List<Blog>> GetAllBlogs() throws BlogException{
		
		List<Blog> blogs=bservice.GetAllBlog();
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
		
	}
	
	@GetMapping("/api/blogId")
	public ResponseEntity<Blog> GetBlogByid(@PathVariable Integer blogid) throws BlogException{
		
		Blog blog=bservice.GetBlogById(blogid);
		
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		
	}
	
	@PutMapping("/api/blog/{id}")
	public ResponseEntity<Blog> UpdateBlog(@RequestBody Blog blog,@PathVariable Integer id) throws BlogException{
		
		Blog updated=bservice.UpdateBlog(blog, id);
		
		return new ResponseEntity<Blog>(updated,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/api/delate/{id}")
	public ResponseEntity<String> DelateBlog(@PathVariable Integer id) throws BlogException{
		
		String s=bservice.DelateBlog(id);
		return new ResponseEntity<String>(s,HttpStatus.OK);
		
		
		
	}
	

}
