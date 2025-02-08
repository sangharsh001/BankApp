package com.bank.dto;

public class Customer {

	private long accno;
	private String Name;
	private long phone;
	private String mail;
	private double balance;
	private int pin;
	public long getAcNo() {
		return accno;
	}
	public void setAcNo(long acNo) {
		this.accno = acNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Customer [accno=" + accno + ", Name=" + Name + ", phone=" + phone + ", mail=" + mail + ", balance="
				+ balance + ", pin=" + pin + "]";
	}
	
	
}
