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

import com.appapi.canvassapi.dao.RoleDAO;
import com.appapi.canvassapi.models.Role;

@RestController
@RequestMapping("/Role")
@CrossOrigin(origins = "*")
public class RoleController {
	@Autowired
	RoleDAO roleDAO;
	
	@GetMapping("/all")
	public List<Role> getAllCustomers(){
		return roleDAO.findAll();
	}
	
	@GetMapping("/getByRoleID")
	public Role getCustomerByID(Long roleID){
		return roleDAO.getRoleById(roleID);
	}
	
	@PostMapping("/createRole")
	public Role createRole(@Valid @RequestBody Role role) {
		return roleDAO.save(role);
	}
}
