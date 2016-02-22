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
import java.text.*;

public class CustomerOrdConfirmServlet extends HttpServlet {
	
	
	
	public void init() throws ServletException{
      	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request, response);
		
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
				DB db=null;
				String 	customerOperation  =request.getParameter("CustomerOperation");
				String	customerOrder =request.getParameter("customerOrder");	
				String  customerOrderCancel =request.getParameter("customerOrderCancel");
				
				MongoClient mongo = new MongoClient("localhost", 27017);
				db = mongo.getDB("PizzaParty");
				
			try{	
				if(customerOperation.equals("customerCancelOrder"))
				{		
						String orderDate=null;
						long diffDays=0;
						Date d1 = null;
						Date d2 = null;
						int check=0;
						Date date = new Date();
						SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						
						String orderNumber= request.getParameter("customerOrderCancel");
						
						
						DBCollection myorders = db.getCollection("myOrders");
						BasicDBObject obj1  = new BasicDBObject();
						obj1.put("orderNumberDB", orderNumber );
						
						DBCursor cursor = myorders.find(obj1);
						while (cursor.hasNext()) {
							BasicDBObject obj = (BasicDBObject) cursor.next();
							orderDate = obj.getString("deliveryDateDB");
						}
						
						String today=dateFormat.format(date);
						Date date1 = new Date(orderDate);
						String past=dateFormat.format(date1);
						
						
						d1 = format.parse(past);
						d2 = format.parse(today);
						
						long diff = d1.getTime()- d2.getTime();
						diffDays = diff / (24 * 60 * 60 * 1000);
						
						
						String out = Long.toString(diffDays);
						check = Integer.parseInt(out);
						if(check>5)
						{
							myorders.remove(obj1);
							showPage(response, "Your Order has been cancelled :)" );
						}
						else
						{
							showPage(response, "Your Order cannot be cancelled as the date exceeds our cancellation policy :(" );
						}	
											
				}
			}
			catch(Exception E)
			{
				showPage(response, E.toString());
			}
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
		out.println("<a href='/PizzaParty/MainPage'>Index</a>");
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