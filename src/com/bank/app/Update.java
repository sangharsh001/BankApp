package com.bank.app;

import java.util.Scanner;

import com.bank.dao.CustomerDaoImpl;
import com.bank.dto.Customer;



public class Update {

	public static void update(Customer c)
	{
		

		CustomerDaoImpl cdao=new CustomerDaoImpl();
		Scanner sc=new Scanner(System.in);
        int choice=0;
	    boolean res=false;

		do {
		System.out.println("1.Name");
		System.out.println("2.phone");
		System.out.println("3.mail");
//		System.out.println("4.pin");
		System.out.println("4 .Back to main menu");
		
		
        choice=sc.nextInt();
		switch(choice)
		{
		
		case 1:System.out.println("Enter the name to be update");
		       c.setName(sc.next());
		       System.out.println(c);
		       res=cdao.updateCustomer(c);
		       break;
		case 2:
			System.out.println("Enter the Phone to  update");
		       c.setPhone(sc.nextLong());
		       res= cdao.updateCustomer(c);

			
			break;
			
		case 3:
			   System.out.println("Enter the Mail to  update");
		       c.setMail(sc.next());
		       res= cdao.updateCustomer(c);
			   break;
//		case 4:
//			
//			System.out.println("Enter the Brach to  update");
//		       c.setPin(sc.nextInt());
//		      res= cdao.updateCustomer(c);
//			break;
		
		case 4:System.out.println("Loading...");
		    break;
		    
		default:System.out.println("invaild");
		}
			
		if(res)
		{
			System.out.println("Updtaed Successfully");
		}
		else
		{
			System.out.println("Faild to Update");
		}
		
		}
		
		while(choice!=4);
		
		
		
	}
}
