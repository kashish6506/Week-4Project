package com.digit.mcv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.model.BankApp;

@WebServlet("/CheckBalance")
public class CheckBalanceController extends HttpServlet{
	private ServletRequest session;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BankApp b = new BankApp(); 
			
			HttpSession session=req.getSession();

			b.setAccno((int)session.getAttribute("accno"));
			
			boolean result1 = b.checkBalance();
			
			if(result1 == true) {

				session.setAttribute("balance",b.getBalance());
				
				resp.sendRedirect("/MVCBankApp/balance.jsp");



			}

			else {

				resp.sendRedirect("/MVCBankApp/balanceFail.jsp");

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
