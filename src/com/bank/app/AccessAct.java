package com.bank.app;

import java.util.ArrayList;
import java.util.ListIterator;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDaoImpl;
import com.bank.dto.Customer;

public class AccessAct {
public static void accountdetail(Customer c)
{
	
	
	
	
	
//	CustomerDAO cdao=new CustomerDaoImpl();
//   Customer data= cdao.getCustomer(c.getAcNo());

	
		System.out.println("========================");
		System.out.println("Account Details");
		System.out.println("Account numer:"+c.getAcNo());
		System.out.println("Name:"+c.getName());
		System.out.println("Phone:"+c.getPhone());
		System.out.println("Phone:"+c.getMail());
		System.out.println("Phone:"+c.getBalance());
		System.out.println("Pin:"+c.getPin());
		System.out.println("============================");
	
	
	
	
	
	
	
	
}
}
