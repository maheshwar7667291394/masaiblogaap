package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.BlogDao;
import com.masai.exception.BlogException;
import com.masai.model.Blog;
import com.masai.model.Comment;

@Service
public class BlogServiceImple implements BlogService{
	
	@Autowired
	private BlogDao bdao;
	

	@Override
	public Blog SaveBlog(Blog blog) {
		   List<Comment> coments=blog.getComments();
		   for(Comment c:coments) {
			   c.setBlog(blog);
		   }
		
		Blog saveblog=bdao.save(blog);
		return saveblog;
		
		
	}

	@Override
	public List<Blog> GetAllBlog() throws BlogException {
		
		List<Blog> blogs=bdao.findAll();
		
		if(blogs.size()==0) {
			throw new BlogException("no any blog found");
		}
		
		
		return blogs;
	}

	@Override
	public Blog GetBlogById(Integer id) throws BlogException {
		Optional<Blog> blog=bdao.findById(id);
		
		Blog blogs=blog.get();
		if(blogs==null) {
			throw new BlogException("blog not found by this id");
		}
		return blogs;
	}

	@Override
	public Blog UpdateBlog(Blog blog,Integer id) throws BlogException {
		
		Optional<Blog> findblog=bdao.findById(id);
		
		if(findblog.isPresent()) {
			Blog updatedblog=bdao.save(blog);
			return blog;
		}
		return blog;
		
		
	}

	@Override
	public String DelateBlog(Integer id) throws BlogException {
	    Optional<Blog> blog=bdao.findById(id);
	    
	    if(blog.isEmpty()) {
	    	throw new BlogException("no blog found by this id");
	    }
	    bdao.deleteById(id);
	    return "Delation sussfull";
	}
	
	

	

}
