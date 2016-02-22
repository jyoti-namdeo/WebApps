

import java.io.*;
import java.util.*;
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
/** Base class for pages showing catalog entries.
 *  Servlets that extend this class must specify
 *  the catalog entries that they are selling and the page
 *  title <I>before</I> the servlet is ever accessed. This
 *  is done by putting calls to setItems and setTitle
 *  in init.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class DesertsServlet extends HttpServlet {
  
  
  public void init() throws ServletException{
      	 
	}
   
  
  /** First display title, then, for each catalog item,
   *  put its short description in a level-two (H2) heading
   *  with the price in parentheses and long description
   *  below. Below each entry, put an order button
   *  that submits info to the OrderPage servlet for
   *  the associated catalog entry.
   *  <P>
   *  To see the HTML that results from this method, do
   *  "View Source" on KidsBooksPage or TechBooksPage, two
   *  concrete classes that extend this abstract class.
   */
  protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + message + "</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }
  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					//+Fetch the details of product and show in html page
					//Reading form product file
					ServletContext sc = request.getServletContext();
					//Retrieve from mongoDB
					try{
						//Connect to Mongo DB
						MongoClient mongo = new MongoClient("localhost", 27017);
									
						// if database doesn't exists, MongoDB will create it for you
						DB db = mongo.getDB("PizzaParty");
						
						DBCollection myReviews = db.getCollection("Deserts");
						
						DBCursor cursor = myReviews.find(); 
						out.println("<html><head><title>Product List</title></head><body style= 'background-color:#CEECF5'>");
						while (cursor.hasNext()) {
							BasicDBObject obj = (BasicDBObject) cursor.next();
							int id = obj.getInt("id"); //was id
							String name = obj.getString("name"); //was id
							String desc = obj.getString("desc"); //was name
							//String desc = "Hello";//obj.getString("image");
							String imageSrc = obj.getString("image");
							int price = obj.getInt("price");
			
					out.println("<form action ='/PizzaParty/ShoppingCartOperationsServlet' method ='get'>");
					out.println("<input type='hidden' name='name' value="+name+">");
					out.println("<input type='hidden' name='desc' value="+desc+">");
					out.println("<input type='hidden' name='id' value="+id+">");
					out.println("<input type='hidden' name='flag' value='one'>");
					out.println("<input type='hidden' name='price' value="+price+">");
					out.println("<input type='hidden' name='quantity' value=1>");
					
					out.println("<HR COLOR='BLACK'>\n");
					out.println("<h2>"+name+" </h2>");// "+name+" "+desc+" "+price+"</h1>");
					//+Adding data in table
					out.println("<table>");
					out.println("<tr>");
					out.println("<td>");
					out.println("<img id='background' height='150' width='500' src='"+imageSrc+" '>");
					out.println("</td><td>");
					out.println("<h3 align='right'>Price $"+price+"</h3>");
					out.println("");
								
						out.println("<select align='right' name='pizzaSize'>");
						  out.println("<option value='small'>4 Pieces</option>");
						  out.println("<option value='medium'>8 Pieces - +$4</option>");
						  out.println("<option value='large'>12 Pieces - +$7</option>");
						out.println("</select><br><br>");
					out.println("<input type = 'submit' name = 'action' value = 'Place Order' style='float: right;' >");
					out.println("</td><td style='margin-left 20px'");
					out.println("<div  align='right' style='width:200px; height:50px;'>");
					out.println(desc);
					out.println("</div>");
					out.println("</td></tr>");
					out.println("</table>");
					//-
					//out.println("<img id='background' height='300' width='300' src='"+imageSrc+" '>");
					//out.println("<CENTER><input type = 'submit' name = 'action' value = 'AddToCart' ></CENTER>");
					out.println("</form>");
					out.println("<HR COLOR='BLACK'>\n");
						}
						out.println("</body></html>");
					}
					catch(Exception e){
						e.printStackTrace();
					}
					//-Mongo
	
	    }
    
    
  
}