package com.bank.app;
import java.util.ArrayList;
import java.util.ListIterator;

import com.bank.dao.*;
import com.bank.dto.Customer;
public class AllCustData {
	public static void getDetails()
	{
		
		CustomerDAO cdao=new CustomerDaoImpl();
		ArrayList <Customer> data= cdao.getCustomer();
		
		ListIterator<Customer> list=data.listIterator();
		while(list.hasNext())
		{
			System.out.println("===========================");
			Customer c=list.next();
			System.out.println("Account numer:"+c.getAcNo());
			System.out.println("Name:"+c.getName());
			System.out.println("Phone:"+c.getPhone());
			System.out.println("Mail:"+c.getMail());
			System.out.println("Balance:"+c.getBalance());
			System.out.println("Pin:"+c.getPin());
			System.out.println("============================");
		}
	}
}
