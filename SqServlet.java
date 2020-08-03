package demoapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		
		ServletContext context = getServletContext();
		Object obj = context.getAttribute("accno");
		
		String value = obj.toString(); 
		out.println("<html>");
		out.println("<body bdcolor=pink>");
		
		out.println("<center>");
		out.println("<h2>WELCOME TO EBANK</h2>");
		
		out.println("<center>");
		
		out.println("<Form method=post action=Servlet3>");
		out.println("<b> click the Deposit Button </b>");
		out.println("<table>");
		
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Account Number :" + value);
		out.println("</td>");
		out.println("</tr>");
		
		
		
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Deposit Amount : </td> <td> <input type=text name=amount value = 0>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<table>");
		
		out.println("<input type=submit value=deposit>");
		out.println("</br>");
		out.println("</Form>");
		out.println("</body>");
		out.println("</html>");






	}
	
	
	
	
	
}
