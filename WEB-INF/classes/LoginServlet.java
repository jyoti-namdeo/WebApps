/*
 * LoginServlet.java
 *
 */
 

import java.util.*;
import java.text.*;
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

public class LoginServlet extends HttpServlet {
   
    public void init() {
		
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		//invalidating sessions on startup
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession(false);
		
		//getting user action which button is pressed
		String userAction=request.getParameter("eventAction");
		
		//fetching from login three entries
		String userid = request.getParameter("userid");
        String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob").toString();
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		//generating signup date for new user
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");	
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		String userAdded = simpleDateFormat.format(c.getTime());
		String userCheck = request.getParameter("userType");
		
		//variable used for storing user in mongoDB describing who created account self or salesman.
		String userAddedBy="Self";
		
		//initiating mongoDB by listening to port and using DB name
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("PizzaParty");	
		
		
		
		if(userAction.equals("Login"))
		{
								DBCollection myLogin = db.getCollection("myLogin");
								BasicDBObject searchQuery = new BasicDBObject();
								searchQuery.put("userIDDB", userid);
								
								//cusrsor used to find for matching input
								DBCursor cursor = myLogin.find(searchQuery);
								
								//if no user name found then this block will get triggered
								if(!cursor.hasNext()){
										showPage(response, "User not found");
									}
									
								if(session==null)		//check for session 
											{								
												session= request.getSession();
												session.setAttribute("userIDDB", userid);
												session.setAttribute("userPasswordDB", password);
												session.setAttribute("userTypeDB", userType);
											} 
								if(userType.equals("admin"))
								{
									response.sendRedirect("/PizzaParty/AdminServlet");
					
								}
								else if(userType.equals("customer"))
								{
									response.sendRedirect("/PizzaParty/CustomerServlet");
								}
								//response.sendRedirect("/PizzaParty/MainPage");		
		}
		if(userAction.equals("NewUser"))
		{
									// If the collection does not exists, MongoDB will create it for you
										DBCollection myReviews = db.getCollection("myLogin");
										
									//fields which will be inserted into DB
										BasicDBObject doc = new BasicDBObject("title", "MongoDB")
										.append("userIDDB", userid)
										.append("userPasswordDB", password)
										.append("phoneDB", phone)
										.append("emailDB", email)
										.append("addressDB", address)
										.append("userTypeDB", userType)
										.append("userAddedDB",userAdded)
										.append("userAddedByDB",userAddedBy);
										myReviews.insert(doc);
												
											if(session==null)		//check for session 
											{								
												session= request.getSession();
												session.setAttribute("userIDDB", userid);
												session.setAttribute("userPasswordDB", password);
												session.setAttribute("userTypeDB", userType);
											} 
			//after action is completed will move to MainPage servlet
			//response.sendRedirect("/PizzaParty/MainPage");
			if(userType.equals("admin"))
								{
									response.sendRedirect("/PizzaParty/AdminServlet");
					
								}
								else if(userType.equals("customer"))
								{
									response.sendRedirect("/PizzaParty/CustomerServlet");
								}
								
			}
			
	
			
	}
    /**
     * Actually shows the <code>HTML</code> result page
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
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
       // processRequest(request, response);
    } 

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}
