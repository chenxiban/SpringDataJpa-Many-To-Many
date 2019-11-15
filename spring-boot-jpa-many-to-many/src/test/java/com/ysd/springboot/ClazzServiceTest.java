package com.ysd.springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ysd.springboot.entity.Clazz;
import com.ysd.springboot.service.ClazzService;

@SpringBootTest		//提供Spring测试环境
@RunWith(SpringRunner.class)	//Spring集成Junit单元测试
public class ClazzServiceTest {
	
	@Autowired
	private ClazzService service;
	
	@Test
	public void queryById() {
		Clazz clazz = service.queryById(1);
		System.err.println("queryById 查询出的 Clazz对象 =>"+clazz.showClazzAndStudent());
	}
	
	@Test
	public void queryByNameLike() {
		List<Clazz> list = service.queryByNameLike("3");
		for(Clazz clazz:list) {
			System.err.println("queryByNameLike 查询出的 Clazz对象 =>"+clazz.showClazzAndStudent());
		}
	}

}
