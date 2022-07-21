package com.ty.shopping_kart.controller;

import java.util.List;

import com.ty.shopping_kart.dto.User;
import com.ty.shopping_kart.service.UserService;

public class TestGetAlluser{
	public static void main(String[] args) {
		UserService service = new UserService();
		List<User> users=service.getAllUser();
		for (User user: users)
		{
			System.out.println("User saved sucesfully");
			System.out.println("ID is "+user.getId());
			System.out.println("Name is "+user.getName());
			System.out.println("Email is "+user.getEmail());
			System.out.println("Phone is "+user.getPhone());
			System.out.println("--------------------------------------------------------------------------");
			
		}
	}

}
