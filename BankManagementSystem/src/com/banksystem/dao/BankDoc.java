package com.banksystem.dao;

import com.banksystem.model.Account;

public interface BankDoc {
	//insert
    void createAccount(Account a);
    
    //update
    void depositeMoneyById(int acno,Account a);
    
    //update
    void withdrawMoneyById(int acno,Account a);
    
    //select
    void checkBalance(int acno);
    
    //select
    boolean viewAccountDetailsById(int acno);
    
    //procedure
    void transferAmountByProcedure(int acno1,int acno2,double amt);
}
