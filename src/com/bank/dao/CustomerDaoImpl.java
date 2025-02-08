package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.dto.Customer;
import com.bank.connection.Connector;

public class CustomerDaoImpl implements CustomerDAO {

	Connection con;
	
	
	public CustomerDaoImpl()
	{
		this.con=Connector.requestConnection();
		
	}
	@Override
	public boolean insertCustomer(Customer c) {
		String query="INSERT INTO CUSTOMER(NAME,PHONE,MAIL,PIN)VALUES(?,?,?,?)";
		int i=0;
		try {
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMail());
//			ps.setDouble(4, c.getBalance());
			ps.setInt(4, c.getPin());
			
		     i=ps.executeUpdate();
			
			
//			while(rs.next())
//			{
//				c.setName(rs.getString("name"));
//				c.setPhone(rs.getLong("phone"));
//				c.setMail(rs.getString("mail"));
//				c.setBalance(rs.getDouble("balance"));
//				c.setPin(rs.getInt("id"));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		if(i>0)
		{
			
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public Customer getCustomer(long accno, int pin) {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		String query="SELECT * FROM CUSTOMER WHERE ACC_NO=? AND PIN=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1,accno);
			ps.setInt(2, pin);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
				{
				    c.setAcNo(rs.getLong("acc_no"));
					c.setName(rs.getString("name"));
					c.setPhone(rs.getLong("phone"));
					c.setMail(rs.getString("mail"));
					c.setBalance(rs.getDouble("balance"));
					c.setPin(rs.getInt("pin"));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return c;
	}

	@Override
	public Customer getCustomer(long phone, String mail) {
		// TODO Auto-generated method stub
		
		
		String quer̥y="SELECT * FRO CUSTOMER WHERE PHONE=? AND MAIL=?";
		Customer c=null;
		try {
			PreparedStatement ps=con.prepareStatement(quer̥y);
			ps.setLong(1,phone);
			ps.setString(2, mail);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				c=new Customer();
			    c.setAcNo(rs.getLong("acc_no"));
				c.setName(rs.getString("name"));
				c.setPhone(rs.getLong("phone"));
							c.setMail(rs.getString("mail"));
							c.setBalance(rs.getDouble("balance"));
							c.setPin(rs.getInt("pin"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	
	

	@Override
	public ArrayList<Customer> getCustomer() {
		
		String query="SELECT * FROM CUSTOMER";
		Customer c=null;
		
		ArrayList<Customer>arr=new ArrayList<Customer>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
		    ResultSet rs=ps.executeQuery();
		    
		    while(rs.next())
		    {
				c=new Customer();
			    c.setAcNo(rs.getLong("acc_no"));
				c.setName(rs.getString("name"));
				c.setPhone(rs.getLong("phone"));
				c.setMail(rs.getString("mail"));
				c.setBalance(rs.getDouble("balance"));
				c.setPin(rs.getInt("pin"));
				arr.add(c);
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return arr;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		
		String query="UPDATE CUSTOMER SET NAME=?, PHONE=?,MAIL=?,BALANCE=?,PIN=? WHERE ACC_NO=?";
		PreparedStatement ps;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setNString(1,c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3,c.getMail());
			ps.setDouble(4, c.getBalance());
			ps.setInt(5, c.getPin());
			ps.setLong(6, c.getAcNo());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		
	 String query="DELETE FROM CUSTOMER WHERE ACC_NO=?";
	 int i=0;
	 try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setLong(1, c.getAcNo());
		i=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
	if(i>0)
	{
		return true;
	}
	else
	{
		return false;
	}
	}
	@Override
	public Customer getCustomer(long accno) {
		Customer c=null;
		
		String query="SELECT * FROM CUSTOMER WHERE ACC_NO=?";
		try {
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, accno);
			
			ResultSet rs=ps.executeQuery();			
			
			while(rs.next())
			{ 
				c=new Customer();
			    c.setAcNo(rs.getLong("acc_no"));
				c.setName(rs.getString("name"));
				c.setPhone(rs.getLong("phone"));
				c.setMail(rs.getString("mail"));
				c.setBalance(rs.getDouble("balance"));
				c.setPin(rs.getInt("pin"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return c;
	}
	@Override
	public boolean depositeCustomer(Customer c) {
//		con.getAutoCommit();
		String query = "UPDATE CUSTOMER SET BALANCE = ? WHERE ACC_NO = ?";
		int i=0;
		try {
			con.setAutoCommit(false);
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setDouble(1,c.getBalance());
			ps.setLong(2, c.getAcNo());
		    i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		if(i>0)
		{
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
		}
		else {
			
			
			return  false;
		}
	}

}
