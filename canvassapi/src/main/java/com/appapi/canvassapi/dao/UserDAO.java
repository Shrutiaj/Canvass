package com.appapi.canvassapi.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appapi.canvassapi.models.User;
import com.appapi.canvassapi.models.UserDetail;
import com.appapi.canvassapi.repositories.UserRepository;

@Service
public class UserDAO{
	@Autowired
	UserRepository userRepository;
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("survey");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction et = entityManager.getTransaction();
	
	/* save a User */
	public Optional<User> save(User user) {
		try {
			if(!et.isActive()) {
				et.begin();
				entityManager.persist(user);
				UserDetail userDetail = user.getUserDetail();
				userDetail.setUserName(user.getUserName());
				entityManager.persist(user.getUserDetail());
				et.commit();
			}
			
			return Optional.of(user);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/* search all Users */
	public List<User> findAll(){
		return (List<User>)userRepository.findAll();
	}
	
	/* get a User */
	public User getUserByUserName(String userName) {
		return userRepository.findUserByUserName(userName);
	}
	
	/* delete a user */
	public void delete(User user) {
		userRepository.delete(user);
	}	
}