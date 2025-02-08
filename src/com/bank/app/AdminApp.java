package com.bank.app;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDaoImpl;
import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDaoImpl;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class AdminApp {
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

		
		
//			System.out.println("<---------Admin Module------------->");
			System.out.println("4.Passbook");
			System.out.println("5.Update Your Account");
			System.out.println("6.Reset pin");
//			System.out.println("7.Back to main menu");
		
			
		   		
			System.out.println("7.Get a Customer Data");
			
			System.out.println("8.Get Transaction List");
			System.out.println("9.Delete Any User");
			System.out.println("10.Acces Your Account");
			System.out.println("11.Back to main menu");
       	
		
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
//        	t.setUser(c.getAcNo());
        	Passbook.passbook(c);
        	
        	
    	  break;
      case 5:
    	  System.out.println("Enter a id to updtate");
    	  Update.update(c);
          break;
      case 6:ResetPin.resetPin(c);
    	  
    	   
    	  
    	  
    	  break;
    	  
    	 
      case 7:AllCustData.getDetails();
      break;
      
      case 8:TransactionList.transactionList();
    	  
    	  break;
    	  
      case 9:DeleteUser.deleteUser(c);
    	  
    	  break;
    	  
      case 10:AccessAct.accountdetail(c);
    	  break;
      
    	  
      case 11:System.out.println("Loading");
    	 default:
    	   System.out.println("Invalid ");
    	  
		}
	
  }
	while(choice!=11);
	}
}

