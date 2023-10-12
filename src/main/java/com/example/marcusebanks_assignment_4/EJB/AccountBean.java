package com.example.marcusebanks_assignment_4.EJB;
import jakarta.ejb.Local;

@Local
public interface AccountBean {
    public void deposit(double amount);
    public void withdraw(double amount);
    public double getBalance();
}

