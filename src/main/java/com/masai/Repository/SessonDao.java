package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentUserSesson;

@Repository
public interface SessonDao extends JpaRepository<CurrentUserSesson, Integer>{
	
	public CurrentUserSesson findByuuid(String uuid);

}
