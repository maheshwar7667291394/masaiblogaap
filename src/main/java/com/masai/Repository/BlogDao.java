package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Blog;

@Repository
public interface BlogDao extends JpaRepository<Blog, Integer>{

}
