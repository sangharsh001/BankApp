package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.connection.Connector;
import com.bank.dto.Transaction;

public class TransactionDaoImpl implements TransactionDAO {
  
	Connection con;
	public TransactionDaoImpl(){
		this.con=Connector.requestConnection();
	}
	
	@Override
	public boolean insertTransaction(Transaction t) {
		// TODO Auto-generated method stub
		String query="INSERT INTO passbook(TRAN_ID,USER_ACC,REC_ACC,TRAN_DATE,TRAN_TYPE,AMOUNT,BALANCE) VALUES(?,?,?,SYSDATE(),?,?,?)";
		int i=0;
		try {
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, t.getTransactionID());
			ps.setLong(2,t.getUser());
			ps.setLong(3,t.getRec_acc());
//			ps.setString(4, t.getTransactionDate());
			ps.setString(4,t.getTransactionType());
			ps.setDouble(5,t.getAmount());
			ps.setDouble(6, t.getBalance());
			i=ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0)
		{
			try {
				con.setAutoCommit(true);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return true;
		}
		else
		{
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
	public ArrayList<Transaction> getTransaction(long user) {
		// TODO Auto-generated method stub
	     Transaction t1=null;
		String query="SELECT * FROM PASSBOOK WHERE USER_ACC=? ORDER BY TRAN_DATE DESC" ;
		ArrayList<Transaction> list=new ArrayList<Transaction>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1,user);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			t1=new Transaction();
		   t1.setTransactionID(rs.getLong("TRAN_ID"));
		   t1.setUser(rs.getLong("USER_ACC"));
		   t1.setRec_acc(rs.getLong("REC_ACC"));
	      t1.setTransactionDate(rs.getString("TRAN_DATE"));
	      t1.setTransactionType(rs.getString("TRAN_TYPE"));
	      t1.setAmount(rs.getDouble("AMOUNT"));
	      t1.setBalance(rs.getDouble("BALANCE"));
	      list.add(t1);
	    
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public ArrayList<Transaction> getTransaction() {
		// TODO Auto-generated method stub
		Transaction t1=null;
		String query="SELECT * FROM PASSBOOK ORDER BY TRAN_DATE DESC" ;
		ArrayList<Transaction> list=new ArrayList<Transaction>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			t1=new Transaction();
		   t1.setTransactionID(rs.getLong("TRAN_ID"));
		   t1.setUser(rs.getLong("USER_ACC"));
		   t1.setRec_acc(rs.getLong("REC_ACC"));
	      t1.setTransactionDate(rs.getString("TRAN_DATE"));
	      t1.setTransactionType(rs.getString("TRAN_TYPE"));
	      t1.setAmount(rs.getDouble("AMOUNT"));
	      t1.setBalance(rs.getDouble("BALANCE"));
	      list.add(t1);
	    
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
