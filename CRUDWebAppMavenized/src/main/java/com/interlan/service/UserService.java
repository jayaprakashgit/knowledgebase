package com.interlan.service;

import java.util.List;

import com.interlan.model.User;

public interface UserService {
	void addUser(User user);
	void editUser(User user);
	void deleteUser(int userId);
	User findUserById(int userId);
	User findUserByName(String userName);
	List<User> getAllUsers();
}
