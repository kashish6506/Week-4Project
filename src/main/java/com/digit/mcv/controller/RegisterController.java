package com.digit.mcv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.model.BankApp;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BankApp bankApp = new BankApp();
		bankApp.setBank_id(Integer.parseInt(req.getParameter("bank_id")));

        bankApp.setBank_name(req.getParameter("bank_name"));

        bankApp.setIfsc_Code(req.getParameter("ifsc_code"));

        bankApp.setAccno(Integer.parseInt(req.getParameter("accno")));

        bankApp.setPin(Integer.parseInt(req.getParameter("pin")));

        bankApp.setCust_id(Integer.parseInt(req.getParameter("cust_id")));

        bankApp.setCustomer_name(req.getParameter("customer_name"));

        bankApp.setBalance(Integer.parseInt(req.getParameter("balance")));

        bankApp.setEmail(req.getParameter("email"));

        bankApp.setPhone(Long.parseLong(req.getParameter("phone")));
        
        boolean b = bankApp.register();
        
        if(b==true) {
        	resp.sendRedirect("/MVCBankApp/RegisterSucess.html");
        }
        else {
        	resp.sendRedirect("/MVCBankApp/RegisterFail.html");
        }
        
		
		
	}

}
