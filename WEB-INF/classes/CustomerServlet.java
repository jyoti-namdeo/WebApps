import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;

public class CustomerServlet extends HttpServlet {
	
	
	//MongoClient mongo;

	public void init() throws ServletException{
  
		//mongo = new MongoClient("localhost", 27017);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
	//session.invalidate();
	session = request.getSession(false);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<script type='text/javascript' src='javascript.js'></script>");
			
				out.println(docType+"<html xmlns='http://www.w3.org/1999/html'>");
				out.println("<head onload='init()'>");
				out.println(" <title>PizzaParty</title>");
				out.println("  <table id ='headbg' cell spacing = '2' border = '2' style='width:100%'>");
				out.println("     <tr>");
				out.println("     <td colspan ='50'>");
				out.println("     <h1><center>PizzaPartyCo</center></h1>");
				//Get username
				if(session != null){
					session= request.getSession();
				String uName = session.getAttribute("userIDDB").toString();
				out.println(" <h2 align='right'>welcome "+uName+"</h2>");	
				}
				
										
				out.println("        <div align = 'Right' >");
				out.println("            <a href='/PizzaParty/ShoppingCartDisplay'><img src='shopping_cart.png'>Cart</a>");
				out.println("            </div>");
				out.println("            </td>");
				out.println("            </tr>");
				out.println("        <tr >");
			//	out.println("        <td class='head' colspan='5'>SEARCH: <input type='text' name ='search' id='input'></td>");
				out.println("        <td  class='head' colspan='5'><center><a href='WeeklyDeals.jsp' target='iframe_a' class ='anchorhead'>Weekly Deals</a></center></td>");
				out.println("            <td class='head' colspan='5'><center><a href='/PizzaParty/MenuServlet' target='iframe_a' class ='anchorhead'>Menu</a></center></td>");
				out.println("      <td class='head' colspan='5'><center><a href='contact.jsp' class ='anchorhead'>Contact Us</a></center></td>");
				out.println("      <td class='head' colspan='5'><center><a href='/PizzaParty/CustomerOrderServlet' class ='anchorhead'>Orders</a></center></td>");
					out.println("      <td class='head' colspan='5'><center><a href='/PizzaParty/LogoutServlet' class ='anchorhead'>Logout</a></center></td>");
				out.println("          </tr>");
				out.println("  </table></center>");
				out.println("        <link rel='stylesheet' href='mystyles.css' type='text/css' />");
				out.println("</head>");
				
				//Ajax
				out.println("<div align = 'left'>");
			  out.println(               
				"<BODY onload='init()' ><TABLE BORDER='0' WIDTH='100%'>"+
				"<TR><TD BGCOLOR='#FFAD00' ALIGN='CENTER' COLSPAN='2'><center><form name='autofillform' action='autocomplete'><table border='0' cellpadding='5'><tbody><tr><td><strong>Search Product:</strong></td><td><input type='text' size='40'  id='complete-field'   onkeyup='doCompletion()'></td></tr><tr><td style='position:absolute' id='auto-row' colspan='2'><table style='background-color:#FFAD00' id='complete-table' class='popupBox' /></td></tr></tbody></table></form></center></TD></TR>"+"</TD>");
			out.println("<TD>" +"</TD></TR></TABLE><HR></div>");
			//-Ajax
				
				out.println("<div>");
				out.println("<div align = 'left'>");
				out.println("  <table style='width:1100px'><h5>");
				out.println("      <tr><td class ='table2'><center><a class ='anchorhead1' href='/PizzaParty/PizzaServlet' target='iframe_a'>Pizza</a></center></td>");
				out.println("           <td rowspan = '5' colspan = '5'>");
				out.println("        <center><iframe id ='frame'  src='frameBackground.html' name='iframe_a'>	</iframe></center></td></tr>");
				out.println("        <tr><td class ='table2'><center><a class ='anchorhead1' href='/PizzaParty/BreadServlet' target='iframe_a'>Breads</a></center></td></tr>");
				out.println("        <tr><td class ='table2'><center><a class ='anchorhead1' href='/PizzaParty/DesertsServlet'  target='iframe_a'>Desserts</a></center></td></tr>");
				out.println("        <tr><td class ='table2'><center><a class ='anchorhead1' href='/PizzaParty/DrinksServlet'  target='iframe_a'>Drinks</a></center></td></tr>");
				out.println("        <tr><td class ='table2'><center><a class ='anchorhead1' href='CustomPizza.jsp'  target='iframe_a'>Custom Pizza</a></center></td></tr>");
				out.println("        </h5></table></div><br>");
				out.println("<hr color ='black'>"); 
				out.println("    </div>");
				out.println("<div>");
				out.println("    <table ALIGN='CENTER'>");
				out.println("<td id ='lower1'></td>");
				out.println("<td id ='lower2' ></td>");
				out.println("<td id ='lower3' ></td>");
				out.println("    </table>");
				out.println("</div>");
				out.println("<hr id = 'lowerhr' color='black'>");
				out.println("<table align='center' style= 'background-color:#F2F2F2'><tr><td class ='table3'><a class = 'footer1' href='contact.jsp'>About Us</a>");
				out.println("</td> <td class ='table3'>");
				out.println("    <a class = 'footer1' href='contact.jsp'>FeedBack</a></td><td class ='table3'><a class = 'footer1' href='contact.jsp'>Help</a>");
				out.println("</td></tr>");
				out.println("</table>");
				out.println("</body></html>");
		
	}
	
	public void destroy()	{
      
	}
	
}