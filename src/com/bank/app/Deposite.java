package com.bank.app;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDaoImpl;
import com.bank.dao.TransactionDaoImpl;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.bank.dao.TransactionDAO;
public class Deposite {
	
	public static void depositeAmt(Customer c)
	{
		
		Transaction depositeAcc=new Transaction();
		TransactionDAO tdao=new TransactionDaoImpl();
		Scanner sc=new Scanner(System.in);
		CustomerDAO cdao=new CustomerDaoImpl(); 
		
		System.out.println("Enter amount to Deposite");
		Double amount=sc.nextDouble();
        c.setBalance(c.getBalance()+amount);
//        System.out.println(c);
        boolean res= cdao.depositeCustomer(c);
        
       
        
        depositeAcc.setTransactionID(Transactiono.genTransaction());
  
        depositeAcc.setUser(c.getAcNo());
        depositeAcc.setRec_acc(c.getAcNo());
        depositeAcc.setTransactionType("Credited");
        depositeAcc.setAmount(amount);
        depositeAcc.setBalance(c.getBalance());
        boolean rectdet=tdao.insertTransaction(depositeAcc);
        

        
      if(res &&rectdet )
      {
    	  
    	  
    	  
    	  
    	  System.out.println("Deposited Succesfully");
      }
      else
      {
    	  System.out.println("Unsuccesfull");
      }
	}

}
