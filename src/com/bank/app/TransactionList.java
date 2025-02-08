package com.bank.app;

import java.util.ArrayList;
import java.util.ListIterator;

import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDaoImpl;
import com.bank.dto.Transaction;

public class TransactionList {

	public static void  transactionList() {
		
		TransactionDAO tdao=new TransactionDaoImpl();
		
		ArrayList<Transaction> arr=tdao.getTransaction();
	    ListIterator<Transaction> lt=arr.listIterator();
		while(lt.hasNext())
		{
          Transaction t=lt.next();	
          System.out.println("===================================");
          System.out.println("TransactionID:"+  t.getTransactionID());
          System.out.println("User Account"+t.getUser());
          System.out.println("Account Number"+t.getRec_acc());
          System.out.println("Transaction Date"+t.getTransactionDate());
          System.out.println("Transaction Type:"+t.getTransactionType());
          System.out.println("Amount:"+t.getAmount());
          System.out.println("Balance:"+t.getBalance());
          System.out.println("===================================");
		}
		
		
	}
}
