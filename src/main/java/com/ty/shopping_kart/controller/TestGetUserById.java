package com.ty.shopping_kart.controller;

import com.ty.shopping_kart.dto.User;
import com.ty.shopping_kart.service.UserService;

public class TestGetUserById {
	public static void main(String[] args) {
		UserService service = new UserService();
		User user = service.getUserById(3);

		if (user != null) {
			System.out.println("Id is " + user.getId());
			System.out.println("name  is " + user.getName());
			System.out.println("Email is " + user.getEmail());
			System.out.println("Phone is " + user.getPhone());
		} else {
			System.out.println("No user found");
		}

	}

}
