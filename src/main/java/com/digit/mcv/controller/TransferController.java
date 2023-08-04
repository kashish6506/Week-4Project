package com.digit.mcv.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.model.BankApp;


@WebServlet("/Transfer")
public class TransferController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankApp b = new BankApp();
		
		b.setCust_id(Integer.parseInt(req.getParameter("cust_id")));
	    b.setBank_name(req.getParameter("bank_name"));
	    b.setSender_accno(Integer.parseInt(req.getParameter("sender_accno")));
	    b.setSender_ifsc(req.getParameter("sender_ifsc"));
	    b.setReceiver_accno(Integer.parseInt(req.getParameter("receiver_accno")));
	    b.setReceiver_ifsc(req.getParameter("receiver_ifsc"));
	    b.setAmount(Integer.parseInt(req.getParameter("amount")));
	    b.setPin(Integer.parseInt(req.getParameter("pin")));
	   
	    
	    boolean result1 = b.transfer();

	    HttpSession session = req.getSession();
	    session.setAttribute("error", "Transaction Failed");
	    session.setAttribute("amount", b.getAmount());

	    Random r = new Random();
	    String transaction_id = (100000 + r.nextInt(900000))+"";
	    session.setAttribute("tid", b.getTransaction_id());
		
		
		
		
	}

}
