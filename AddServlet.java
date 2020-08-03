package demoapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PrintWriter out= null;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String result = null;
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
		context.setAttribute("accno", "");
		
		String accno = req.getParameter("accno");
		String pinno = req.getParameter("pinno");
		
		try {
			pst = ((java.sql.Connection) con).prepareStatement("selec * from login where accno=? and pinno=?");
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
			pst.setString(2, pinno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		boolean row = false;
		try {
			row = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(row==true)
		{
			try {
				result = rs.getString(2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			context.setAttribute("accno", result);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		if (rd==null)
		{
			
		}
		rd.forward(req, res);
		con.close();
		
	}
	else
	{
		out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html>");
		out.println("<body bgcolor=pink>");
		out.println("PLEASE CHECK THE ACOOUNT NUMBER AND BALANCE");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	
	
	
	
	
	
	
	
	}	
	
}
