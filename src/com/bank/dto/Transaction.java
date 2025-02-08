package com.bank.dto;

public class Transaction {
	private long transactionID;
	private long user;
	private long rec_acc;
	private String TransactionDate;
	private String TransactionType;
	private double amount;
	private double balance;
	public long getTransactionID()
	{
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public long getRec_acc() {
		return rec_acc;
	}
	public void setRec_acc(long rec_acc) {
		this.rec_acc = rec_acc;
	}
	public String getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", user=" + user + ", rec_acc=" + rec_acc
				+ ", TransactionDate=" + TransactionDate + ", TransactionType=" + TransactionType + ", amount=" + amount
				+ ", balance=" + balance + "]";
	}
	

}
