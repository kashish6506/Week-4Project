package com.Training.ServetProject.BanApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private Connection con;
	private PreparedStatement pstmt;


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		int accno=(int) session.getAttribute("accno");

		int pin=Integer.parseInt(req.getParameter("pin"));
		int nPwd=Integer.parseInt(req.getParameter("nPwd"));
		int cPwd=Integer.parseInt(req.getParameter("cpwd"));

		String url = "jdbc:mysql://localhost:3306/project1";

		String user = "root";

		String pwd = "root";

		if(nPwd==cPwd) {
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection(url, user, pwd);
				pstmt=con.prepareStatement("update bankapp set pin=? where accno=? and pin=?");
				pstmt.setInt(1, nPwd);
				pstmt.setInt(2, accno);
				pstmt.setInt(3, pin);

				int x = pstmt.executeUpdate();

				if(x>0) {

					//    	


					resp.sendRedirect("/BankingApplication/passwordChangeSuccess.html");



				}

				else {

					resp.sendRedirect("/BankingApplication/passwordChangeFail.html");

				}




			}
			catch (Exception e) {
				e.printStackTrace();
			}}
		else {
			resp.sendRedirect("/BankingApplication/passwordChangeFail.html");
		}

	}








}

