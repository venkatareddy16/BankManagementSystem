package com.banksystem.client;

import java.util.Scanner;

import com.banksystem.dao.BankDoc;
import com.banksystem.dao.BankOperations;
import com.banksystem.model.Account;
import com.banksystem.utility.DBConnection;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankDoc bo = new BankOperations();

        String y;
        int choice;

        do {

            System.out.println("\n*************** BANK MENU ***************");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. View Account Details");
            System.out.println("7. Delete Account");
            System.out.println("*****************************************");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.println("******** Creating New User Account ********");

                Account a1 = new Account();

                System.out.print("Enter Account Number: ");
                a1.setAccno(sc.nextInt());

                System.out.print("Enter Account Name: ");
                a1.setAccname(sc.next());

                System.out.print("Enter Phone Number: ");
                a1.setPhone(sc.next());

                System.out.print("Enter Initial Balance: ");
                a1.setBalance(sc.nextDouble());

                bo.createAccount(a1);

                break;


            case 2:

                System.out.println("******** Depositing Money ********");

                System.out.print("Enter Account Number: ");
                int depositAcno = sc.nextInt();

                System.out.print("Enter Deposit Amount: ");
                double depositAmount = sc.nextDouble();

                Account a2 = new Account();
                a2.setBalance(depositAmount);

                bo.depositeMoneyById(depositAcno, a2);

                break;


            case 3:

                System.out.println("******** Withdrawing Money ********");

                System.out.print("Enter Account Number: ");
                int withdrawAcno = sc.nextInt();

                System.out.print("Enter Withdrawal Amount: ");
                double withdrawAmount = sc.nextDouble();

                Account a3 = new Account();
                a3.setBalance(withdrawAmount);

                bo.withdrawMoneyById(withdrawAcno, a3);

                break;


            case 4:

                System.out.println("******** Transferring Money ********");

                System.out.print("Enter Sender Account Number: ");
                int fromAcno = sc.nextInt();

                System.out.print("Enter Receiver Account Number: ");
                int toAcno = sc.nextInt();

                System.out.print("Enter Transfer Amount: ");
                double transferAmount = sc.nextDouble();

                bo.transferAmountByProcedure(
                    fromAcno,
                    toAcno,
                    transferAmount
                );

                break;


            case 5:

                System.out.println("******** Checking Balance ********");

                System.out.print("Enter Account Number: ");
                int balanceAcno = sc.nextInt();

                bo.checkBalance(balanceAcno);

                break;


            case 6:

                System.out.println("******** View Account Details ********");

                System.out.print("Enter Account Number: ");
                int viewAcno = sc.nextInt();

                if (bo.viewAccountDetailsById(viewAcno)) {
                    System.out.println("Account Details Retrieved Successfully");
                } 
                else {
                    System.out.println("Invalid Account Number");
                }

                break;
           
            case 7:

                System.out.println("********Delete Account ********");

                System.out.print("Enter Account Number: ");
                int Acno = sc.nextInt();

                bo.deleteAccountbyId(Acno);

                break;
                
            default:

                System.out.println("Invalid Choice! Please enter 1-6.");

            }
            
            System.out.println("Do you want to continue to choose the options again!");
            y=sc.next();
        } while (y.equalsIgnoreCase("yes"));
        DBConnection.closeConnection();//closing the db connection when want to exists
        System.out.println("Thank you for using Bank Management System!");
        sc.close();
    }
}