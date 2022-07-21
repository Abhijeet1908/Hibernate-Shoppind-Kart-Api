package com.ty.shopping_kart.controller;

import com.ty.shopping_kart.dto.User;
import com.ty.shopping_kart.service.UserService;

public class SaveUser {
	
	public static void main(String[] args) {
		UserService service = new UserService();
		User user = new User();
		user.setName("Legain");
		user.setEmail("lee@gmail.com");
		user.setPhone(7588554566l);
		user.setPassword("123456");
	User users =service.saveUser(user);
	if (users!= null)
	{
		System.out.println("User saved sucesfully");
		System.out.println("ID is "+users.getId());
		System.out.println("Name is "+users.getName());
		System.out.println("Email is "+users.getEmail());
		System.out.println("Phone is "+users.getPhone());
		System.out.println("Password is "+users.getPassword());
	}
	else {
		System.out.println("User no user saved");
	}
	}

}
