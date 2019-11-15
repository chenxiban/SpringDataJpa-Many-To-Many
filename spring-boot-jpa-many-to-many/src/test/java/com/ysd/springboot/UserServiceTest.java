package com.ysd.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ysd.springboot.entity.User;
import com.ysd.springboot.service.UserService;

@SpringBootTest		//提供Spring测试环境
@RunWith(SpringRunner.class)	//Spring集成Junit单元测试
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	
	@Test
	public void queryById() {
		User user = service.queryById(1L);
		System.out.println("查询出的User对象=>"+user.showUserAndRoleSet());
		
	}
	

}
