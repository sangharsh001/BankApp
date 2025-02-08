package com.bank.app;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDaoImpl;
import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDaoImpl;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;


public class App {
	public static void option(Customer c)
	{
		
	    CustomerDAO cdao=new CustomerDaoImpl();
	    Transaction t=new Transaction();
		Scanner sc1=new Scanner(System.in);
		int choice=0;
		TransactionDAO tdao=new TransactionDaoImpl();
		System.out.println("Welcome to "+c.getName());
      do {

  			
    		System.out.println("1.Check Balance");
    		System.out.println("2.Deposite");
    		System.out.println("3.Transfer The Amount");

    		
    		
//    			System.out.println("<---------Admin Module------------->");
    			System.out.println("4.Passbook");
    			System.out.println("5.Update Your Account");
    			System.out.println("6.Reset pin");
    			System.out.println("7.Back to main menu");
    		
//    			if(c.getAcNo()==1100110011)
//    			{
//    		   		
//    			System.out.println("1.Get a Customer Data");
//    			
//    			System.out.println("2.Get Transaction List");
//    			System.out.println("3.Delete Any User");
//    			System.out.println("4.Acces Your Account");
//    			System.out.println("5.Back to main menu");
//    			
//    			}
    		
    		choice =sc1.nextInt();
    		switch(choice)
    		{
    		case 1:System.out.println(c);
    		      System.out.println("Your balance is"+c.getBalance());
    		break;
    		case 2:Deposite.depositeAmt(c);
    			break;
    		 
    		case 3:Transfer.transferAmt(c);
    			 
    			 
    			 
    		 break;
    		 
            case 4:
//            	t.setUser(c.getAcNo());
            	Passbook.passbook(c);
            	
            	
        	  break;
          case 5:
        	  System.out.println("Enter a id to updtate");
        	  Update.update(c);
              break;
          case 6:ResetPin.resetPin(c);
        	  
        	   
        	  
        	  
        	  break;
        	  
        	 
          case 7:System.out.println("loading");
          break;
        	  
          
        	 default:
        	   System.out.println("Invalid ");
        	  
    		}
    	
    }
    	while(choice!=7);
    	}
       
		
		
		
		
		
		
		
		
		
		
		
	}


