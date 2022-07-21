package com.ty.shopping_kart.controller;

import com.ty.shopping_kart.service.UserService;

public class TestDeleteUserbyId {
	public static void main(String[] args) {
		UserService service = new UserService();
		
		boolean flag = service.deleteUserById(2);
		
		if(flag==true)
		{
			System.out.println("User deleted sucessfully");
		}
		else
		{
			System.out.println("User not found");
		}
	}

}
