package com.cyj.springboot.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.springboot.dao.UserRepository;
import com.cyj.springboot.entity.User;
import com.cyj.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User queryById(Long id) {
		return repository.findOne(id);
	}

}
