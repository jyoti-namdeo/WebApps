import javax.servlet.*;
import javax.servlet.http.*;
public class CheckServlet extends HttpServlet {
   
   
    /** 
     * Initializes the servlet with some usernames/password
    */  
    public void init() {
		
                //users.put("test", "TEST");
    }

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		String userType="";
		HttpSession session = request.getSession();
		
		
				if(session==null)
				{
					showPage(response, "No session found Please Login to continue");
				}
				else
					userType=session.getAttribute("userTypeDB").toString();
			
				if(userType.equals("admin"))
				{
					response.sendRedirect("/PizzaParty/AdminServlet");
					
				}
				else if(userType.equals("customer"))
				{
					response.sendRedirect("/PizzaParty/CustomerOrderServlet");
				}
				
				else
				{
				
				showPage(response, "invalid parameter provided");

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
		out.println("<a href='welcome.html'>Index</a>");
		out.println("</body>");
        out.println("</html>");
        out.close();
 
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
       
		processRequest(request, response);
    }
}
