package com.digit.mcv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.model.BankApp;

@WebServlet("/Loan")
public class LoanController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BankApp b = new BankApp();
		
		HttpSession session =req.getSession();
		
		b.setChoice(Integer.parseInt(req.getParameter("choice")));
		
		boolean result1 = b.loan();
		
		if(result1==true) {
			
			session.setAttribute("lid",b.getLid());

			session.setAttribute("l_type",b.getL_type());

			session.setAttribute("tenure", b.getTenure());

			session.setAttribute("interest", b.getInterest());

			session.setAttribute("description", b.getDescription());
			
			session.setAttribute("l_type",b.getL_type());


			resp.sendRedirect("/MVCBankApp/LoanDetails.jsp");

		}
		else {
			resp.sendRedirect("/MVCBankApp/LoanDetailsFail.html");
		}
	}

}
