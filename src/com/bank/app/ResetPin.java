package com.bank.app;

import java.util.Scanner;

import com.bank.dto.Customer;
import com.bank.dao.*;
public class ResetPin {
	
	public static void resetPin(Customer c)
	{
		Scanner sc=new Scanner(System.in);
		CustomerDAO cdao=new CustomerDaoImpl();
		System.out.println("====Password Reset=====");
		System.out.println("Enter your Email");
		String mail=sc.next();
		System.out.println("Enter your Phone");
		long phone=sc.nextLong();
		boolean res=false;
	   if(c.getMail().equals(mail) && c.getPhone()==phone)
	   {
		   System.out.println("Enter a Pin");
		  int pin=sc.nextInt();
		  System.out.println("Confirm Your Pin");
		  
		  int cpin=sc.nextInt();
		  if(pin==cpin)
		  {
			  c.setPin(cpin);
			  res= cdao.updateCustomer(c);
		  }
		  else
		  {
			  System.out.println("pin mismatch");
		  }
		  
		  if(res)
		  {
			  System.out.println("Pin reset Succesfully");
		  }
		  
		   
	   }
	   else
	   {
		   System.out.println("Emial or Phone no is mismatch");
	   }
		 
		
	}

}
