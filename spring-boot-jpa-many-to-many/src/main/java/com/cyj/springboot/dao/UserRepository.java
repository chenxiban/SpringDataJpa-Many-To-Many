package com.cyj.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyj.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
