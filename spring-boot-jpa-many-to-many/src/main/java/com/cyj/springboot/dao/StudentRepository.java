package com.cyj.springboot.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cyj.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	//Like --- 等价于 SQL 中的 "like"，比如 findByNameLike(String name);  
    public List<Student> findByStudentNameLike(String name);

}
