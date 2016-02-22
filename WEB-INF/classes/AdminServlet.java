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

public class AdminServlet extends HttpServlet {
	
	
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
			
			//to add Item
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<script type='text/javascript' src='javascript.js'></script>");
			out.println("<html>");
			
				out.println(docType+"<head>");
	out.println("<title>PizzaParty.co</title>");
    out.println("<table id ='headbg' cell spacing = '2' border = '2' style='width:100%'>");
    out.println(" <tr BGCOLOR='#FFAD00'>");
    out.println(" <td colspan ='50'>");
    out.println(" <h1><center>PizzaPartyCo</center></h1>");
    out.println("    <div align = 'Right' >");

    out.println("        </div>");
    out.println("        </td>");
    out.println("        </tr>");
    out.println("    <tr >");

    out.println("    <td  class='head' colspan='5'><center><a href='WeeklyDeals.jsp' class ='anchorhead'>Weekly Deals</a></center></td>");

    out.println("  <td class='head' colspan='5'><center><a href='contact.jsp' class ='anchorhead'>Contact Us</a></center></td>");
    out.println("      </tr>");
	out.println("	</table></center>");
    out.println("    <link rel='stylesheet' href='mystyles.css' type='text/css' />");
	out.println("	</head>");
	
			//Ajax
				out.println("<div align = 'left'>");
			  out.println(               
				"<BODY onload='init()' ><TABLE BORDER='0' WIDTH='100%'>"+
				"<TR><TD BGCOLOR='#FFAD00' ALIGN='CENTER' COLSPAN='2'><center><form name='autofillform' action='autocomplete'><table border='0' cellpadding='5'><tbody><tr><td><strong>Search Product:</strong></td><td><input type='text' size='40'  id='complete-field'   onkeyup='doCompletion()'></td></tr><tr><td style='position:absolute' id='auto-row' colspan='2'><table style='background-color:#FFAD00' id='complete-table' class='popupBox' /></td></tr></tbody></table></form></center></TD></TR>"+"</TD>");
			out.println("<TD>" +"</TD></TR></TABLE><HR></div>");
			//-Ajax
			out.println("<body style= 'background-color:#F2F2F2'>");
			out.println("<form method ='get' action='/PizzaParty/AdminConfirmServlet'>");
			out.println("<fieldset>");
			out.println("<legend>Add New Item information:</legend>");
			out.println("<table BORDER=1 ALIGN=CENTER>");
			out.println("<tr BGCOLOR='#FFAD00'>");
			out.println("<th>Item TYPE<th>Item ID<th> Item NAME<th> Item DESCRIPTION<th> Item PRICE <th> Item IMAGE</tr>");
			out.println("<tr><td> <select name='addProductType'><option value='Pizza'>Pizza</option>");
			out.println("<option value='Bread'>Bread</option>");			 
			out.println("<option value='Deserts'>Deserts</option>");	
			out.println("<option value='Drinks'>Drinks</option></select> </td>");
			out.println("<td> <input type='text' name='addProductID'> </td>");
			out.println("<td> <input type='text' name='addProductName'> </td>");
			out.println("<td> <input type='text' name='addProductDesc'> </td>");
			out.println("<td> <input type='text' name='addProductPrice'> </td><td> <input type='text' name='imageUrl'> </td></tr>");
			out.println("</table><br><center><input type='submit' name = 'action' value='ADD'><center><br></fieldset>");
			
			//to delete Item
			out.println("<fieldset>");
			out.println("<legend>Delete Item</legend>");
			out.println("<table BORDER=1 ALIGN=CENTER>");
			out.println("<tr BGCOLOR='#FFAD00'>");
			out.println("<th>Item TYPE:<th>Item ID:</tr>");
			out.println("<tr><td> <select name='delProductType'><option value='Pizza'>Pizza</option>");
			out.println("<option value='Bread'>Bread</option>");			 
			out.println("<option value='Deserts'>Deserts</option>");			
			out.println("<option value='Drinks'>Drinks</option></select> </td>");
			out.println("<td> <input type='text' name='delProductID'> </td></tr>");
			out.println("</table ><br><center><input type='submit' name = 'action' value='DELETE'><center><br></fieldset>");
			
			//to update Item
			out.println("<fieldset>");
			out.println("<legend>Update Item</legend>");
			out.println("<table BORDER=1 ALIGN=CENTER>");
			out.println("<tr BGCOLOR='#FFAD00'>");
			out.println("<th>Item TYPE:<th>Item ID:<TH>Item NAME:<TH>Item DESC:<th>Item PRICE</tr>");
			out.println("<tr><td> <select name='updateProductType'><option value='Pizza'>Pizza</option>");
			out.println("<option value='Bread'>Bread</option>");			 
			out.println("<option value='Deserts'>Deserts</option>");			 
			out.println("<option value='Drinks'>Drinks</option></select> </td>");
			out.println("<td><input type='text' name='updateProductID'> </td>");
			out.println("<td><input type='text' name='updateName'> </td>");
			out.println("<td><input type='text' name='updateDesc'> </td>");
			out.println("<td><input type='text' name='updatePrice'> </td></tr>");
			out.println("</table ><br><center><input type='submit' name = 'action' value='UPDATE'><center><br></fieldset>");
			out.println("</form>");
			out.println("<h2>Logout</h2><a href='/PizzaParty/LogoutServlet'>Logout</a>");
			out.println("</body></html>");
			
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