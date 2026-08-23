package com.banksystem.client;

import com.banksystem.dao.BankOperations;
import com.banksystem.model.Account;

public class Driver {

	public static void main(String[] args) {
		System.out.println("main method started");
		BankOperations bo=new BankOperations();
		System.out.println("*********creating the new user Account**********");
//		Account a1=new Account();
//		a1.setAccno(90104);
//		a1.setAccname("Rakesh");
//		a1.setPhone("6405567876");
//		a1.setBalance(1500.0);
//		bo.createAccount(a1);
		System.out.println("********depositing the money for particular account no************");
		//Account a2=new Account();
		//a2.setBalance(1000.0);
		//bo.depositeMoneyById(90101,a2);
		System.out.println("**********withdrawing the money for particular account no***********");
		//Account a3=new Account();
		//a3.setBalance(1000.0);
		//bo.withdrawMoneyById(90101,a3);
		System.out.println("*************Transfering the money from one account to another account********");
		bo.transferAmountByProcedure(90104,90103,500.0);
		System.out.println("***********checking the balance for particular account no************");
		bo.checkBalance(90103);
		System.out.println("******Veiw Account Details**************************");
		if(bo.viewAccountDetailsById(90104)) {
			System.out.println("Account Details Retrieved Successfully");
		}
		else {
			System.out.println("invalid account number");
		}
		System.out.println("main method ended");
	}

}
