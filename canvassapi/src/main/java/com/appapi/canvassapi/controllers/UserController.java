package com.appapi.canvassapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appapi.canvassapi.dao.UserDAO;
import com.appapi.canvassapi.models.User;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/all")
	public List<User> getAllSurveyQuestions(){
		return userDAO.findAll();
	}
	
	@GetMapping("/getByResponseID")
	public User getSurveyQuestionByID(String userName){
		return userDAO.getUserByUserName(userName);
	}
	
	@PostMapping("/createSubmittedSurvey")
	public User createUser(@Valid @RequestBody User user) {
		return userDAO.save(user);
	}
}
