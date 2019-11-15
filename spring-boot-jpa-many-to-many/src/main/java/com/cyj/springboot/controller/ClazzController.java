package com.ysd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.springboot.entity.Clazz;
import com.ysd.springboot.entity.Student;
import com.ysd.springboot.service.ClazzService;

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
@RequestMapping("/clazz")
public class ClazzController {

	@Autowired
	private ClazzService service;

	/**
	 * http://localhost:8080/clazz/queryById?id=1
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryById")
	public Clazz queryById(Integer id) {
		Clazz clazz = service.queryById(id);
		System.out.println("queryById clazz=>" + clazz.showClazzAndStudent());
		return clazz;
	}

	/**
	 * http://localhost:8080/clazz/queryId?id=1
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryId")
	public String queryId(Integer id) {
		Clazz clazz = service.queryById(id);
		System.out.println("queryById clazz=>" + clazz.showClazzAndStudent());
		return "查询成功";
	}

}
