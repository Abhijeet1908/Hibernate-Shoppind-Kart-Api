package com.ty.shopping_kart.service;

import static com.ty.shopping.util.AppConstants.SECRET_KEY;

import java.util.List;

import com.ty.shopping_kart.dao.UserDao;
import com.ty.shopping_kart.dto.User;
import com.ty.shopping.util.AES;

public class UserService {
	UserDao dao = new UserDao();

	public User saveUser(User user) {

		String encEmail = AES.encrypt(user.getEmail(), SECRET_KEY);
		String encPassword = AES.encrypt(user.getPassword(), SECRET_KEY);
		user.setEmail(encEmail);
		user.setPassword(encPassword);
		return dao.saveUser(user);
	}

	public User getUserById(int id) {
		User user = dao.getUserById(id);
		String decEmail = AES.decrypt(user.getEmail(), SECRET_KEY);
		String decPassword = AES.decrypt(user.getPassword(), SECRET_KEY);
		user.setEmail(decEmail);
		user.setPassword(decPassword);
		return user;

	}

	public List<User> getAllUser() {
		UserDao dao = new UserDao();
		return dao.getAllUser();
	}

	public User validateUser(String email, String password) {
		UserDao dao = new UserDao();
		return dao.validateUser(email, password);
	}

	public boolean deleteUserById(int id) {
		UserDao dao = new UserDao();
		return dao.deleteUserById(id);
	}

	public User updateUserById(User user, int id) {
		UserDao dao = new UserDao();
		return dao.updateUserById(user, id);
	}

}
