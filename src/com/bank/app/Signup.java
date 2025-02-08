package com.bank.app;

import java.util.Scanner;

import com.bank.dao.CustomerDaoImpl;
import com.bank.dto.Customer;

public class Signup {
	
	public static void signUp()
	{
		Scanner sc=new Scanner(System.in);
		Customer c=new Customer();
		CustomerDaoImpl cdao=new CustomerDaoImpl(); 
		System.out.println("-----SignUp-----");
		System.out.println("Enter a name");
	     c.setName(sc.next());
	     System.out.println("Enter a phone"); 
	     c.setPhone(sc.nextLong());
	     System.out.println("Enter your Email");
	     c.setMail(sc.next());
//	     System.out.println("Enter a balane to Deposite");
//	     c.setBalance(sc.nextLong());
	     System.out.println("Create Your pin");
	    int pass= sc.nextInt();
	     System.out.println("Confirm your pin");
	     int cpass=sc.nextInt();
	     
	     if(pass==cpass)
	     {
	    	 c.setPin(pass);
	    	 
	    	boolean res= cdao.insertCustomer(c);
	    	 if(res)
	    	 {
	    		 System.out.println("Data Added Succesfully");
	    		 Customer cacc=cdao.getCustomer(c.getPhone(),c.getMail());
	    		 System.out.println("Your Account is:"+cacc.getAcNo());
	    		 
	    		 
	    		 
	    	 }
	    	 else {
	    		 System.out.println("Failed To add");
	    	 }
	    	 
	    	 
	     }
	     
	     
	}
	

}
