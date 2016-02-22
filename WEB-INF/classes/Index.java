import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;

public class Index extends HttpServlet {
	
	
	
	
	
	public void init() throws ServletException{
      	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
	PrintWriter out = response.getWriter();
	out.println("<html><head>");
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
	/*out.println("<html><head> <title>PizzaParty</title>");
	out.println("<center><table cell spacing = '2' border = '2' background ='/PizzaParty/images/3Cheese500.jpg' style='width:100%' >");
	out.println("<tr><td colspan ='50' background ='/PizzaParty/images/3Cheese500.jpg'><h1><u><center>PizzaParty.com</center> </u></h1>");	
	out.println("<div align = 'Right' >"); 
	out.println("</tr>");
	out.println("<br><tr>");
	out.println("<td  class='head' colspan='10'><center><a href='welcomepage.html' class ='anchorhead'>Weekly Deals</a></center></td>");
    out.println("<td class='head' colspan='10'><center><a href='contact.html' class ='anchorhead'>Contact Us</a></center></td>");
	out.println("</tr></table>");
	
	out.println(" <link rel='stylesheet' href='mystyles.css' type='text/css' /></head>");*/
	out.println("<body style= 'background-color:#F2F2F2'>");
	out.println("<div align = 'center'>");
	out.println("<table style='width:1100'><h5>");
	out.println("<td rowspan = '5' colspan = '5'><center><div style='width:1150px; height:600px; margin:0 auto; margin-left: auto; margin-right: auto' >");
	

	out.println("<font color='Black'><p><h3>With a PizzaParty's account, you can save your favorite orders, delivery addresses, and payment information. You'll speed through checkout and will be eating pizza before you know it! And yes, You can customize your favorite Pizza...</h3></p></font>");

	out.println("<h3>Login/Signup To Continue</h3>");
	out.println("<form method='post' action='LoginServlet'>");
	out.println("<table BORDER=1 ALIGN=CENTER>");
	out.println("<tr><th BGCOLOR='#FFAD00'>User Name<td><input style='margin-left:5px' type='TEXT' size='15' name='userid'></td></tr>");
	out.println("<tr><th BGCOLOR='#FFAD00'>Password<td><input style='margin-left:5px' type='PASSWORD' size=15 name='password'/></td></tr>");
	out.println("<tr><th BGCOLOR='#FFAD00'>DOB<td><input style='margin-left:5px' type='date' size='15' name='dob'></td></tr>");
	out.println("<tr><th BGCOLOR='#FFAD00'>email<td><input style='margin-left:5px' type='TEXT' size='15' name='email'></td></tr>");
	out.println("<tr><th BGCOLOR='#FFAD00'>Phone<td><input style='margin-left:5px' type='TEXT' size='15' name='phone'></td></tr>");
	out.println("<tr><th BGCOLOR='#FFAD00'>Address<td><input style='margin-left:5px' type='TEXT' size='15' name='address'></td></tr>");
	out.println("<tr><th BGCOLOR='#FFAD00'>User Type<td><input type='radio' name='userType' value='admin'>Admin<br>");
	out.println("<input type='radio' name='userType' value='customer' >Customer<br>");
	out.println("</table><br><br>");
	out.println("<input  type='submit' name='eventAction' value='Login'/><input  type='submit' name='eventAction' value='NewUser'/>");
	out.println("</form></div></center></td></tr>");
	
	out.println("</h5></table></div><br>");
	
	out.println("<hr color ='black'>");
	out.println("<table style= 'background-color:#F2F2F2'><tr><td class ='table3'><a class = 'footer1' href='contact.html'>About Us</a></td> <td class ='table3'><a class = 'footer1' href='contact.html'>FeedBack</a></td><td class ='table3'><a class = 'footer1' href='contact.html'>Help</a></td></tr></table></body></html>");
		}
	
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
	
	public void destroy(){
      // do nothing.
	}
}