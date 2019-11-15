package com.cyj.springboot.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.springboot.dao.StudentRepository;
import com.cyj.springboot.entity.Student;
import com.cyj.springboot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Student queryById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Student> queryByNameLike(String name) {
		return repository.findByStudentNameLike("%" + name + "%");
	}

}
