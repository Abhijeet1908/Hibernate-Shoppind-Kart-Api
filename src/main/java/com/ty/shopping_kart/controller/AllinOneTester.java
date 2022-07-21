package com.ty.shopping_kart.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.shopping_kart.dto.User;
import com.ty.shopping_kart.service.UserService;

public class AllinOneTester {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		boolean tag = true;

		while (tag) {
			System.out.println("================Menu=========================");
			System.out.println("Press 1. to Save a User");
			System.out.println("Press 2. to get User by Id ");
			System.out.println("Press 3. to get all User details");
			System.out.println("Press 4. to validate User");
			System.out.println("Press 5. to Delete a User by Id");
			System.out.println("Press 6. to exit");
			System.out.println("==============================================");
			
			int choice = t.nextInt();
			switch (choice) {
			case 1: {
				UserService service = new UserService();
				User user = new User();
				System.out.println("Enter user name");
				String name = t.next();

				System.out.println("Enter user email");
				String email = t.next();

				System.out.println("Enter User phone");
				long phone = t.nextLong();

				System.out.println("Enter new Password");
				String pass = t.next();

				user.setName(name);
				user.setEmail(email);
				user.setPhone(phone);
				user.setPassword(pass);
				User users = service.saveUser(user);
				if (users != null) {
					System.out.println("User saved sucesfully");
					System.out.println("ID is = " + users.getId());
					System.out.println("Name is = " + users.getName());
					System.out.println("Email is = " + users.getEmail());
					System.out.println("Phone is = " + users.getPhone());
					System.out.println("Password is = " + users.getPassword());
				} else {
					System.out.println("User no user saved");
				}
			}
				break;

			case 2:

			{
				UserService service = new UserService();
				System.out.println("Enter user Id");
				int id = t.nextInt();
				User user = service.getUserById(id);

				if (user != null) {
					System.out.println("Id is = " + user.getId());
					System.out.println("name  is = " + user.getName());
					System.out.println("Email is = " + user.getEmail());
					System.out.println("Phone is = " + user.getPhone());
				} else {
					System.out.println("No user found");
				}
			}
				break;

			case 3: {

				UserService service = new UserService();
				List<User> users = service.getAllUser();
				for (User user : users) {
					System.out.println("User saved sucesfully");
					System.out.println("ID is = " + user.getId());
					System.out.println("Name is = " + user.getName());
					System.out.println("Email is = " + user.getEmail());
					System.out.println("Phone is = " + user.getPhone());
					System.out.println("--------------------------------------------------------------------------");

				}
			}
				break;

			case 4: {
				System.out.println("Enter Email");
				String email = t.next();
				System.out.println("Enter Password");
				String pass = t.next();
				UserService service = new UserService();
				User user = service.validateUser(email, pass);

				if (user != null) {
					System.out.println("User details matched");
					System.out.println("ID is = " + user.getId());
					System.out.println("Name is = " + user.getName());
					System.out.println("Email is = " + user.getEmail());
					System.out.println("Phone is = " + user.getPhone());
				} else {
					System.out.println("User not found");
				}
			}
				break;

			case 5: {
				System.out.println("Enter the User Id to delete");
				int id = t.nextInt();
				UserService service = new UserService();

				boolean flag = service.deleteUserById(id);

				if (flag == true) {
					System.out.println("User deleted sucessfully");
				} else {
					System.out.println("User not found");
				}
			}
				break;
			case 6: {
				tag = false;
				System.out.println("Thank you");
			}
				break;

			default: {
				System.out.println("Please enter from the options provided above");
			}
			}

		}
	}

}
