package com.appapi.canvassapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appapi.canvassapi.models.UserDetail;
import com.appapi.canvassapi.repositories.UserDetailRepository;

@Service
public class UserDetailDAO {
	@Autowired
	UserDetailRepository userDetailRepository;
	
	/* save a customer */
	public UserDetail save(UserDetail cust) {
		return userDetailRepository.save(cust);
	}
	
	/* search all customers */
	public List<UserDetail> findAll(){
		return (List<UserDetail>)userDetailRepository.findAll();
	}
	
	/* get a customer */
	public UserDetail getUserDetailByUserName(String userName) {
		return userDetailRepository.findUserDetailByUserName(userName);
	}
	
	/* delete a customer */
	public void delete(UserDetail userDetail) {
		userDetailRepository.delete(userDetail);
	}

}
