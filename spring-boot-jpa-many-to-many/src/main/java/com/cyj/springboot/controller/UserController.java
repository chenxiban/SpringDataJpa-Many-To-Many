package com.cyj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyj.springboot.entity.User;
import com.cyj.springboot.service.UserService;

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
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * http://localhost:8080/user/queryById?id=1
	 * 
	 * @param id
	 * @return User
	 */
	@RequestMapping("/queryById")
	public User queryById(Long id) {
		User user = service.queryById(id);
		System.out.println("queryById user=>" + user.showUserAndRoleSet());
		return user;
	}

}
