package com.Training.ServetProject.BanApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Catch;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet{
	private Connection con;
	

	private ResultSet res1;
	private ResultSet res2;
	private ResultSet res3;
	private PreparedStatement prep;
	private ResultSet resultset2;
	private ResultSet r2;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session =req.getSession();
		
		
		int cust_id = Integer.parseInt(req.getParameter("cust_id"));
	    String bank_name = req.getParameter("bank_name");
	    int sender_accno = Integer.parseInt(req.getParameter("sender_accno"));
	    String sender_ifsc = req.getParameter("sender_ifsc");
	    int receiver_accno = Integer.parseInt(req.getParameter("receiver_accno"));
	    String receiver_ifsc = req.getParameter("receiver_ifsc");
	    int amount = Integer.parseInt(req.getParameter("amount"));
	    int pin = Integer.parseInt(req.getParameter("pin"));

	    HttpSession session = req.getSession();
	    session.setAttribute("error", "Transaction Failed");
	    session.setAttribute("amount", amount);

	    Random r = new Random();
	    String transaction_id = (100000 + r.nextInt(900000))+"";
	    session.setAttribute("tid", transaction_id);


	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/project1";
	        String user = "root";
	        String pass = "root";

	        con = DriverManager.getConnection(url,user,pass);


	        prep = con.prepareStatement("Select * from bankapp where cust_id=? and ifsc_code=? and accno=? and pin=?");
	        prep.setInt(1, cust_id);
	        prep.setString(2, sender_ifsc);
	        prep.setInt(3, sender_accno);
	        prep.setInt(4, pin);


	        ResultSet r1 = prep.executeQuery();

	        // validating sender id , ifsc , accno , pin
	        if(r1.next()) {
	            prep = con.prepareStatement("select * from bankapp where ifsc_code=? and accno=?");
	            prep.setString(1,receiver_ifsc);
	            prep.setInt(2, receiver_accno);

	            resultset2 = prep.executeQuery();

	            // validating the receiver acc
	            if(resultset2.next()) {

	                prep = con.prepareStatement("select balance from bankapp where pin=?");
	                prep.setInt(1, pin);
	                r2 = prep.executeQuery();

	                if(r2.next()) {
	                    //validating the balance of sender
	                    if(r2.getInt("balance")>=amount) {
	                        // debit from sender
	                        prep = con.prepareStatement("update bankapp set balance =balance-? where pin=?");
	                        prep.setInt(1, amount);
	                        prep.setInt(2, pin);
	                        int x = prep.executeUpdate();

	                        if(x>0) {
	                            //crediting to reciver account
	                            prep = con.prepareStatement("update bankapp set balance =balance+? where accno=?");
	                            prep.setInt(1, amount);
	                            prep.setInt(2, receiver_accno);
	                            int x2 = prep.executeUpdate();

	                            if(x2>0) {
	                                //storing the details inside the DB
	               

	                            	prep=con.prepareStatement("Insert into transferstatus(cust_id, bank_name,sender_ifsc, sender_accno,receiver_ifsc, receiver_accno, amount)  values(?,?,?,?,?,?,?)");
	                            	
	                                prep.setInt(1,cust_id);
	                                prep.setString(2,bank_name);
	                                prep.setString(3,sender_ifsc);
	                                prep.setInt(4, sender_accno);
	                                prep.setString(5,receiver_ifsc);
	                                prep.setInt(6, receiver_accno);
	                                prep.setInt(7,amount);
	                               
	                                


	                                int x3 = prep.executeUpdate();
	                                
	                                if(x3>0) {
	                                    resp.sendRedirect("/BankingApplication/TransferSuccess.jsp");
	                                }
	                                else {
	                                    resp.sendRedirect("/BankingApplication/TransferFail.jsp");

	                                }
	                            }else {
	                                resp.sendRedirect("/BankingApplication/TransferFail.jsp");
	                            }

	                        }else {
	                            resp.sendRedirect("/BankingApplication/TransferFail.jsp");
	                        }
	                    }else {
	                        resp.sendRedirect("/BankingApplication/TransferFail.jsp");
	                    }
	                }else {
	                    resp.sendRedirect("/BankingApplication/TransferFail.jsp");
	                }
	            }
	        }
	        else {
	            resp.sendRedirect("/BankingApp/TransferFail.jsp");
	        }




	    }catch(Exception e) {
	        e.printStackTrace();
	    }
	    
	}


}

