package com.banksystem.dao;

import com.banksystem.model.Account;

public interface BankDoc {
	//insert
    void createAccount(Account a);
    
    //update
    void depositeMoneyById(int acno,Account a);
    
    //update
    void withdrawMoneyById(int acno,Account a);
    
    //delete
    void deleteAccountbyId(int accno);
    
    //select
    void checkBalance(int acno);
    
    //select
    boolean viewAccountDetailsById(int acno);
    
    //procedure by callable statement
    void transferAmountByProcedure(int acno1,int acno2,double amt);
}
