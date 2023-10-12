package com.example.marcusebanks_assignment_4;
import com.example.marcusebanks_assignment_4.EJB.AccountBean;
import com.example.marcusebanks_assignment_4.EJB.AccountBeanImpl;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet(name = "AccountServlet", value = "/account")
public class AccountServlet extends HttpServlet {
    @EJB(beanName = "AccountBeanImpl")
    AccountBean transaction;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Balance", 0);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DecimalFormat df = new DecimalFormat("0.00");
        try{
            String transactionType = request.getParameter("transaction");
            String amount = request.getParameter("amount");
            if(transactionType.equals("Deposit")){
                transaction.deposit(Double.parseDouble(amount));
            }
            else if (transactionType.equals("Withdraw")){
                transaction.withdraw(Double.parseDouble(amount));
            }
        }catch (Exception e){
            request.setAttribute("Balance", "Error with form");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        request.setAttribute("Balance", df.format(transaction.getBalance()));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
