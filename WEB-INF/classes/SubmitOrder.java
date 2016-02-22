import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
import java.util.*;
import java.text.*;

public class SubmitOrder extends HttpServlet {
	
	
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		
		out.println("List size is : "+CartOperations.fetchCart().size());
        
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Buy Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + message + "</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Random r = new Random( System.currentTimeMillis() );
			int randomNumber= 10000 + r.nextInt(20000);	
			String tempBill = request.getParameter("price");
			String orderNumber=Integer.toString(randomNumber);
			String userID = null;
			String userType = null;
			HttpSession session = request.getSession(false);
			if(session != null){
				if(session.getAttribute("userIDDB") != null){
					userID = session.getAttribute("userIDDB").toString();
					userType =session.getAttribute("userTypeDB").toString();
				}
				else{
					userID = "guest";
					userType = "guest";
				}
				
			}
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.MINUTE, 30); // Adding 15 days
			String deliveryDate = simpleDateFormat.format(c.getTime()); //delivery date output
				String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");	
			String creditCard= request.getParameter("creditCard");
			String orderBy ="";
			
			
					
		try{
					if(userType.equals("customer")){
						orderBy="Self:"+" "+ userID;
						CartOperations.fetchCart().clear();
					}
					
					else if(userType.equals("admin")){
						orderBy="Customer :"+" "+ userID;
						CartOperations.fetchCart().clear();
					}
					else{
						CartOperations.fetchCart().clear();
					}
					
				
			// If database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("PizzaParty");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myOrders = db.getCollection("myOrders");
			System.out.println("Collection myOrders selected successfully");
				
			BasicDBObject doc = new BasicDBObject("title", "myOrders").
				append("userIDDB", userID).
				//append("productNameDB", productName).
				append("productPriceDB", tempBill).
				append("firstNameDB", firstName).
				append("lastNameDB", lastName).
				append("addressDB", address).
				append("phoneNumberDB", phoneNumber).
				append("creditCardDB", creditCard).
				append("deliveryDateDB",deliveryDate).
				append("orderNumberDB",orderNumber).
				append("orderByDB",orderBy);
				
				
			myOrders.insert(doc);
				
			System.out.println("Document inserted successfully"); 
			CartOperations.fetchCart().clear();
			//Send the response back to the JSP
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head> </head>");
			out.println("<body style= 'background-color:#F2F2F2'>");
			out.println("<center><h4>Thank you for shopping :)</h4></center>");
			out.println("<center><h3>Your Order Has Been Placed</h3></center>");
			out.println("<center><h4>Below are your order details</h4></center>");
			out.println("<table BORDER=1 ALIGN=CENTER>");
			out.println("<tr BGCOLOR='#FFAD00'>");
			out.println("<TH>Order Number<TH>Total Price<TH>First Name<TH>Last Name<TH>Address<TH>Contact No<TH>Order Delivery Time</tr>");
			out.println("<tr>");
			out.println("<td>"+orderNumber+ "</td>");
			out.println("<td>"+tempBill+ "</td>");
			
			out.println("<td>"+firstName+ "</td>");
			out.println("<td>"+lastName+ "</td>");
			out.println("<td>"+address+ "</td>");
			out.println("<td>"+phoneNumber+ "</td>");
			out.println("<td>"+deliveryDate+ "</td>");
			out.println("</tr>");
			out.println("<table>");
			out.println("<hr>");
			out.println("<tr>");
			out.println("<td>");
			if(userType.equals("guest")){
				out.println("<a href='/PizzaParty/MainPage'> MainPage </a>");
			}
			else{
				out.println("<a href='/PizzaParty/CustomerServlet'> MainPage </a>");
			}
			
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
			
		} catch (MongoException e) {
			
			showPage(response, e.toString());
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
     //   processRequest(request, response);
    }
	public void destroy()	{
      // do nothing.
	}
	
}