package com.cyj.springboot.entity;

import java.util.HashSet;
import java.util.Set;

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

@Entity                                                //实体
@Table(name="usertb")                                  //表名
@GenericGenerator(name="userId", strategy="increment")  //声明主键生成策略
public class User {
    @Id                                                //指定主键
    @GeneratedValue	//自动增长列               //设定主键生成策略
    private Long userId;//用户唯一标识userId
    private String userName;//用户姓名
    private String userSex;//用户性别
    
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)                                      //指定多对多关系    //默认懒加载,只有调用getter方法时才加载数据
    @Cascade(value={CascadeType.SAVE_UPDATE})          //设置级联关系
    @JoinTable(name="user_role_tb",                       //指定第三张中间表名称
                joinColumns={@JoinColumn(name="user_role_tb_user_id")},             //本表主键userId与第三张中间表user_role_tb的外键user_role_tb_user_id对应
                    inverseJoinColumns={@JoinColumn(name="user_role_tb_role_id")})  //多对多关系另一张表与第三张中间表表的外键的对应关系
    @NotFound(action = NotFoundAction.IGNORE)	//NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
    private Set<Role> roleSet = new HashSet<Role>();//用户所拥有的角色集合
	
    
    
    
	//----------------------------- 以下是构造方法 ------------------------

	
	
	//----------------------------- 以下是Getter和setter方法 ------------------------
    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	
    
    
    
  //----------------------------- 以下是重写的toString方法 ------------------------
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + "]";
	}
    
	public String showUserAndRoleSet() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", roleSet=" + roleSet
				+ "]";
	}
    
    
    
   /* @Override
    public String toString() {
        return "UserBean [id=" + id + ", name=" + name + ", sex=" + sex
                + ", role=" + role + "]";
    }*/
}