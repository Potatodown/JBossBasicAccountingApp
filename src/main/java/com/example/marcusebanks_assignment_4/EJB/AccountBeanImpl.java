package com.example.marcusebanks_assignment_4.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateful;

@Stateful
public class AccountBeanImpl implements AccountBean {

    double balance = 100.0;
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -=amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
