package com.Training.ServetProject.BanApp;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter.BigDecimalLayoutForm;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Loan")
public class Loan extends HttpServlet {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	private ServletRequest session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session =req.getSession();
		//int acc_no=(int) session.getAttribute("accountno");

		int choice = Integer.parseInt(req.getParameter("choice"));

		String url = "jdbc:mysql://localhost:3306/project1";

		String user = "root";

		String pwd = "root";


		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);


			pstmt = con.prepareStatement("Select * from loan where lid=?");

			pstmt.setInt(1, choice);
			resultSet=pstmt.executeQuery();


			if(resultSet.next()==true) {
				
				session.setAttribute("lid", resultSet.getInt("lid"));

				session.setAttribute("l_type",resultSet.getString("l_type"));

				session.setAttribute("tenure", resultSet.getInt("tenure"));

				session.setAttribute("interest", resultSet.getFloat("interest"));

				session.setAttribute("description", resultSet.getString("description"));
				
				session.setAttribute("l_type",resultSet.getString("l_type"));


				resp.sendRedirect("/BankingApplication/LoanDetails.jsp");

			}
			else {
				resp.sendRedirect("/BankingApplication/LoanDetailsFail.html");
			}



		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
