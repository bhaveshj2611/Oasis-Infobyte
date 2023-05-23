package com.bhavesh.projects;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm_bj {
    public static int bal = 50000;
    public static ArrayList<Integer> transactionHistory = new ArrayList<>();
    public static ArrayList<Integer> transferUserId = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("***************************");
        System.out.println();
        System.out.println("WELCOME TO XYZ ATM");
        System.out.println();
        System.out.println("***************************");

        start();
    }

    public static void start() {
        Scanner inp3 = new Scanner(System.in);

        System.out.println("What would you like to perform: ");
        System.out.println();
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Enter your choice (1/2): ");
        int choice = inp3.nextInt();

        if (choice == 1) {
            System.out.println();
            System.out.println("(Use PIN as 1111 for testing purpose)");
            System.out.println();
            System.out.print("Enter your User id: ");
            int uid = inp3.nextInt();

            System.out.print("Enter your Pin: ");
            int pin = inp3.nextInt();

            if (pin != 1111) {
                System.out.println();
                System.out.println("Invalid PIN");
                start();
            }

            if (pin == 1111) {
                System.out.println("Welcome User, Your current available balance is: " + bal);
                menu();
            }
        } else if (choice == 2) {
            System.exit(1);
        } else if (choice > 2) {
            System.out.println("Invalid Choice, Enter correct choice ");
            start();
        }
    }

    public static void menu() {
        Scanner inp2 = new Scanner(System.in);

        System.out.println();

        System.out.println("What functionalities would you like to perform: ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit ");
        System.out.println("3. Transaction History ");
        System.out.println("4. Transfer ");
        System.out.println("5. Quit ");
        System.out.println("Enter number before functions to perform: ");
        int choice = inp2.nextInt();

        switch (choice) {
            case 1 -> Withdraw.out();
            case 2 -> Deposit.in();
            case 3 -> TransactionHistory.displayTransactionHistory();
            case 4 -> Transfer.transaction();
            case 5 -> System.exit(1);
        }
    }

    static class Withdraw {
        static int atw;

        static void out() {
            Scanner inp4 = new Scanner(System.in);
            System.out.print("Enter amount you want to withdraw: ");
            atw = inp4.nextInt();
            if (atw <= Atm_bj.bal) {
                Atm_bj.bal = Atm_bj.bal - atw;
                System.out.println("Amount Withdrawn successfully");
                System.out.println("Available Balance: " + Atm_bj.bal);
                Atm_bj.transactionHistory.add(-atw); 
            } else {
                System.out.println("Entered amount exceeds account balance, Please Try again!");
            }
            Atm_bj.menu();
        }
    }

    static class Deposit {
        static int atd;

        static void in() {
            Scanner inp4 = new Scanner(System.in);
            System.out.print("Enter amount you want to Deposit: ");
            atd = inp4.nextInt();
            Atm_bj.bal = Atm_bj.bal + atd;
            System.out.println("Amount Deposited successfully");
            System.out.println("Available Balance: " + Atm_bj.bal);
            Atm_bj.transactionHistory.add(atd); 
            Atm_bj.menu();
        }
    }

    static class Transfer {
        static int userid;
        static int transfer;

        static void transaction() {
            Scanner inp4 = new Scanner(System.in);
            System.out.print("Enter userid of the account to transfer money: ");
            userid = inp4.nextInt();
            System.out.print("Enter the amount to transfer to user with user id " + userid + ": ");
            transfer = inp4.nextInt();
            Atm_bj.transactionHistory.add(-transfer); 
            Atm_bj.transferUserId.add(userid);
            if (transfer <= Atm_bj.bal) {
                Atm_bj.bal = Atm_bj.bal - transfer;
                System.out.println("Amount transferred successfully");
                System.out.println("Available Balance: " + Atm_bj.bal);
            } else {
                System.out.println("Entered amount exceeds account balance. Please try again!");
            }
            Atm_bj.menu();
        }
    }

    static class TransactionHistory {
        static void displayTransactionHistory() {
            if (Atm_bj.transactionHistory.isEmpty()) {
                System.out.println("No transactions performed.");
            } else {
                System.out.println("Transaction History:");
                for (int i = 0; i < Atm_bj.transactionHistory.size(); i++) {
                    int transaction = Atm_bj.transactionHistory.get(i);
                    if (transaction < 0) {
                        if (i < Atm_bj.transferUserId.size()) {
                            int transferToUserId = Atm_bj.transferUserId.get(i);
                            System.out.println("Transfer to User ID " + transferToUserId + ": " + transaction);
                        } else {
                            System.out.println("Withdrawal: " + transaction);
                        }
                    } else {
                        System.out.println("Deposit: " + transaction);
                    }
                }
            }
            Atm_bj.menu();
        }
    }
}
