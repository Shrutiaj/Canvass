package com.appapi.canvassapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appapi.canvassapi.models.Role;
import com.appapi.canvassapi.repositories.RoleRepository;

@Service
public class RoleDAO {
	@Autowired
	RoleRepository roleRepository;
	
	/* save a Role */
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
	/* search all Roles */
	public List<Role> findAll(){
		return (List<Role>)roleRepository.findAll();
	}
	
	/* get a Role */
	public Role getRoleById(Long roleID) {
		return roleRepository.findRoleByRoleID(roleID);
	}
	
	/* delete a Role */
	public void delete(Role cust) {
		roleRepository.delete(cust);
	}
}
