import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;

public class CustomerOrderServlet extends HttpServlet {
	
	
	
	public void init() throws ServletException{
      	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request, response);
		
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
						
						
						DB db=null;

						HttpSession session = request.getSession();

						String userName= session.getAttribute("userIDDB").toString();
						
						MongoClient mongo = new MongoClient("localhost", 27017);
						db = mongo.getDB("PizzaParty");
						DBCollection myReviews = db.getCollection("myOrders");
						BasicDBObject searchQuery = new BasicDBObject();
						searchQuery.put("userIDDB", userName);
						DBCursor cursor = myReviews.find(searchQuery);
						PrintWriter out = response.getWriter();	
						ArrayList orderList= new ArrayList();
						ArrayList priceList= new ArrayList();
						ArrayList firstNameList= new ArrayList();
						ArrayList lastNameList= new ArrayList();
						ArrayList addressList= new ArrayList();
						ArrayList phoneList= new ArrayList();
						ArrayList deliveryList= new ArrayList();
						ArrayList orderTime = new ArrayList();
						
						out.println("<html><head>");
	out.println("<title>PizzaParty.co</title>");
    out.println("<table id ='headbg' cell spacing = '2' border = '2' style='width:100%'>");
    out.println(" <tr BGCOLOR='#FFAD00'>");
    out.println(" <td colspan ='50'>");
    out.println(" <h1><center>PizzaParty Order Checking</center></h1>");
    out.println("    <div align = 'Right' >");

    out.println("        </div>");
    out.println("        </td>");
    out.println("        </tr>");
    out.println("    <tr >");

    out.println("    <td  class='head' colspan='5'><center><a href='#' class ='anchorhead'>Weekly Deals</a></center></td>");

    out.println("  <td class='head' colspan='5'><center><a href='#' class ='anchorhead'>Contact Us</a></center></td>");
    out.println("      </tr>");
	out.println("	</table></center>");
    out.println("    <link rel='stylesheet' href='mystyles.css' type='text/css' />");
	out.println("	</head>");
						out.println("<body>");
						out.println("<fieldset><legend>Orders:</legend>");
						out.println("<h3 ALIGN=CENTER>Status Of Your Orders:</h3>");
						out.println("<table BORDER=1 ALIGN=CENTER>");
						out.println("<tr BGCOLOR='#FFAD00'>");
						out.println("<TH>Order Number<TH>Total Price<TH>First Name<TH>Last Name<TH>Address<TH>Contact No:<TH>Order Delivery Date<TH> Delivery Status</tr>");
						
						if(cursor.count() == 0){
								
								out.println("There are No existing orders");
							}
							else{
									//BasicDBObject obj=null;
									
									 while (cursor.hasNext()) {
										BasicDBObject obj = (BasicDBObject) cursor.next();
										orderList.add(obj.get("orderNumberDB"));
										firstNameList.add(obj.get("firstNameDB"));
										lastNameList.add(obj.get("lastNameDB"));
										deliveryList.add(obj.get("deliveryDateDB"));
										priceList.add(obj.get("productPriceDB"));
										phoneList.add(obj.get("phoneNumberDB"));
										addressList.add(obj.get("addressDB"));
										orderTime.add(obj.get("orderTime"));
																			
									  }
									  for (int i =0;i<orderList.size()&&i<firstNameList.size()&&i<lastNameList.size()&&i<deliveryList.size();i++) {  
												out.println("<tr><td>"+orderList.get(i)+" </td>");  
												out.println("<td>"+priceList.get(i)+"</td>");
												out.println("<td>"+firstNameList.get(i)+"</td>");
												out.println("<td>"+lastNameList.get(i)+"</td>");
												out.println("<td>"+addressList.get(i)+"</td>");
												out.println("<td>"+phoneList.get(i)+"</td>");
												out.println("<td>"+deliveryList.get(i)+"</td>");
												out.println("<form action='Progress.jsp'><td><input type='hidden' name='orderNumber' value='"+orderList.get(i)+"'><input type='submit' value='Check Status' name='status'></td></form>");
												//out.println("<td><progress value='22' max='100'></progress></td></tr>");
												
											}	
								}
										
													
			out.println("</table></fieldset>");
			
			out.println("<fieldset><legend>Cancel Order:</legend>");
			out.println("<h3>Cancel an order: </h3>");
			out.println("<form action='/PizzaParty/CustomerOrdConfirmServlet' method ='get'>");
			out.println("<table>");
			out.println("<tr><td> Please Provide Order Number: </td>");
			out.println("<td> <input type='text' name='customerOrderCancel'></input></td>");
			out.println("<td> <input type='submit' name = 'CustomerOperation' value='customerCancelOrder'/></td></tr>");
			out.println("</table></fieldset>");
			
			out.println("</form></body>");
			out.println("</html>");
			
	}
	
	protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + message + "</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
       // processRequest(request, response);
    }
	
	public void destroy()	{
      // do nothing.
	}
}