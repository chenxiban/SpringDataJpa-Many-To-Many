package com.cyj.springboot.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.springboot.dao.RoleRepository;
import com.cyj.springboot.entity.Role;
import com.cyj.springboot.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;

	@Override
	public Role queryById(Long id) {
		return repository.findOne(id);
	}

}
