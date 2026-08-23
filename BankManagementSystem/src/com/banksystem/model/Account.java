package com.banksystem.model;

public class Account {
	private int accno;
	private String accname;
	private String phone;
	private double balance;

	public Account() {

	}

	public Account(int accno, String accname, String phone, double balance) {
		super();
		this.accno = accno;
		this.accname = accname;
		this.phone = phone;
		this.balance = balance;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
