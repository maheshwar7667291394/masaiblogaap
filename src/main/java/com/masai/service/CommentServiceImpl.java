package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.BlogDao;
import com.masai.Repository.CommentDao;
import com.masai.exception.CommentException;
import com.masai.model.Blog;
import com.masai.model.Comment;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	public CommentDao cdao;
	
	@Autowired
	public BlogDao bdao;

	@Override
	public Comment AddComment(Comment comment) throws CommentException {
		
		  Blog blog=comment.getBlog();
		  List<Comment> comments=blog.getComments();
		  comments.add(comment);
		  
		  
		
		  bdao.save(blog);
		
		return comment;
	}

	@Override
	public List<Comment> GetAllComent() throws CommentException {
		List<Comment> comments=cdao.findAll();
		if(comments.size()==0) {
			throw new CommentException("no any comment found");
		}
		return comments;
	}

	@Override
	public String DelateComent(Integer id) throws CommentException {
		  Optional<Comment> comment=cdao.findById(id);
		  if(comment.isEmpty()) {
			  throw new CommentException("no comment found");
		  }
		  cdao.deleteById(id);
		  
		return "delation sucussfull";
	}

	@Override
	public Comment UpdateComent(Comment comments,Integer id) throws CommentException {
		
		Optional<Comment> cmt=cdao.findById(id);
		if(cmt.isEmpty()) {
			throw new CommentException("no any comment found");
		}
		return cdao.save(cmt.get());
		
		
	}
	
	

}
