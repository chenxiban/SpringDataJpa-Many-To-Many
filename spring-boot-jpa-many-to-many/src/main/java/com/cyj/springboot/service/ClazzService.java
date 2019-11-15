package com.cyj.springboot.service;

import java.util.List;

import com.cyj.springboot.entity.Clazz;

public interface ClazzService {

	public Clazz save(Clazz clazz);

	public Clazz queryById(Integer id);

	public List<Clazz> queryByNameLike(String name);

}
