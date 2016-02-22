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
import java.util.*;
import java.util.Random;

public class AdminConfirmServlet extends HttpServlet {
	Random randomGenerator = new Random();
	public void init() throws ServletException{
      	
		}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
    }
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {		
			String action= request.getParameter("action");
			//variables for adding new item
			String pType=request.getParameter("addProductType");
			String pID= request.getParameter("addProductID");
			
			String pName= request.getParameter("addProductName");
			String pDesc = request.getParameter("addProductDesc");
			String pPrice= request.getParameter("addProductPrice");
			int randomInt = -1;
			
			String pImage= request.getParameter("imageUrl");
			
			//variables for updating an item
			String updateProductType=request.getParameter("updateProductType");
			String updateProductStr=request.getParameter("updateProductID");
			
			String updateProductName=request.getParameter("updateName");
			String updateProductDesc=request.getParameter("updateDesc");
			String updateProductPriceStr=request.getParameter("updatePrice");
			
			//variables for deleting an item
			String delProductType = request.getParameter("delProductType");
			String delProductStr = request.getParameter("delProductID");
			
			PrintWriter out = response.getWriter();
				
			if(action.equals("ADD"))
			{
						int pAddID = Integer.parseInt(pID);
						int pAddPrice = Integer.parseInt(pPrice);
						int randomInt1 = randomGenerator.nextInt(10)+1;
						if(randomInt1>=1 && randomInt1<3){
							randomInt = 1;
						}
						else if(randomInt1>=3 && randomInt1<6 ){
							randomInt = 2;
						}
						else{
							randomInt = 3;
						}
						
						switch(pType){
							case "Deserts":
							{
									String defaultimageUrl = "/PizzaParty/images/defaultDesert"+randomInt+".jpg";
									try{
									MongoClient mongo = new MongoClient("localhost", 27017);
									// if database doesn't exists, MongoDB will create it for you
									DB db = mongo.getDB("PizzaParty");
									DBCollection myReviews = db.getCollection("Deserts");
										BasicDBObject doc = new BasicDBObject("title", "myReviews").
									append("id", pAddID).
									append("name", pName).
									append("desc", pDesc).
									append("image", defaultimageUrl).
									append("price", pAddPrice);
														
									myReviews.insert(doc);
								}
								catch(Exception e){
									out.println("Error in DB Creation.");
								}
								break;
							}
							case "Pizza":
							{
								try{
									String defaultimageUrl = "/PizzaParty/images/defaultPizza"+randomInt+".jpg";
									MongoClient mongo = new MongoClient("localhost", 27017);
									// if database doesn't exists, MongoDB will create it for you
									DB db = mongo.getDB("PizzaParty");
									DBCollection myReviews = db.getCollection("Pizza");
									BasicDBObject doc = new BasicDBObject("title", "myReviews").
									append("id", pAddID).
									append("name", pName).
									append("desc", pDesc).
									append("image", defaultimageUrl).
									append("price", pAddPrice);
														
									myReviews.insert(doc);
								}
								catch(Exception e){
									out.println("Error in DB Creation.");
								}
								break;
							}
							case "Bread":
							{
								try{
									String defaultimageUrl = "/PizzaParty/images/defaultBread"+randomInt+".jpg";
									MongoClient mongo = new MongoClient("localhost", 27017);
									// if database doesn't exists, MongoDB will create it for you
									DB db = mongo.getDB("PizzaParty");
									DBCollection myReviews = db.getCollection("Bread");
										BasicDBObject doc = new BasicDBObject("title", "myReviews").
									append("id", pAddID).
									append("name", pName).
									append("desc", pDesc).
									append("image", defaultimageUrl).
									append("price", pAddPrice);
														
									myReviews.insert(doc);
								}
								catch(Exception e){
									out.println("Error in DB Creation.");
								}
								break;
							}
							case "Drinks":
							{
								try{
									String defaultimageUrl = "/PizzaParty/images/defaultDrinks"+randomInt+".jpg";
									MongoClient mongo = new MongoClient("localhost", 27017);
									// if database doesn't exists, MongoDB will create it for you
									DB db = mongo.getDB("PizzaParty");
									DBCollection myReviews = db.getCollection("Drinks");
										BasicDBObject doc = new BasicDBObject("title", "myReviews").
									append("id", pAddID).
									append("name", pName).
									append("desc", pDesc).
									append("image", defaultimageUrl).
									append("price", pAddPrice);
														
									myReviews.insert(doc);
								}
								catch(Exception e){
									out.println("Error in DB Creation.");
								}
								break;
							}
							
						}
				
						
						out.println("<html>");
						//out.println("<head><title>ADD PRODUCT</title><center><h3>NEW PRODUCT ADDED</h3></center></head>");
						//+New header
						out.println("<head>");
						out.println("<title>Success</title>");
						out.println("<table id ='headbg' cell spacing = '2' border = '2' style='width:100%'>");
						out.println(" <tr BGCOLOR='#FFAD00'>");
						out.println(" <td colspan ='50'>");
						out.println(" <h1><center>Item added in Menu</center></h1>");
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
						//-Header
						out.println("<body style= 'background-color:#F2F2F2'>");
						
						out.println("<fieldset>");
						out.println("<legend>New Product information:</legend>");
						out.println("<table BORDER=1 ALIGN=CENTER>");
						out.println("<tr BGCOLOR='#FFAD00'>");
						out.println("<th>PRODUCT TYPE:<TH> PRODUCT ID:<th> PRODUCT NAME:<th> PRODUCT DESCRIPTION:<th> PRODUCT PRICE:</tr>");
						out.println("<tr><td><input type='text' name='productType' readonly value="+pType+ "></td>");
						out.println("<td> <input type='text' name='productID' readonly value="+pID+ "> </td>");
						out.println("<td> <input type='text' name='productName' readonly value="+pName+ "> </td>");
						out.println("<td> <input type='text' name='productDesc' readonly value="+pDesc+ "> </td>");
						out.println("<td> <input type='text' name='productPrice' readonly value="+pPrice+ "> </td></tr>");
						out.println("</table></fieldset>");
						out.println("<center><h2>Return To Previous Page</h2><a href='/PizzaParty/AdminServlet'>Back<center>");
						out.println("</body></html>");
			}
			
			if(action.equals("UPDATE"))
			{
				int updateProductID = Integer.parseInt(updateProductStr);
				int updateProductPrice = Integer.parseInt(updateProductPriceStr);
				MongoClient mongo = new MongoClient("localhost", 27017);
				// if database doesn't exists, MongoDB will create it for you
				DB db = mongo.getDB("PizzaParty");
				DBCollection myReviews = null;
				//Decide the database to add elements
				if (updateProductType.equals("Pizza")) {
					myReviews = db.getCollection("Pizza");
				} else if (updateProductType.equals("Bread")) {
					myReviews = db.getCollection("Bread");
				} else if (updateProductType.equals("Deserts")) {
					myReviews = db.getCollection("Deserts");
				} else if (updateProductType.equals("Drinks")) {
					myReviews = db.getCollection("Drinks");
				} 
				//-Decide
				BasicDBObject updateQuery1 = new BasicDBObject();
							updateQuery1.append("$set", new BasicDBObject()
							.append("id",updateProductID)
							.append("name",updateProductName )
							.append("desc", updateProductDesc)
							.append("price", updateProductPrice)
				);
					
				BasicDBObject searchQuery = new BasicDBObject().append("id", updateProductID);
				myReviews.update(searchQuery,updateQuery1);
				out.println("Product got Updated successfully");

						
						showPage(response, "Item has been Updated successfully");
						
						//PrintWriter out = response.getWriter();
						out.println("<html>");
						//out.println("<head><title>ADD PRODUCT</title><center><h3>NEW PRODUCT ADDED</h3></center></head>");
							out.println("<head>");
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

						out.println("    <td  class='head' colspan='5'><center><a href='#' class ='anchorhead'>Weekly Deals</a></center></td>");

						out.println("  <td class='head' colspan='5'><center><a href='#' class ='anchorhead'>Contact Us</a></center></td>");
						out.println("      </tr>");
						out.println("	</table></center>");
						out.println("    <link rel='stylesheet' href='mystyles.css' type='text/css' />");
						out.println("	</head>");
						//Header
						out.println("<body style= 'background-color:#F2F2F2'>");
						
						out.println("<fieldset>");
						out.println("<legend>New Product information:</legend>");
						out.println("<table BORDER=1 ALIGN=CENTER>");
						out.println("<tr BGCOLOR='#FFAD00'>");
						out.println("<th>PRODUCT TYPE:<TH> PRODUCT ID:<th> PRODUCT NAME:<th> PRODUCT DESCRIPTION:<th> PRODUCT PRICE:</tr>");
						out.println("<tr><td><input type='text' name='productType' readonly value="+pType+ "></td>");
						out.println("<td> <input type='text' name='productID' readonly value="+pID+ "> </td>");
						out.println("<td> <input type='text' name='productName' readonly value="+pName+ "> </td>");
						out.println("<td> <input type='text' name='productDesc' readonly value="+pDesc+ "> </td>");
						out.println("<td> <input type='text' name='productPrice' readonly value="+pPrice+ "> </td></tr>");
						out.println("</table></fieldset>");
						out.println("<center><h2>Return To Previous Page</h2><a href='/PizzaParty/AdminServlet'>Back<center>");
						out.println("</body></html>");
				
			}
			if(action.equals("DELETE"))
			{ 
							int delProductID = Integer.parseInt(delProductStr);
							switch(delProductType){
					
							case "Pizza":
							{
								try{
									MongoClient mongo = new MongoClient("localhost", 27017);
									// if database doesn't exists, MongoDB will create it for you
									DB db = mongo.getDB("PizzaParty");
									DBCollection myReviews = db.getCollection("Pizza");
									BasicDBObject obj1  = new BasicDBObject();
									obj1.put("id", delProductID );
									myReviews.remove(obj1);
								}
								catch(Exception e){
									out.println("Error in DB Creation.");
								}
								break;
							}
							case "Bread":
							{
								try{
									out.println("Delete product ID and prodtype are :"+delProductID+" "+delProductType);
									MongoClient mongo = new MongoClient("localhost", 27017);
									// if database doesn't exists, MongoDB will create it for you
									DB db = mongo.getDB("PizzaParty");
									DBCollection myReviews = db.getCollection("Bread");
									BasicDBObject obj1  = new BasicDBObject();
									obj1.put("id", delProductID );
									myReviews.remove(obj1);
								}
								catch(Exception e){
									out.println("Error in DB Creation.");
								}
								break;
							}
							case "Deserts":
							{
								try{
									out.println("Delete product ID and prodtype are :"+delProductID+" "+delProductType);
									MongoClient mongo = new MongoClient("localhost", 27017);
									// if database doesn't exists, MongoDB will create it for you
									DB db = mongo.getDB("PizzaParty");
									DBCollection myReviews = db.getCollection("Deserts");
									BasicDBObject obj1  = new BasicDBObject();
									obj1.put("id", delProductID );
									myReviews.remove(obj1);
								}
								catch(Exception e){
									out.println("Error in DB Creation.");
								}
								break;
							}
							case "Drinks":
							{
								try{
									out.println("Delete product ID and prodtype are :"+delProductID+" "+delProductType);
									MongoClient mongo = new MongoClient("localhost", 27017);
									// if database doesn't exists, MongoDB will create it for you
									DB db = mongo.getDB("PizzaParty");
									DBCollection myReviews = db.getCollection("Drinks");
									BasicDBObject obj1  = new BasicDBObject();
									obj1.put("id", delProductID );
									myReviews.remove(obj1);
								}
								catch(Exception e){
									out.println("Error in DB Creation.");
								}
								break;
							}
														
						}
						showPage(response, "Item has been deleted successfully");
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
	
	
	public void destroy()	{
      // do nothing.
	}
	
}