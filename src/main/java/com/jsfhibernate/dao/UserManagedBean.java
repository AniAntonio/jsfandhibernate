package com.jsfhibernate.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jsfhibernate.pojo.User;
import com.jsfhibernate.util.UserModel;

@SessionScoped
@ManagedBean(name="userManagedBean")
public class UserManagedBean {

	private User user;
	private List<User> users;
	
	
    
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserManagedBean() {
		   user = new User();
		UserModel usermodel = new UserModel();
		this.users = usermodel.getAllUsers();
	}

	public String create() {
		UserModel usermodel = new UserModel();
		usermodel.create(this.user);
		return "ok";
	}
	public String getById(Long  id) {
		UserModel usermodel = new UserModel();
		user=usermodel.getById(id);
		return "ok";
	}
	public void delete(Long id) {
		UserModel usermodel = new UserModel();
		usermodel.delete(id);
	}
	
	public void update() {
		UserModel usermodel = new UserModel();
		usermodel.update(this.user);
	
	}

}
