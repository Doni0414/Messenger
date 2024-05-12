package com.company.listings;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account(){
        this.dateCreated = new Date();
    }
    public Account(int id, double balance){
        this();
        this.id = id;
        this.balance = balance;
    }
    public double getMonthlyInterestRate(){
        return annualInterestRate / 1200;
    }
    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }
    public void withdraw(double amount){
        if (amount <= balance)
            this.balance -= amount;
    }
    public void deposit(double amount){
        this.balance += amount;
    }
    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
}
