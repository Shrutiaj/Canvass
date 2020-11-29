package com.appapi.canvassapi.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appapi.canvassapi.dao.UserDAO;
import com.appapi.canvassapi.models.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@GetMapping("/getByUserName")
	public User getUserByUserName(String userName){
		return userDAO.getUserByUserName(userName);
	}
	
	@PostMapping("/createUser")
	public void createUser(@Valid @RequestBody String user) throws JsonParseException, 
    JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User userObject = mapper.readValue(user, User.class);
		userDAO.save(userObject);
	}
	
	@PostMapping("/isValid")
	public boolean isValidUser(@Valid @RequestBody String user) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		User userObject = mapper.readValue(user, User.class);
		User dbUser = userDAO.getUserByUserName(userObject.getUserName());
		if(dbUser != null)
		{
			if(dbUser.getPassword().equals(userObject.getPassword())) {
				return true;
			}			
		}
		return false;
	}

}
