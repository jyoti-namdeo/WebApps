import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;

public class BuyServlet extends HttpServlet {
	
	
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
    }
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
			PrintWriter out = response.getWriter();
			HttpSession session= request.getSession();
			String userName = (String)session.getAttribute("userIDDB");
			String userType = (String)session.getAttribute("userTypeDB");
			
			String tempBill = request.getParameter("finalPrice");
			
			out.println("<html>");
			out.println("<head><title>Buy</title></head>");
			out.println("<body style= 'background-color:#F2F2F2'>");
			int isGuest = 0;
			if(userType == null){
				isGuest = 1;
				out.println("<h1>Guest User gets charged $2 Extra.. To avoid it, please create an account..!</h1>");	
			}
			else{
				try{
					if(userType.equals("customer"))
					{
					out.println("<h1>Customer: " +userName+ " Placing an Order </h1>");	
					}
					else if(userType.equals("admin"))
					{
					out.println("<h1>Store Manager: " +userName+ " Placing an Order </h1>");	
					}
							
				}
				
				catch(Exception e){
				}
			}
						
			
			
			out.println("<form method ='get' action='SubmitOrder'>");
			out.println("<fieldset>");
			out.println("<legend>Order information:</legend>");
			out.println("<center>");
			out.println("<table></tr>");
			out.println("</tr></table>");
			
			out.println("<table>");
			out.println("<tr><td>Total: </td>");
			if(isGuest == 1){
				int bill = Integer.parseInt(tempBill);
				bill+=2;
				tempBill = String.valueOf(bill);
			}
			
			out.println("<td> <input type='text' readonly name='price' value="+tempBill+"> </td></tr>");
			out.println("<tr><td> First name: </td>");
			out.println("<td> <input type='text' name='firstName'> </td></tr>");
			out.println("<tr><td> Last name: </td>");
			out.println("<td> <input type='text' name='lastName'> </td></tr>");
			out.println("<tr><td> Address: </td>");
			out.println("<td> <input type='text' name='address'> </td></tr>");
			out.println("<tr><td> Phone: </td>");
			out.println("<td> <input type='text' name='phoneNumber'> </td></tr>");
			out.println("<tr><td> Credit Card: </td>");
			out.println("<td> <input type='password' name='creditCard'> </td></tr>");
			out.println("</table><br><br><input type='submit' value='Place Order'></center></fieldset>");
			out.println("</form></body></html>");
			
	}
	
	
	protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Buy Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + message + "</h2>");
		out.println("<a href='index.html'>Index</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }
	
	
	public void destroy()	{
      // do nothing.
	}
	
}