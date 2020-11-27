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

import com.appapi.canvassapi.dao.UserDetailDAO;
import com.appapi.canvassapi.models.UserDetail;

@RestController
@RequestMapping("/UserDetail")
@CrossOrigin(origins = "*")
public class UserDetailController {
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@GetMapping("/all")
	public List<UserDetail> getAllUserDetails(){
		return userDetailDAO.findAll();
	}
	
	@GetMapping("/getByUserName")
	public UserDetail getUserDetailByUserName(String userName){
		return userDetailDAO.getUserDetailByUserName(userName);
	}
	
	@PostMapping("/createUserDetail")
	public UserDetail createUserDetail(@Valid @RequestBody UserDetail userDetail) {
		return userDetailDAO.save(userDetail);
	}
}
