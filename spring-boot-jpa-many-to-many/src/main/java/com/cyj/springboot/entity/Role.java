package com.cyj.springboot.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.cyj.springboot.entity.User;



@Entity                                              //实体
@Table(name="roletb")                                //表名
@GenericGenerator(name="roleId", strategy="increment")//声明主键生成策略
public class Role {
    @Id                                              //主键
    @GeneratedValue	//自动增长列                   //设置主键生成策略
    private Long roleId;//角色唯一标识roleId
    private String rolePost;//角色的职位
    private int rolePay;    //角色的薪资
    
    
    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER)                                      //多对多关系  
    @Cascade(value={CascadeType.SAVE_UPDATE})        //级联关系
    @JoinTable(name="user_role_tb",                       //指定第三张中间表名称
                joinColumns={@JoinColumn(name="user_role_tb_role_id")},   //本表主键roleId与第三张中间表user_role_tb的外键user_role_tb_role_id对应.本表与中间表的外键对应关系
                    inverseJoinColumns={@JoinColumn(name="user_role_tb_user_id")}) //另一张表与中间表的外键的对应关系
    @NotFound(action = NotFoundAction.IGNORE)	//NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
    private Set<User>  userSet = new HashSet<User>();//拥有该角色的所有用户集合
	

    
  //----------------------------- 以下是构造方法 ------------------------

	
	
  //----------------------------- 以下是Getter和setter方法 ------------------------
    public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRolePost() {
		return rolePost;
	}
	public void setRolePost(String rolePost) {
		this.rolePost = rolePost;
	}
	public int getRolePay() {
		return rolePay;
	}
	public void setRolePay(int rolePay) {
		this.rolePay = rolePay;
	}
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	
    
  //----------------------------- 以下是重写的toString方法 ------------------------
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", rolePost=" + rolePost + ", rolePay=" + rolePay + "]";
	}
    
	public String showRoleAndUserSet() {
		return "Role [roleId=" + roleId + ", rolePost=" + rolePost + ", rolePay=" + rolePay + ", userSet=" + userSet
				+ "]";
	}
    
}
