package com.appapi.canvassapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appapi.canvassapi.models.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, String> {
	UserDetail findUserDetialByUserName(String userName);
}
