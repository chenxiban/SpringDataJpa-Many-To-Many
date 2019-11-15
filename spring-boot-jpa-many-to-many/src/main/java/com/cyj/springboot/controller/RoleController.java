package com.cyj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyj.springboot.entity.Role;
import com.cyj.springboot.service.RoleService;

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
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService service;

	/**
	 * http://localhost:8080/role/queryById?id=4
	 * 
	 * @param id
	 * @return Role
	 */
	@RequestMapping("/queryById")
	public Role queryById(Long id) {
		Role role = service.queryById(id);
		System.out.println("queryById role=>" + role.showRoleAndUserSet());
		return role;
	}

}
