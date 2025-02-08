package com.bank.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDaoImpl;
import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDaoImpl;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;

public class DeleteUser {

	public static void deleteUser(Customer c)
	{
		
		 CustomerDAO cdao=new CustomerDaoImpl();
		 TransactionDAO tdao=new TransactionDaoImpl();
		 Transaction t=new Transaction();
		 
		 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Account to Delete");
		
	    Long accno=	sc.nextLong();
		Customer c1=cdao.getCustomer(accno);
		if(c1!=null && c1!=c)
		{
		
		Double avlbal=c1.getBalance();
		c.setBalance(c.getBalance()+avlbal);
		
		boolean res2=cdao.updateCustomer(c);
		if(res2)
		{
			boolean res=cdao.deleteCustomer(c1);
			t.setTransactionID(Transactiono.genTransaction());
            t.setUser(c.getAcNo());
            t.setRec_acc(c.getAcNo());
            t.setTransactionType("Credited");
            t.setAmount(avlbal);
            t.setBalance(c.getBalance());
            boolean rectdet=tdao.insertTransaction(t);
            
//			ArrayList<Transaction> t=tdao.getTransaction(c.getAcNo());
//			Iterator<Transaction> al=t.iterator();
//			
//			while(al.hasNext())
//			{
//				Transaction tran=al.next();
//				
//				
//			}
			
		
			
			if(res && res2 && rectdet)
			{
               System.out.println("Deleteed success");
			}
		}
		else
		{
			System.out.println("not deleted");
		}
		
//		System.out.println();
		
		
		}
		else
		{
			System.out.println("Account Number Invalid"); 
		}
	    
	}
	
}
