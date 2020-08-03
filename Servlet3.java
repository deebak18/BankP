package demoapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

public class Servlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		Connection con = null;
		PreparedStatement pst = null;
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con= (Connection) DriverManager.getConnection("jdbc:mysql:localhost/bar","root","1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServletContext context = getServletContext();
		Object obj = context.getAttribute("accno");
		String accno = obj.toString();
		
		String amount = req.getParameter("amount");
		
		
		try {
			pst = ((java.sql.Connection) con).prepareStatement("insert into account_holder(accnum,mdeposit) value(?,?,?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, accno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(2,amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rows;
		try {
			rows = pst.executeUpdate();
			if(rows==1)
			{
			out.println("your transaction have been done");
			}
			else
			{
				out.println("your transaction failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 
		
		
		
		
		
		
		
		
		
		
	}	
	}