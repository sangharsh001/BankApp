package com.bank.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDaoImpl;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;

public class Passbook {

	public static void passbook(Customer user)
	{
		TransactionDAO tdao=new TransactionDaoImpl();
	
    	ArrayList<Transaction> a1=tdao.getTransaction(user.getAcNo());
        
    	
    
    	Iterator<Transaction> l1=a1.iterator();
    	while(l1.hasNext())
    	{
    		Transaction t1= l1.next();
    		System.out.println("=========================================");
    		System.out.println("Transaction Id: "+t1.getTransactionID());
    		System.out.println("Account_number: "+t1.getRec_acc());
    		System.out.println("Transaction Type:"+t1.getTransactionType());
    		System.out.println("Transaction Date:"+t1.getTransactionDate());
    		if(t1.getTransactionType().equals("Credited"))
    		{
    		System.out.println("+"+t1.getAmount());
    		System.out.println("Balance:"+t1.getBalance());
    		System.out.println("=========================================");
    	    }
    		else
    		{
    			System.out.println("-"+t1.getAmount());
    			System.out.println("Balance:"+t1.getBalance());
    			System.out.println("=====================================");	
    		}
    		
    	}
	}
	
	
	
}
