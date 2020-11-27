package com.appapi.canvassapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appapi.canvassapi.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findCustomerByCustomerId(Long roleID);

}
