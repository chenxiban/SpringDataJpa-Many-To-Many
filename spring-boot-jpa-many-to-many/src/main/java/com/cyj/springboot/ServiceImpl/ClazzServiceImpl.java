package com.cyj.springboot.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.springboot.dao.ClazzRepository;
import com.cyj.springboot.entity.Clazz;
import com.cyj.springboot.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzRepository repository;

	@Override
	public Clazz save(Clazz clazz) {
		return repository.save(clazz);
	}

	@Override
	public Clazz queryById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Clazz> queryByNameLike(String name) {
		return repository.findByClazzNameLike("%" + name + "%");
	}

}
