package com.cyj.springboot.service;

import java.util.List;

import com.cyj.springboot.entity.Student;

public interface StudentService {

	public Student queryById(Integer id);

	public List<Student> queryByNameLike(String name);

}
