package com.wiley.bookpub.view;

import java.util.Scanner;

public class MainView {
	
	public static void choice() {
		// login as admin
		// login as user
		// create new user
		// exit
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as User");
		System.out.println("3. Create new user");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
		int ch = sc.nextInt();
	}
	
}