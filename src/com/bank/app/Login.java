package com.bank.app;

import java.util.Scanner;

import com.bank.dao.CustomerDaoImpl;
import com.bank.dao.CustomerDAO;
import com.bank.dto.Customer;

public class Login {
	public static void login()
	{
//		Customer c=new Customer();
		Scanner sc=new Scanner(System.in);
		CustomerDAO cdao=new CustomerDaoImpl(); 
		System.out.println("-----Log in----");
		System.out.println("Enter a Account number");
//		String mail=sc.next();
		
		long accno=sc.nextLong();
		System.out.println("Enter a pin");
        int pin=sc.nextInt();
        Customer c= cdao.getCustomer(accno, pin);
        
        
        if(c!=null && c.getPin()==pin)
        {
        	
        	if(c.getAcNo()!=1100110011)
        	 {
             	System.out.println("Log in Succuessfull");
                 App.option(c);
         
           }
         
            
             else
             {
             	System.out.println("Welcom to Admin:"+c.getName());
             	AdminApp.option(c);
             }
         
        }
        else
        {
        	System.out.println("Login Unsuuccesfull");
        }

  
        
        
	} 
}
