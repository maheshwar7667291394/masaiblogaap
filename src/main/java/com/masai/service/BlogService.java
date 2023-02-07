package com.masai.service;

import java.util.List;

import com.masai.exception.BlogException;
import com.masai.model.Blog;



public interface BlogService {
	
	public Blog SaveBlog(Blog blog);
	public  List<Blog> GetAllBlog()throws BlogException;
	public Blog GetBlogById(Integer id)throws BlogException;
	
	public Blog UpdateBlog(Blog blog,Integer id)throws BlogException;
	
	public String DelateBlog(Integer id)throws BlogException;

}
