package com.cyj.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyj.springboot.entity.Student;
import com.cyj.springboot.service.StudentService;

/**
 * SpringMVC控制器
 * 
 * @Description: 子模块
 * @ClassName: CityRestController.java
 * @author Mashuai
 * @Date 2017-10-4 下午8:04:34
 * @Email 1119616605@qq.com
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	/**
	 * http://localhost:8080/student/queryById?id=1
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryById")
	public Student queryById(Integer id) {
		Student student = service.queryById(id);
		System.out.println("queryById student=>" + student.showStudentAndClazz());
		return student;
	}

	/**
	 * http://localhost:8080/student/queryId?id=1
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryId")
	public String queryId(Integer id) {
		Student student = service.queryById(id);
		System.out.println("queryById student=>" + student.showStudentAndClazz());
		return "查询成功";
	}

	/**
	 * http://localhost:8080/student/queryByNameLike?name=张三
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryByNameLike")
	public Object queryByNameLike(String name) {
		List<Student> list = service.queryByNameLike(name);
		System.out.println("queryByNameLike list=>" + list);
		for (Student s : list) {
			System.out.println("Student =>" + s.showStudentAndClazz());
		}
		return list;
	}

}
