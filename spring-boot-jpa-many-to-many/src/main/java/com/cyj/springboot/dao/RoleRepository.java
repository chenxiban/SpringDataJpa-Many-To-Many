package com.cyj.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyj.springboot.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
