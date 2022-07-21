package com.ty.shopping_kart.controller;

import com.ty.shopping_kart.dto.User;
import com.ty.shopping_kart.service.UserService;

public class TestValidateUser {
	public static void main(String[] args) {
		UserService service = new UserService();
		User user = service.validateUser("lee@gmail.com", "123456");

		if (user != null) {
			System.out.println("User details matched");
			System.out.println("ID is " + user.getId());
			System.out.println("Name is " + user.getName());
			System.out.println("Email is " + user.getEmail());
			System.out.println("Phone is " + user.getPhone());
		}
		else
		{
			System.out.println("User not found");
		}
	}

}
