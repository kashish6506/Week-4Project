package com.digit.mcv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.model.BankApp;

@WebServlet("/ChangePassword")
public class ChangePasswordController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BankApp bankApp = new BankApp();
		
		HttpSession session = req.getSession();

		bankApp.setAccno((int) session.getAttribute("accno"));
		
		bankApp.setPin(Integer.parseInt(req.getParameter("pin")));
		bankApp.setnPwd(Integer.parseInt(req.getParameter("nPwd")));
		bankApp.setcPwd(Integer.parseInt(req.getParameter("cPwd")));
		
		boolean b = bankApp.changePassword();
		
		 if(b==true) {
	        	resp.sendRedirect("/MVCBankApp/RegisterSucess.html");
	        }
	     else {
	        	resp.sendRedirect("/MVCBankApp/RegisterFail.html");
	        }



		
		
	}

}
