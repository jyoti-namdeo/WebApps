import java.io.*;
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
import javax.servlet.*;
import javax.servlet.http.*;

public class ReviewServlet extends HttpServlet {
	
	
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				  processRequest(request, response);
		
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
			HttpSession session= request.getSession();
			PrintWriter out = response.getWriter();
			//String name=request.getParameter();
			String productCategory=request.getParameter("productCategory");
			String productName = request.getParameter("productName");
			String ManufacturerName =  request.getParameter("manufacturerName");
			String retailerName = "PizzaParty";
			String pPrice=request.getParameter("price");
			String rebateAvailable = "";
			
			String userName = (String)session.getAttribute("userIDDB");
			String userType = (String)session.getAttribute("userTypeDB");
		
		if(userType.equals("storemanager")){
			
			rebateAvailable="Yes";
		}	
		else if(userType.equals("customer")){
			
			rebateAvailable="Yes";
		}
		else if(userType.equals("salesman")){
			
			rebateAvailable="No";
		}	
			
			out.println("<html>");
			out.println("<head><title>Review</title></head>");
			out.println("<body><h3>"+productName+"</h3>");
			out.println("<form method='get' action='SubmitReview'>");
			out.println("<fieldset><legend>Product information:</legend>");
			out.println("<table>");
			out.println("<tr><td> Manufacturer Name: </td>");
			out.println("<td> <input type='text' name='manufacturerName' readonly  value ="+ManufacturerName+"></input></td></tr>");
			out.println("<tr><td> Product Name: </td>");
			out.println("<td> <input type='text' name='productName' readonly  value ="+productName+" /></td></tr>");
			out.println("<tr><td> Product Category: </td>");
			out.println("<td><input type='text' name='productCategory' readonly  value ="+productCategory+"></input></td></tr>");
			out.println("<tr><td> Product Price: </td>");
			out.println("<td> <input type='text' name='productPrice' readonly  value ="+pPrice+" ></input>$</td></tr>");
			out.println("<tr><td> Retailer Name: </td>");
			out.println("<td> <input type='text' name='retailerName' readonly  value =" +retailerName+ "></input></td></tr>");
			out.println("<tr><td> Retailer City: </td>");
			out.println("<td><input type='text' name='retailerCity'></td></tr>");
			out.println("<tr><td> Retailer State: </td>");
			out.println("<td> <input type='text' name='retailerState'></td></tr>");
			out.println("<tr><td> Retailer Zip: </td>");
			out.println("<td> <input type='text' name='retailerZip'> </td></tr>");
			out.println("</table></fieldset>");
			out.println("<fieldset><legend>Reviews:</legend><table>");
			out.println("<tr><td> Product On Sale: </td>");
			out.println("<td> <input type='text' name='productOnSale' readonly value = 'Yes'></input> </td></tr>");
			out.println("<tr><td> Manufacturer Rebate: </td>");
			out.println("<td> <input type='text' name='rebateAvailable' readonly  value =" +rebateAvailable+ "></input></td></tr>");
			out.println("<tr><td> User Name: </td>");
			out.println("<td> <input type='text' name='userName' readonly  value ="+userName+" ></input></td></tr>");
			out.println("<tr><td> User Age: </td><td> <input type='number' name='userAge'></input></tr>");
			out.println("<tr><td> User Gender: </td><td> <select name='gender'><option value='Male' selected>Male</option><option value='Female'>Female</option></select></td></tr>");
			out.println("<tr><td> User Occupation: </td><td> <input type='text' name='userOccupation'></input> </td></tr>");
			out.println("<tr><td> Review Rating: </td><td><select name='reviewRating'><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></td></tr>");
			out.println("<tr><td> Review Date: </td><td> <input type='date' name='reviewDate'> </input></td></tr>");
			out.println("<tr><td> Review Text: </td><td><textarea name='reviewText' rows='4' cols='50'> </textarea></td></tr>");
			out.println("</table><br><br><input type='submit' value='Submit Review'></input></fieldset></form>");
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
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
      
    }
	
	public void destroy()	{
      // do nothing.
	}
	
}