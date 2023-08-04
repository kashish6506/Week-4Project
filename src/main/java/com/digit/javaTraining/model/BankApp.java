package com.digit.javaTraining.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import javax.servlet.http.HttpSession;

public class BankApp {
	int bank_id;
	String bank_name;
	int accno;
	String ifsc_code;
	int pin;
	int cust_id;
	String customer_name;
	int balance;
	String email;
	long phone;
	private Connection con;
	private PreparedStatement pstmt;
	private Object resp;
	private ResultSet resultSet;
	int nPwd;
	int cPwd;
	int choice;
	int lid;
	String l_type;
	int tenure;
	float interest;
	String description;
	int amount;
	
	int sender_accno;
	String sender_ifsc;
	int receiver_accno;
	String receiver_ifsc;
	private ResultSet resultset2;
	private ResultSet r2;
	String transaction_id;
	

	public BankApp() {
		String url = "jdbc:mysql://localhost:3306/project1";

		String user = "root";

		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_Code(String ifsc_Code) {
		this.ifsc_code = ifsc_Code;
	}
	
	
public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
public int getnPwd() {
		return nPwd;
	}
	public void setnPwd(int nPwd) {
		this.nPwd = nPwd;
	}
	public int getcPwd() {
		return cPwd;
	}
	public void setcPwd(int cPwd) {
		this.cPwd = cPwd;
	}
	
	
public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getL_type() {
		return l_type;
	}
	public void setL_type(String l_type) {
		this.l_type = l_type;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
public int getSender_accno() {
		return sender_accno;
	}
	public void setSender_accno(int sender_accno) {
		this.sender_accno = sender_accno;
	}
	public String getSender_ifsc() {
		return sender_ifsc;
	}
	public void setSender_ifsc(String sender_ifsc) {
		this.sender_ifsc = sender_ifsc;
	}
	public int getReceiver_accno() {
		return receiver_accno;
	}
	public void setReceiver_accno(int receiver_accno) {
		this.receiver_accno = receiver_accno;
	}
	public String getReceiver_ifsc() {
		return receiver_ifsc;
	}
	public void setReceiver_ifsc(String receiver_ifsc) {
		this.receiver_ifsc = receiver_ifsc;
	}
	
	
public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
public boolean register() {
	try {

     
        pstmt = con.prepareStatement("insert into bankapp values(?,?,?,?,?,?,?,?,?,?)");

        pstmt.setInt(1, bank_id);

        pstmt.setString(2, bank_name);

        pstmt.setString(3, ifsc_code);

        pstmt.setInt(4, accno);

        pstmt.setInt(5, pin);

        pstmt.setInt(6, cust_id);

        pstmt.setString(7, customer_name);

        pstmt.setInt(8, balance);

        pstmt.setString(9, email);

        pstmt.setLong(10, phone);

        

        int x = pstmt.executeUpdate();

        if(x>0) {

//            
        	return true;

        }

        else {

//            
        	return false;

        }

        

    }

    catch (Exception e) {

        e.printStackTrace();

    }
	return false;
	
}

public boolean login() {
	try {

        
        pstmt = con.prepareStatement("Select * from bankapp where cust_id=? and pin=?");
        pstmt.setInt(1, cust_id);
        pstmt.setInt(2, pin);
        
        resultSet =pstmt.executeQuery();
        
        if(resultSet.next()==true) {
        	
        	return true;
        }
        else {
        	return false;
        }
    }
    catch (Exception e) {
		e.printStackTrace();
	}
	return false;
}

public boolean changePassword() {
	
	if(nPwd == cPwd) {
		
		try {

			
			pstmt=con.prepareStatement("update bankapp set pin=? where accno=? and pin=?");
			pstmt.setInt(1, nPwd);
			pstmt.setInt(2, accno);
			pstmt.setInt(3, pin);

			int x = pstmt.executeUpdate();

			if(x>0) {
				return true;

			}

			else {

				return false;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}}
	else {
		return false;
	}
	return false;
}

public boolean checkBalance() {
	try {

		pstmt=con.prepareStatement("select Balance from bankapp where accno=?");

		pstmt.setInt(1, accno);

		resultSet=pstmt.executeQuery();

		if(resultSet.next()==true) {

			return true;
		}

		else {

			return false;

		}

	}

	catch(Exception e) {

		e.printStackTrace();

	}
	return false;
}

public boolean loan() {
	
	try {
		pstmt = con.prepareStatement("Select * from loan where lid=?");

		pstmt.setInt(1, choice);
		resultSet=pstmt.executeQuery();

		if(resultSet.next()==true) {
			
			return true;

		}
		else {
			return false;
		}

	}
	catch (Exception e) {
		e.printStackTrace();
	}

	return false;
	
}
public boolean transfer() {
	 try {
	       

	        pstmt = con.prepareStatement("Select * from bankapp where cust_id=? and ifsc_code=? and accno=? and pin=?");
	        pstmt.setInt(1, cust_id);
	        pstmt.setString(2, sender_ifsc);
	        pstmt.setInt(3, sender_accno);
	        pstmt.setInt(4, pin);


	        ResultSet r1 = pstmt.executeQuery();

	        // validating sender id , ifsc , accno , pin
	        if(r1.next()) {
	        	pstmt = con.prepareStatement("select * from bankapp where ifsc_code=? and accno=?");
	        	pstmt.setString(1,receiver_ifsc);
	        	pstmt.setInt(2, receiver_accno);

	            resultset2 = pstmt.executeQuery();

	            // validating the receiver acc
	            if(resultset2.next()) {

	            	pstmt = con.prepareStatement("select balance from bankapp where pin=?");
	            	pstmt.setInt(1, pin);
	                r2 = pstmt.executeQuery();

	                if(r2.next()) {
	                    //validating the balance of sender
	                    if(r2.getInt("balance")>=amount) {
	                        // debit from sender
	                    	pstmt = con.prepareStatement("update bankapp set balance =balance-? where pin=?");
	                    	pstmt.setInt(1, amount);
	                    	pstmt.setInt(2, pin);
	                        int x = pstmt.executeUpdate();

	                        if(x>0) {
	                            //crediting to reciver account
	                        	pstmt = con.prepareStatement("update bankapp set balance =balance+? where accno=?");
	                        	pstmt.setInt(1, amount);
	                        	pstmt.setInt(2, receiver_accno);
	                            int x2 = pstmt.executeUpdate();

	                            if(x2>0) {
	                                //storing the details inside the DB
	               

	                            	pstmt=con.prepareStatement("Insert into transferstatus(cust_id, bank_name,sender_ifsc, sender_accno,receiver_ifsc, receiver_accno, amount)  values(?,?,?,?,?,?,?)");
	                            	
	                            	pstmt.setInt(1,cust_id);
	                            	pstmt.setString(2,bank_name);
	                            	pstmt.setString(3,sender_ifsc);
	                            	pstmt.setInt(4, sender_accno);
	                            	pstmt.setString(5,receiver_ifsc);
	                            	pstmt.setInt(6, receiver_accno);
	                            	pstmt.setInt(7,amount);


	                                int x3 = pstmt.executeUpdate();
	                                if(x3>0) {
	                                    return true;
	                                }
	                                else {
	                                    return false;

	                                }
	                            }else {
	                            	return false;
	                            }

	                        }else {
	                        	return false;
	                        }
	                    }else {
	                    	return false;
	                    }
	                }else {
	                	return false;
	                }
	            }
	        }
	        else {
	        	return false;
	        }

	    }catch(Exception e) {
	        e.printStackTrace();
	    }
	return false;
}


}
