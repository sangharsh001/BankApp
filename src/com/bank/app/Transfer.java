package com.bank.app;

import java.util.Scanner;

import com.bank.dto.Customer;
import com.bank.dto.Transaction;
//import com.bank.dto.TransactionDAO;
import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDaoImpl;
import com.bank.dao.TransactionDaoImpl;
import com.bank.dao.TransactionDAO;

public class Transfer {
	
	public static void transferAmt(Customer c)
	{ 
		Scanner sc=new Scanner(System.in);
		
		Customer reciever=new Customer();
		Transaction tranRec=new Transaction();
//		Transaction tranRec=new Transaction();
		Transaction tranSend=new Transaction();
		
		CustomerDAO cdao=new CustomerDaoImpl();
		TransactionDAO tdao=new TransactionDaoImpl();
        System.out.println("Enter the Account number to transfer");
        long accno=sc.nextLong();
        reciever= cdao.getCustomer(accno);
        System.out.println(reciever);
 
        if(reciever!=null)
        {
        	System.out.println("Enter the Amount");
            Double amount=sc.nextDouble();
            System.out.println("Enter your pin");
            int pin=sc.nextInt();
            if(c.getAcNo()!=reciever.getAcNo() && c.getBalance()>amount && amount>0)
            {
//            	&& c.getBalance()>amount && amount>0
            	if(pin==c.getPin())
            	{
            		
            		
            	
            	c.setBalance(c.getBalance()-amount);
            	
            	boolean upt1=cdao.updateCustomer(c);
            	reciever.setBalance(reciever.getBalance()+amount);
            	boolean upt2=cdao.updateCustomer(reciever);
            	System.out.println(c);
            	if(upt1 && upt2)
            	{
                tranRec.setTransactionID(Transactiono.genTransaction());
                tranRec.setUser(reciever.getAcNo());
                tranRec.setRec_acc(c.getAcNo());
                tranRec.setTransactionType("Credited");
                tranRec.setAmount(amount);
                tranRec.setBalance(reciever.getBalance());
                boolean rectdet=tdao.insertTransaction(tranRec);
                
                
                
                
                tranSend.setTransactionID(tranRec.getTransactionID());
                tranSend.setUser(c.getAcNo());
                tranSend.setRec_acc(reciever.getAcNo());
                tranSend.setTransactionType("Debit");
                tranSend.setAmount(amount);
                tranSend.setBalance(c.getBalance());
                boolean sendtdet=tdao.insertTransaction(tranSend);

            		
            		if(rectdet && sendtdet)
            		{
                 System.out.println("Money Creadited Succesfully");
            		}
            	 
            	}
            
            	else {
            		System.out.println("Money Creadited UnSuccesfully ");
            	}
//            	System.out.println(c);
//            	System.out.println(reciever);
            }
            else
            {
            	System.out.println("invalid pin");
            }
            	
            }
            else
            {
            	System.out.println("Infuccient balance");
            }
            
        	
        	
      
       
        	
        	
        }
        else
        {
        	System.out.println("Account number is invalid");
        }
        
	}

}
