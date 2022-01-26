package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void createUser(User user) {
		userDao.save(user);
	}
	
	@Override
	public User getUserById(Long id) {
		return userDao.getById(id);
	}
	
	@Override
	public void updateUser(User user) {
		userDao.save(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		userDao.delete(userDao.getById(id));
	}
	
	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.findUserByName(username);
	}
}
