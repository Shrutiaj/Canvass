package com.appapi.canvassapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appapi.canvassapi.models.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findUserByUserName(String userName);
}
