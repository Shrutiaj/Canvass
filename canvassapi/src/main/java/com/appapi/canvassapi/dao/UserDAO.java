package com.appapi.canvassapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appapi.canvassapi.models.User;
import com.appapi.canvassapi.repositories.UserRepository;

@Service
public class UserDAO{
	@Autowired
	UserRepository userRepository;
	
	/* save a SubmittedSurvey */
	public User save(User user) {
		return userRepository.save(user);
	}
	
	/* search all SubmittedSurveys */
	public List<User> findAll(){
		return (List<User>)userRepository.findAll();
	}
	
	/* get a SubmittedSurvey */
	public User getUserByUserName(String userName) {
		return userRepository.findUserByUserName(userName);
	}
	
	/* delete a SubmittedSurvey */
	public void delete(User user) {
		userRepository.delete(user);
	}	
}