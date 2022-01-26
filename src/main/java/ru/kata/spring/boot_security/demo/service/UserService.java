package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;


import java.util.List;

public interface UserService {
	void createUser(User user);
	User getUserById(Long id);
	void updateUser(User user);
	void deleteUser(Long id);
	List<User> getUsers();
}
