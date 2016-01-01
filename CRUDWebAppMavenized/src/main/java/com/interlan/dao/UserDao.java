package com.interlan.dao;

import java.util.List;

import com.interlan.model.User;

public interface UserDao {
	void addUser(User user);
	void editUser(User user);
	void deleteUser(int userId);
	User findUserById(int userId);
	User findUserByName(String userName);
	List<User> getAllUsers();
	
}
