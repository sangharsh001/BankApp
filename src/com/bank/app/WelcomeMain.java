package com.bank.app;

import java.util.Scanner;

public class WelcomeMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;
		System.out.println("Weclome To Bank");
		do {
		System.out.println("Enter a option");
		System.out.println("1.Login");
		System.out.println("2.SigUp");
		System.out.println("3.Back to Menu");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:Login.login();
		       break;
		case 2:
		       Signup.signUp();
		     break;
		case 3:System.out.println("loading");
			break;
			
		default:System.out.println("invalid");
		
		}
		
		}
		while(choice!=3);
		
		
	}
	

}
